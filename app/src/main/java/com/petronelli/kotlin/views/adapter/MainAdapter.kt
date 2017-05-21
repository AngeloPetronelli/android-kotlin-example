package com.petronelli.kotlin.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.petronelli.kotlin.R
import com.petronelli.kotlin.`interface`.GResponder
import com.petronelli.kotlin.model.ItemModel

/**
 * @author Angelo Petronelli on 21/05/2017.
 */

class MainAdapter(private var mContext: Context, private var mItems: MutableList<ItemModel>) :
        RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var responder: GResponder<ItemModel>? = null

    ////

    fun replaceItems(mItems: List<ItemModel>) {
        this.mItems.clear()
        this.mItems.addAll(mItems)

        notifyDataSetChanged()
    }

    fun setItemClickListner(responder: GResponder<ItemModel>) {
        this.responder = responder
    }

    ////

    override fun onBindViewHolder(p0: MainViewHolder?, p1: Int) {
        p0?.bind(mItems[p1])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_model, null), this)
    }

    //// HOLDER

    class MainViewHolder(view: View, private val parent : MainAdapter) :
            RecyclerView.ViewHolder(view) {

        fun bind(model: ItemModel) {

            val text: TextView = itemView.findViewById(R.id.name) as TextView
            text.text = model.getName()

            itemView.setOnClickListener({
                if (parent.responder != null) {
                    parent.responder!!.onResponse(model)
                }
            })

        }
    }
}



