package com.petronelli.kotlin.views.main

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.petronelli.kotlin.R
import com.petronelli.kotlin.models.user.User
import com.petronelli.kotlin.utils.GResponder

/**
 * @author Angelo Petronelli on 21/05/2017.
 */

class MainAdapter(private var mItems: MutableList<User>) :
        RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var responder: GResponder<User>? = null

    ////

    fun replaceItems(mItems: List<User>) {
        this.mItems.clear()
        this.mItems.addAll(mItems)

        notifyDataSetChanged()
    }

    fun addItems(model: User) {
        this.mItems.add(model)

        notifyDataSetChanged()
    }

    fun setItemClickListner(responder: GResponder<User>) {
        this.responder = responder
    }

    ////

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_model, null, false), this)
    }

    override fun onBindViewHolder(mainViewHolder: MainViewHolder, position: Int) {
        mainViewHolder.bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    //// HOLDER

    class MainViewHolder(view: View, private val parent: MainAdapter) :
            RecyclerView.ViewHolder(view) {

        fun bind(model: User) {

            val text = itemView.findViewById(R.id.name) as TextView
            text.text = model.name

            val image = itemView.findViewById(R.id.image) as ImageView
            Glide.with(image.context).load(model.url).centerCrop().into(image)

            itemView.setOnClickListener({
                parent.responder?.onResponse(model)
            })

        }
    }
}



