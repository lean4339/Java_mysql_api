package com.simple_api.crud.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_api.crud.Utils.ErrorGeneric;
import com.simple_api.crud.controllers.Responses;
import com.simple_api.crud.models.UserModel;
import com.simple_api.crud.repositories.IUserRepositorie;

@Service
public class UserService {
    @Autowired
    IUserRepositorie userRepositorie;

    public Responses getUsers() {
        Responses response = new Responses();
        try {
            ArrayList<UserModel> users = (ArrayList<UserModel>) userRepositorie.findAll();
            response.setStatusCode(200);
            response.setMessage("OK");
            response.setData(users);
            response.setError(false);

            return response;
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            response.setData(null);
            response.setError(true);
            return response;
        }
        
    }

    public Responses saveUser(UserModel user) {
        Responses response = new Responses();
        try {
            if(user.getEmail() == null || user.getPassword() == null || user.getUsername() == null) {
                throw new ErrorGeneric("data cant be null");
            }

            UserModel newUser = userRepositorie.save(user);
            response.setStatusCode(200);
            response.setMessage("OK");
            response.setData(newUser);
            response.setError(false);
            return response;
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            response.setData(null);
            response.setError(true);
            return response;
        }
    }

    public Responses getUser(long id) {
        Responses response = new Responses();
        try {
            UserModel user = userRepositorie.findById(id).get();
            if(user == null){
                throw new ErrorGeneric("user not found");
            }
            response.setStatusCode(200);
            response.setMessage("OK");
            response.setData(user);
            response.setError(false);
            return response;
        } catch (Exception e) {
            
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            response.setData(null);
            response.setError(true);
            return response;
        }
    }

    public Responses updateUser(UserModel request, long id) {
        Responses response = new Responses();
        try {

            UserModel user = userRepositorie.findById(id).get();
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setUsername(request.getUsername());
            response.setStatusCode(200);
            response.setMessage("OK");
            response.setData(user);
            response.setError(false);

            return response;
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            response.setData(null);
            response.setError(true);
            return response;
        }

    }

    public Responses deleteUser(long id) {
        Responses response = new Responses();
        try {
            userRepositorie.findById(id).get();
            userRepositorie.deleteById(id);
            response.setStatusCode(200);
            response.setMessage("deleted successfuly");
            response.setData(true);
            response.setError(false);
            return response;
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            response.setData(null);
            response.setError(true);
            return response;
        }
    }
}
