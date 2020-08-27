package com.sunofbeaches.recyclervie

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val contentAdapter by lazy {
        ContentListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化数据
        initData()
        //初始化控件
        initView()
    }

    private fun initView() {
        contentListView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = contentAdapter
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.bottom = 2
                }
            })
        }

    }

    private fun initData() {
        val dataJson = requestData.resultJson
        val gson = Gson()
        val response = gson.fromJson<Response>(dataJson, Response::class.java)
        contentAdapter.addData(response.data)
        println(response.code)
        println(response.message)
        println(response.data.size)
    }
}