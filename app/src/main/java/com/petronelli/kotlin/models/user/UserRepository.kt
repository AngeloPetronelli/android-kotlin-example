package com.petronelli.kotlin.models.user

import com.petronelli.kotlin.models.DataAccess
import io.reactivex.Observable

/**
 * @author Angelo Petronelli on 31/05/2017.
 */
class UserRepository : DataAccess<User> {

    var dataAccessLocal: DataAccess<User> = UserAccessLocal()
    var dataAccessRemote: DataAccess<User> = UserAccessRemote()

    override fun read(id: Int): Observable<User> {
        return dataAccessLocal.read(id)
    }

    override fun read(): Observable<Collection<User>> {
        return dataAccessLocal.read()
    }

    override fun write(model: User): Observable<User> {
        return dataAccessLocal.write(model)
    }

    override fun write(list: Collection<User>): Observable<Collection<User>> {
        return dataAccessLocal.write(list)
    }
}