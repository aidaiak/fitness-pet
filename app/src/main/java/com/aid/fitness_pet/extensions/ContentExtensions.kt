package com.aid.fitness_pet.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun Context.showToast(message: String, length: Int? = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length!!).show()
}

fun View.showKeyboard() {
    requestFocus()
    val imm: InputMethodManager? = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun Fragment.replace(
    target: Fragment,
    layoutRes: Int = android.R.id.content,
    fragmentManager: FragmentManager = requireActivity().supportFragmentManager,
    addToBackStack: String = target::class.java.name,
    include: Boolean = true
) {
    fragmentManager.beginTransaction()
        .replace(layoutRes, target)
        .apply {
            if (include) addToBackStack(addToBackStack)
        }
        .commitAllowingStateLoss()
}


fun AppCompatActivity.replace(
    target: Fragment,
    layoutRes: Int = android.R.id.content,
    fragmentManager: FragmentManager = supportFragmentManager,
    addToBackStack: String = target::class.java.name,
    include: Boolean = true
) {
    fragmentManager.beginTransaction()
        .replace(layoutRes, target)
        .apply {
            if (include) addToBackStack(addToBackStack)
        }
        .commitAllowingStateLoss()
}