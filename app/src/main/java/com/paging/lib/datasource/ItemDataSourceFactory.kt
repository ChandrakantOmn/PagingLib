package com.paging.lib.datasource

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import com.paging.lib.models.Item

class ItemDataSourceFactory : DataSource.Factory<Int, Item>() {
    val itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Item>>()
    override fun create(): DataSource<Int, Item> {
        val itemDataSource = ItemDataSource()
        itemLiveDataSource.postValue(itemDataSource)
        return itemDataSource
    }
}
