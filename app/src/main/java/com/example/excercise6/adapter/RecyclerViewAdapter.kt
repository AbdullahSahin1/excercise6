package com.example.excercise6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise6.R
import com.example.excercise6.model.CryptoModel

class RecyclerViewAdapter(private var cryptoList: ArrayList<CryptoModel>, private val listener: listener): RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    interface listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int)
    {
        holder.bind(cryptoList[position],position,listener)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    class RowHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(cryptoModel: CryptoModel, listener: listener) {

            itemView.setOnClickListener { listener.onItemClick(cryptoModel) }
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text =cryptoModel.price
        }
    }

}