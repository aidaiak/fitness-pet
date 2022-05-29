package com.aid.fitness_pet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.aid.fitness_pet.R
import com.aid.fitness_pet.databinding.FragmentHomeBinding
import com.aid.fitness_pet.extensions.replace
import com.aid.fitness_pet.ui.feed.FeedFragment
import com.aid.fitness_pet.ui.profile.ProfileFragment
import com.aid.fitness_pet.ui.schedule.ScheduleFragment
import com.aid.fitness_pet.ui.search.SearchFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val feed by lazy { FeedFragment() }
    private val search by lazy { SearchFragment() }
    private val schedule by lazy { ScheduleFragment() }
    private val profile by lazy { ProfileFragment() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemFeed -> replaceTab(feed)
                R.id.itemSearch -> replaceTab(search)
                R.id.itemSchedule -> replaceTab(schedule)
                R.id.itemProfile -> replaceTab(profile)
            }
            return@setOnItemSelectedListener true
        }
        replaceTab(feed)
    }

    private fun replaceTab(fragment: Fragment) {
        replace(
            target = fragment,
            layoutRes = R.id.container,
            fragmentManager = childFragmentManager,
            include = false
        )
    }
}