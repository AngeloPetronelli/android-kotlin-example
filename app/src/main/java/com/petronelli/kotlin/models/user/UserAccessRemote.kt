package com.petronelli.kotlin.models.user

import com.petronelli.kotlin.models.DataAccess
import io.reactivex.Observable

/**
 * @author Angelo Petronelli on 31/05/2017.
 */

class UserAccessRemote : DataAccess<User> {

    override fun read(id: Int): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun read(): Observable<Collection<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun write(model: User): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun write(list: Collection<User>): Observable<Collection<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
