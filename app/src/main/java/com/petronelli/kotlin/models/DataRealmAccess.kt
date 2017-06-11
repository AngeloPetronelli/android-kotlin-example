package com.petronelli.kotlin.models

import com.petronelli.kotlin.models.user.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmModel

/**
 * @author Angelo Petronelli on 11/06/2017.
 */

@Suppress("UNCHECKED_CAST")
interface DataRealmAccess<T> : DataAccess<T> {

    override fun read(id: Int): Observable<T> = Observable.create<T>({
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val realmResult = realm.where(User::class.java)
                .equalTo("id", id)
                .findFirst()
        val model  = realm.copyFromRealm(realmResult)
        realm.commitTransaction()
        realm.close()

        it.onNext(model as T)
    }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())

    override fun read(): Observable<Collection<T>> = Observable.create<Collection<T>>({
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val realmResult = realm.where(User::class.java).findAll()
        val list: MutableList<User> = realm.copyFromRealm(realmResult)
        realm.commitTransaction()
        realm.close()

        it.onNext(list as Collection<T>)
    }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())

    override fun write(model: T): Observable<T> = Observable.create<T>({
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val result = realm.copyToRealmOrUpdate(model as RealmModel)
        realm.commitTransaction()
        realm.close()

        it.onNext(result as T)
    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

    override fun write(list: Collection<T>): Observable<Collection<T>> = Observable.create<Collection<T>>({
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val result = realm.copyToRealmOrUpdate(list as Collection<RealmModel>)
        realm.commitTransaction()
        realm.close()

        it.onNext(result as Collection<T>)
    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}