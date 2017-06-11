package com.petronelli.kotlin.views.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.petronelli.kotlin.R
import com.petronelli.kotlin.models.user.User
import com.petronelli.kotlin.models.user.UserRepository
import com.petronelli.kotlin.utils.GResponder
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @author Angelo Petronelli on 20/05/2017.
 */
class MainFragment : Fragment(), View.OnClickListener, GResponder<User> {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
//    val itemModelRepository: UserRepository = UserRepository()

    var adapter: MainAdapter? = null
    val list: MutableList<User> = ArrayList()

    companion object {
        fun newInstance(): MainFragment {
            val args: Bundle = Bundle()
            val editFragment: MainFragment = MainFragment()
            editFragment.arguments = args
            return editFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener(this)

        adapter = MainAdapter(ArrayList<User>())
        adapter?.setItemClickListner(this)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter

        list.add(User(0, "Goku", "https://vignette2.wikia.nocookie.net/dragonball/images/f/ff/Cbgoku.png"))
        list.add(User(1, "Vegeta", "https://vignette1.wikia.nocookie.net/dragonball/images/6/60/Cbvegeta.png"))
        list.add(User(2, "Bulma", "https://vignette4.wikia.nocookie.net/dragonball/images/7/7a/Cbbulma.png"))
        list.add(User(3, "Junior", "https://vignette2.wikia.nocookie.net/dragonball/images/f/f0/Cbpiccolo.png"))
        list.add(User(4, "Gohan", "https://vignette1.wikia.nocookie.net/dragonball/images/0/0a/Cbgohan.png"))
        list.add(User(5, "Krillin", "https://vignette2.wikia.nocookie.net/dragonball/images/a/aa/Cbkrillin.png"))
        list.add(User(6, "C-17", "https://vignette1.wikia.nocookie.net/dragonball/images/8/87/Cb17.png"))
        list.add(User(7, "C-18", "https://vignette2.wikia.nocookie.net/dragonball/images/8/8a/Cb18.png"))
        list.add(User(8, "Majin Buu", "https://vignette3.wikia.nocookie.net/dragonball/images/7/7d/Cbbuu.png"))

        adapter?.replaceItems(list)
    }

//    fun write() {
//        compositeDisposable.add(itemModelRepository.write(list).subscribe({
//            read()
//        }))
//    }

//    fun read() {
//        compositeDisposable.add(itemModelRepository.read().subscribe({
//            adapter?.replaceItems(it)
//        }))
//    }

    override fun onDestroyView() {
        super.onDestroyView()

        compositeDisposable.clear()
    }

    //// INTERFACES

    override fun onClick(v: View) {
        Snackbar.make(parent, "Floating Action Button", Snackbar.LENGTH_LONG).show()
    }

    override fun onResponse(t: User) {
        Toast.makeText(context, t.name, Toast.LENGTH_LONG).show()
    }
}