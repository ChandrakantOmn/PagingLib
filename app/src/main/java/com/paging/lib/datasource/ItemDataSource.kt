package com.paging.lib.datasource

import android.arch.paging.PageKeyedDataSource
import com.paging.lib.models.Item
import com.paging.lib.models.StackApiResponse
import com.paging.lib.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemDataSource : PageKeyedDataSource<Int, Item>() {

    override fun loadInitial(params: PageKeyedDataSource.LoadInitialParams<Int>, callback: PageKeyedDataSource.LoadInitialCallback<Int, Item>) {
        RetrofitClient.instance
                .api.getAnswers(FIRST_PAGE, PAGE_SIZE, SITE_NAME)
                .enqueue(object : Callback<StackApiResponse> {
                    override fun onResponse(call: Call<StackApiResponse>, response: Response<StackApiResponse>) {
                        if (response.body() != null) {
                            callback.onResult(response.body()!!.items!!, null, FIRST_PAGE + 1)
                        }
                    }
                    override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {
                    }
                })
    }

    override fun loadBefore(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, Item>) {
        RetrofitClient.instance
                .api.getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(object : Callback<StackApiResponse> {
                    override fun onResponse(call: Call<StackApiResponse>, response: Response<StackApiResponse>) {
                        val adjacentKey = if (params.key > 1) params.key - 1 else null
                        if (response.body() != null) {
                            callback.onResult(response.body()!!.items!!, adjacentKey) }
                    }

                    override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {
                    }
                })
    }

    override fun loadAfter(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, Item>) {
        RetrofitClient.instance
                .api
                .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(object : Callback<StackApiResponse> {
                    override fun onResponse(call: Call<StackApiResponse>, response: Response<StackApiResponse>) {
                        if (response.body() != null && response.body()!!.has_more) {
                            callback.onResult(response.body()!!.items!!, params.key + 1)
                        }
                    }
                    override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {

                    }
                })
    }

    companion object {

        const val PAGE_SIZE = 50
        private const val FIRST_PAGE = 1
        private const val SITE_NAME = "stackoverflow"
    }
}
