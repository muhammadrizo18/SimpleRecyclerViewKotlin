package com.example.project1k.adapter

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project1k.R
import com.example.project1k.model.Member
import kotlinx.android.synthetic.main.item_custom_layout.view.*

// recyclerview member list adapter
// this is a simple adapter
data class CustomAdapter(private val context: Context, private val members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_custom_layout, parent, false)
        )
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is CustomViewHolder) {
            holder.textView.text = member.name
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    private data class CustomViewHolder(
        val itemView: View,
        val textView: TextView = itemView.text_view_title
    ) : RecyclerView.ViewHolder(itemView)
}

