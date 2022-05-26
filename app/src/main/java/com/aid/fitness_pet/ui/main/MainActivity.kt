package com.aid.fitness_pet.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aid.fitness_pet.ui.auth.EnterPhoneFragment
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replace(EnterPhoneFragment())
    }
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

