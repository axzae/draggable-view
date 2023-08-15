package io.github.hyuwah.draggableview.utils

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T,
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}

inline fun <reified T> Activity.launch() {
    startActivity(Intent(this, T::class.java))
}

val Int.px2dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Float.px2dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
