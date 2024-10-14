package dev.marcosfarias.pokedex

import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dev.marcosfarias.pokedex.screen.MainScreen
import dev.marcosfarias.pokedex.screen.MovesScreen
import dev.marcosfarias.pokedex.screen.PAKAGE
import org.junit.After
import org.junit.Before
import org.junit.Test

class MovesScreenTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @Before
    fun setUp() {
        device.apps.launch(PAKAGE)
        device.uiDevice.waitForIdle()
    }

    @After
    fun tearDown() {
        device.apps.kill(PAKAGE)
    }

    @Test
    fun checkingMovesScreenTest() {
        run {
            MainScreen.getMenuItemByTitle("Moves").click()

            MovesScreen {
                pokedex.isDisplayed()

                step("Check menu elements content") {
                    getItemByTitle("Bulbasaur").isDisplayed()
                    getItemByTitle("Ivysaur").isDisplayed()
                    getItemByTitle("Venusaur").isDisplayed()
                    getItemByTitle("Charmander").isDisplayed()
                    getItemByTitle("Charmeleon").isDisplayed()
                    getItemByTitle("Charizard").isDisplayed()
                    getItemByTitle("Squirtle").isDisplayed()
                    getItemByTitle("Wartortle").isDisplayed()
                    getItemByTitle("Blastoise").isDisplayed()
                    getItemByTitle("Caterpie").isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkingAllGenTest() {
        run {
            MainScreen.getMenuItemByTitle("Moves").click()
            device.uiDevice.waitForIdle()

            step("Check elements") {
                MovesScreen {
                    pokedex.isDisplayed()
                    settings.click()
                    allGen.click()

                    getGenerationItemByTitle("Generation I").isDisplayed()
                    getGenerationItemByTitle("Generation II").isDisplayed()
                    getGenerationItemByTitle("Generation III").isDisplayed()
                    getGenerationItemByTitle("Generation IV").isDisplayed()
                    getGenerationItemByTitle("Generation V").isDisplayed()
                    getGenerationItemByTitle("Generation VI").isDisplayed()
                    getGenerationItemByTitle("Generation VII").isDisplayed()
                    getGenerationItemByTitle("Generation VIII").isDisplayed()
                }
            }
        }
    }
}