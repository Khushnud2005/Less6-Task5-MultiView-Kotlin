package uz.exemple.less6_task5_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less6_task5_kotlin.R

class MainAdapter(var arrayList: ArrayList<String>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View
        view = if (viewType == 2) {
            LayoutInflater.from(parent.context).inflate(R.layout.item_main2, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.item_main1, parent, false)
        }
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.textView.text = arrayList[position]
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        if ((position + 1) % 5 * 2 == 0) {
            return  2
        } else {
            return  1
        }
    }
    class MainViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val textView: TextView
        init {
            textView = itemView.findViewById(R.id.textView)
        }
    }
}
