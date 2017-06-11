package com.petronelli.kotlin.models.user

import com.petronelli.kotlin.models.DataRealmAccess
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm

/**
 * @author Angelo Petronelli on 11/06/2017.
 */
class UserAccessLocal : DataRealmAccess<User> {

    fun searchFromZipCode(zipCode: String): Observable<Collection<User>> = Observable.create<Collection<User>>({
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val realmResult = realm.where(User::class.java)
                .equalTo("zipCode", zipCode)
                .findAll()
        val list = realm.copyFromRealm(realmResult)
        realm.commitTransaction()
        realm.close()

        it.onNext(list)
    }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
}
