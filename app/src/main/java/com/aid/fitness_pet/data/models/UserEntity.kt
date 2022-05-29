package com.aid.fitness_pet.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    var id: Long = 0,
    var name: String,
    var number: String,
    var date: String,
    var trainer: String
)