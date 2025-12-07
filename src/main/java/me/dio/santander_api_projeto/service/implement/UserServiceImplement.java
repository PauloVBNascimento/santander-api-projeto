package me.dio.santander_api_projeto.service.implement;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_api_projeto.controller.exception.AccountNumberException;
import me.dio.santander_api_projeto.controller.exception.CardNumberException;
import me.dio.santander_api_projeto.model.User;
import me.dio.santander_api_projeto.repository.UserRepository;
import me.dio.santander_api_projeto.service.UserService;

@Service
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByID(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User newUser) {
        if (userRepository.existsByAccountNumber(newUser.getAccount().getNumber())) {
            throw new AccountNumberException("Uma conta com esse número já existe.");
        }
        else if (userRepository.existsByCardNumber(newUser.getCard().getNumber())) {
            throw new CardNumberException("Um cartão com esse número já existe.");
        }
        return userRepository.save(newUser);
    }

    @Override
    public void deleteById(Long id) {
        User user = findByID(id);
        userRepository.delete(user);
    }

    @Override
    public User updateById(Long id, User updatedUser) {
        User user = findByID(id);
        user.setName(updatedUser.getName());
        return userRepository.save(user);
    }

    

}
