package com.example.notificationservice.RestClient;

import com.example.notificationservice.modele.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRestClient {
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("1","aymane houri","houri.aymane03@gmail.com","user"));
        users.add(new User("é","abdesselam sectani","a.sectani2019@gmail.com","user"));
        return users;
    }

    public User getUserByEmail(String email){
        User user = new User();
        getUsers().forEach(u -> {
            if (u.getEmail()==email){
                user.setUserId(u.getUserId());
                user.setNom(u.getNom());
                user.setEmail(u.getEmail());
                user.setRole(u.getRole());
            }
        });
        return user;
    }
}
