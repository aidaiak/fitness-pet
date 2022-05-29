package com.aid.fitness_pet.ui.schedule

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Locale

data class Schedule(
    @SerializedName("training_location")
    val name: String,
    @SerializedName("created")
    val created: Long,
    @SerializedName("training_type")
    val trainingType: String,
    @SerializedName("ownerId")
    val ownerId: String,
    @SerializedName("training_date")
    val trainingDate: Long,
    @SerializedName("trainer_name")
    val trainerName: String,
    @SerializedName("updated")
    val updated: String
) {

    val time: String
        get() = SimpleDateFormat("hh:mm", Locale.getDefault()).format(trainingDate)
}