package com.aid.fitness_pet.ui.base

sealed class BaseEvent {
    class ShowToast(val message: String) : BaseEvent()
}

//пример наследования
sealed class AuthEvent : BaseEvent() {
    object OnAuthSuccess : BaseEvent()
}