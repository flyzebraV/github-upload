package com.example.mergecard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.listener.OnItemLongClickListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       initView()
    }

    private fun initView() {

        var list=listOf("a","b","c","1","2","3","a","b","c")
        val cardAdapter = CardAdapter(list)
        val rv = findViewById<RecyclerView>(R.id.rv)


        //设置拖动事件
        val callBack = SimpleItemTouchHelperCallback(cardAdapter)
        var mHelper = ItemTouchHelper(callBack)
        mHelper.attachToRecyclerView(rv)
        rv.layoutManager=GridLayoutManager(this,4)
        rv.adapter=cardAdapter
        cardAdapter.setHelper(mHelper)


    }
}