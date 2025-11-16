package me.dio.santander_api_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.santander_api_projeto.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
