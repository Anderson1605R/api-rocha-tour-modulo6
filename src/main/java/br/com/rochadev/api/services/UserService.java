package br.com.rochadev.api.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.rochadev.api.models.UserModel;
import br.com.rochadev.api.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserModel> getAllUsers() {
    return userRepository.findAll();
  }

  public UserModel getUserById(long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado para o ID: " + id));
  }

  public UserModel createUser(UserModel newUser) {
    UserModel user = new UserModel();
    user.setCpf(newUser.getCpf());
    user.setDataNascimento(newUser.getDataNascimento());
    user.setEmail(newUser.getEmail());
    user.setSenha(newUser.getSenha());

    return userRepository.save(user);
  }
}