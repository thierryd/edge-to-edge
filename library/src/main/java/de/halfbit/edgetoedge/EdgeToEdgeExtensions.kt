package de.halfbit.edgetoedge

import android.app.Activity
import android.app.Dialog
import androidx.fragment.app.Fragment

inline fun Fragment.edgeToEdge(block: EdgeToEdge.() -> Unit) {
    val rootView = requireNotNull(view) { "fragment.view must not be null, fragment: $this" }
    val window = requireNotNull(activity?.window) { "fragment's activity must be not null" }
    EdgeToEdge(rootView, window).also(block).build()
}

inline fun Dialog.edgeToEdge(block: EdgeToEdge.() -> Unit) {
    val window = requireNotNull(window) { "Dialog's window must be not null" }
    EdgeToEdge(window.decorView, window).also(block).build()
}

inline fun Activity.edgeToEdge(block: EdgeToEdge.() -> Unit) {
    val window = requireNotNull(window) { "Dialog's window must be not null" }
    EdgeToEdge(window.decorView, window).also(block).build()
}
