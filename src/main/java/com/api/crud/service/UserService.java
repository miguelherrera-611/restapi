package com.api.crud.service;

import com.api.crud.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> getUsers(); // Obtener todos los usuarios

    UserModel saveUser(UserModel user); // Guardar un nuevo usuario

    Optional<UserModel> getUserById(long id); // Obtener usuario por ID

    UserModel updateUserById(UserModel userRequest, long id); // Actualizar un usuario por ID

    boolean deleteUser(long id); // Eliminar un usuario por ID
}


