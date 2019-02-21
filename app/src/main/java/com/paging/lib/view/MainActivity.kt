package com.paging.lib.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.paging.lib.R
import com.paging.lib.adapter.ItemAdapter
import com.paging.lib.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview!!.layoutManager = LinearLayoutManager(this)
        recyclerview!!.setHasFixedSize(true)
        val itemViewModel = ViewModelProviders.of(this)[ItemViewModel::class.java]
        val adapter = ItemAdapter(this)
        itemViewModel.itemPagedList.observe(this, Observer { items -> adapter.submitList(items) })
        recyclerview!!.adapter = adapter
    }
}
