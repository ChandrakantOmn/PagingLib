package net.simplifiedcoding.androidpagingexample

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource

class ItemDataSourceFactory : DataSource.Factory<Int, Item>() {
    val itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Item>>()
    override fun create(): DataSource<Int, Item> {
        val itemDataSource = ItemDataSource()
        itemLiveDataSource.postValue(itemDataSource)
        return itemDataSource
    }
}
