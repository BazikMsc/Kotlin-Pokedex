package dev.marcosfarias.pokedex.screen

import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

const val PAKAGE = "dev.marcosfarias.pokedex"

object MainScreen : UiScreen<MainScreen>() {
    override val packageName: String = PAKAGE

    val searchText = UiTextView { withId(PAKAGE,"search_text") }

    fun getMenuItemByTitle(title: String): UiTextView {
        return UiTextView {
            withId(PAKAGE, "textViewName")
            withText(title)
        }
    }

    fun getNewsItem(index: Int): UiTextView {
        return UiTextView {
            withIndex(index) {
                withId(PAKAGE, "textViewName")
                withText("Pokémon Rumble Rush Arrives Soon")
            }
        }
    }
}
