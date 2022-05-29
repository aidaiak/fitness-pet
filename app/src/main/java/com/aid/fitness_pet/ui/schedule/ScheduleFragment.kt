package com.aid.fitness_pet.ui.schedule

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.aid.fitness_pet.databinding.FragmentScheduleBinding
import com.aid.fitness_pet.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class ScheduleFragment : BaseFragment<ScheduleViewModel, FragmentScheduleBinding>(
    ScheduleViewModel::class.java,
    { FragmentScheduleBinding.inflate(it) }
) {
    private val adapter = ScheduleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.prevImageView.setOnClickListener {
            vm.onPrev()
        }
        binding.nextImageView.setOnClickListener {
            vm.onNext()
        }
        binding.dateTextView.setOnClickListener {
            val calendar = vm.getCurrentDate()
            DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth -> vm.setNewDate(year, month, dayOfMonth) },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        binding.recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)

        vm.calendarState.observe(viewLifecycleOwner) {
            binding.dateTextView.text = SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(it.timeInMillis)
        }
        vm.items.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
        vm.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        vm.loadData()
    }
}