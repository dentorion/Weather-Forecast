package com.entin.weather.core.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Helps to work with Epoxy in kotlin modern way
 */

abstract class EpoxyKotlinHolder : EpoxyHolder() {
    private lateinit var view: View

    override fun bindView(itemView: View) {
        view = itemView
    }

    protected fun <V : View> bind(id: Int): ReadOnlyProperty<EpoxyKotlinHolder, V> =
        Lazy { holder: EpoxyKotlinHolder, prop ->
            holder.view.findViewById(id) as V?
                ?: throw IllegalStateException("View ID $id for '${prop.name}' not found.")
        }

    /**
     * Taken from Kotterknife.
     * https://github.com/JakeWharton/kotterknife
     */
    private class Lazy<V>(
        private val initializer: (EpoxyKotlinHolder, KProperty<*>) -> V
    ) : ReadOnlyProperty<EpoxyKotlinHolder, V> {
        private object EMPTY

        private var value: Any? = EMPTY

        override fun getValue(thisRef: EpoxyKotlinHolder, property: KProperty<*>): V {
            if (value == EMPTY) {
                value = initializer(thisRef, property)
            }
            @Suppress("UNCHECKED_CAST")
            return value as V
        }
    }
}