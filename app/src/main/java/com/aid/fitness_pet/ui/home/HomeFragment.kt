package com.aid.fitness_pet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aid.fitness_pet.R
import com.aid.fitness_pet.databinding.FragmentHomeBinding
import com.aid.fitness_pet.ui.feed.FeedFragment
import com.aid.fitness_pet.ui.replace
import com.aid.fitness_pet.ui.profile.ProfileFragment
import com.aid.fitness_pet.ui.schedule.ScheduleFragment
import com.aid.fitness_pet.ui.search.SearchFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemFeed -> showPage(FeedFragment())
                R.id.itemSearch -> showPage(SearchFragment())
                R.id.itemSchedule -> showPage(ScheduleFragment())
                R.id.itemProfile -> showPage(ProfileFragment())
            }
            return@setOnItemSelectedListener true
        }
        showPage(FeedFragment())
    }

    private fun showPage(fragment: Fragment) {
        replace(
            target = fragment,
            layoutRes = R.id.container,
            fragmentManager = childFragmentManager,
            include = false
        )
    }
}