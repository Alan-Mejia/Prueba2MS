package com.doctor.api.respository;

import com.doctor.api.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends GenericRepository<User,Long> {

    //Specific QUERYS
    /*
    * List<User> findByName(String name);
    *
    *
    *
    * */

}
