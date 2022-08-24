package uz.exemple.less6_task5_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less6_task5_kotlin.adapter.MainAdapter

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        val arrayList = ArrayList<String>()
        for (i in 1..40) {
            arrayList.add("Item $i")
        }
        val layoutManager = GridLayoutManager(this, 2)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if ((position + 1) % 5 * 2 == 0) {
                    return  2
                } else {
                    return 1
                }
            }
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MainAdapter(arrayList)
    }
}