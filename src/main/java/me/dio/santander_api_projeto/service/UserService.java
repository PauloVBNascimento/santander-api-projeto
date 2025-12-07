package me.dio.santander_api_projeto.service;

import me.dio.santander_api_projeto.model.User;

public interface UserService {

    User findByID(Long id);

    User create(User newUser);

    User updateById(Long id, User user);

    void deleteById(Long id);

}
