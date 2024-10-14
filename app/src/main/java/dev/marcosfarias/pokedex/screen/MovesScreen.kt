package dev.marcosfarias.pokedex.screen

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object MovesScreen : UiScreen<MovesScreen>() {

    override val packageName: String = PAKAGE

    val pokedex = UiTextView { withText("Pokedex") }


    fun getItemByTitle(title: String): UiTextView {
        return UiTextView {
            withId(PAKAGE, "textViewName")
            withText(title)
        }
    }

    val settings = UiButton {  withId(PAKAGE, "sd_main_fab")  }
    val allGen = UiButton {
        withId(PAKAGE, "sd_label")
        withText("All Gen")
    }

    val generation = UiTextView { withText("Generation") }

    fun getGenerationItemByTitle(title: String): UiTextView {
        return UiTextView {
            withId(PAKAGE, "textViewTitle")
            withText(title)
        }
    }
}