package net.simplifiedcoding.androidpagingexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
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
