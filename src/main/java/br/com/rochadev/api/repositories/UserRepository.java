package br.com.rochadev.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rochadev.api.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
