package dev.marcosfarias.pokedex

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dev.marcosfarias.pokedex.screen.MainScreen
import dev.marcosfarias.pokedex.screen.PAKAGE
import org.junit.Rule
import org.junit.Test
import java.io.File

class MainScreenTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @Test
    fun checkingMainScreenTest() {
        before {
            device.uiDevice.wakeUp()
            device.uiDevice.pressHome()

            println("Install package")
            val testContext = device.context
            val apk = testContext.resources.openRawResource(dev.marcosfarias.pokedex.test.R.raw.pokedex)

            val context = ApplicationProvider.getApplicationContext<Context>()
            val temp = File(context.filesDir, "/pokedex.apk")

            temp.writeBytes(apk.readBytes())
            println("absolutePath: " + temp.absolutePath)

            device.uiDevice.executeShellCommand("pm clear")
            val result =
                device.uiDevice.executeShellCommand("pm install -t -r " + temp.absolutePath)
            println("Installation result: $result")

            Thread.sleep(1000)
            device.apps.launch(PAKAGE)
            device.uiDevice.waitForIdle()
            Thread.sleep(3000)
        }.after {
           device.apps.kill(PAKAGE)
        }.run {
            MainScreen {
                searchText {
                    isDisplayed()
                }

                step("Check menu elements visibility") {
                    getMenuItemByTitle("Pokedex").isDisplayed()
                    getMenuItemByTitle("Moves").isDisplayed()
                    getMenuItemByTitle("Abilities").isDisplayed()
                    getMenuItemByTitle("Items").isDisplayed()
                    getMenuItemByTitle("Locations").isDisplayed()
                    getMenuItemByTitle("Type Charts").isDisplayed()
                }

                step("Check news elements visibility") {
                    getMenuItemByTitle("Pokémon Rumble Rush Arrives Soon").isDisplayed()
                    getNewsItem(1).isDisplayed()
                }
            }
        }
    }
}