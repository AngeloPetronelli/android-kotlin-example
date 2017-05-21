package com.petronelli.kotlin.views.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.petronelli.kotlin.R
import com.petronelli.kotlin.`interface`.GResponder
import com.petronelli.kotlin.views.adapter.MainAdapter
import com.petronelli.kotlin.model.ItemModel
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @author Angelo Petronelli on 20/05/2017.
 */
class MainFragment : Fragment(),
        View.OnClickListener, GResponder<ItemModel> {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener(this)

        val adapter : MainAdapter = MainAdapter(context, ArrayList<ItemModel>())
        adapter.setItemClickListner(this)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter

        val list: MutableList<ItemModel> = ArrayList()

        val item_0: ItemModel = ItemModel(0, "C-17", "")
        list.add(item_0)

        val item_1: ItemModel = ItemModel(1, "C-18", "")
        list.add(item_1)

        val item_2: ItemModel = ItemModel(2, "Vegeta", "")
        list.add(item_2)

        val item_3: ItemModel = ItemModel(3, "Goku", "")
        list.add(item_3)

        val item_4: ItemModel = ItemModel(4, "Junior", "")
        list.add(item_4)

        val item_5: ItemModel = ItemModel(4, "Gohan", "")
        list.add(item_5)

        adapter.replaceItems(list)
    }

    //// INTERFACES

    override fun onClick(v: View) {
        Toast.makeText(context, "Kotlin", Toast.LENGTH_LONG).show()
    }

    override fun onResponse(t: ItemModel) {
        Toast.makeText(context, t.getName(), Toast.LENGTH_LONG).show()
    }
}
