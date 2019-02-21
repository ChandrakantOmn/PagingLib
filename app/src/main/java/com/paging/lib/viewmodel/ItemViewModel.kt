package com.paging.lib.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PagedList
import com.paging.lib.datasource.ItemDataSource
import com.paging.lib.datasource.ItemDataSourceFactory
import com.paging.lib.models.Item

class ItemViewModel : ViewModel() {

    internal var itemPagedList: LiveData<PagedList<Item>>
    private var liveDataSource: LiveData<PageKeyedDataSource<Int, Item>>

    init {
        val itemDataSourceFactory = ItemDataSourceFactory()
        liveDataSource = itemDataSourceFactory.itemLiveDataSource

        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE).build()

        itemPagedList = LivePagedListBuilder(itemDataSourceFactory, pagedListConfig)
                .build()
    }
}
