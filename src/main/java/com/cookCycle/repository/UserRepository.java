package com.cookCycle.repository;

import com.cookCycle.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String>{

}
