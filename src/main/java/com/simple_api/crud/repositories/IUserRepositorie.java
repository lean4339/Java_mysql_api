package com.simple_api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple_api.crud.models.UserModel;

@Repository
public interface IUserRepositorie extends JpaRepository<UserModel,Long>{
}
