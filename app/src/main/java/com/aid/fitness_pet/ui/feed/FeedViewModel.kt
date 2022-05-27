package com.aid.fitness_pet.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : BaseVM() {
    private val data = mutableListOf(
        FeedItem(
            image = "https://static3.bigstockphoto.com/6/6/3/large1500/366639772.jpg",
            title = "30% discount on morning access",
            description = "30% discount on morning access to our gym. Summer is\u2028coming, get fit now!"
        ),
        FeedItem(
            image = "https://miychay.com/upload/iblock/255/25555a1593b3f3adac5fbbbbe2f5c1a2.jpeg",
            title = "Yoga classes in the summer! ",
            description = "Starting from June 1, 2022 there will be Yoga classes with\n" +
                "Rahim. Come and join!"
        )
    )

    fun loadData(): LiveData<List<FeedItem>> {
        val observable = MutableLiveData<List<FeedItem>>()
        showLoading()
        disposable.add(
            Completable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        observable.postValue(data)
                        hideLoading()
                    }, {
                        hideLoading()
                    }
                )
        )
        return observable
    }
}