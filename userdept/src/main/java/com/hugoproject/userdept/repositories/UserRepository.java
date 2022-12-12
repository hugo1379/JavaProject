package com.hugoproject.userdept.repositories;
//REPOSITORIO DE CONSULTAS AO BANCO DE DADOS

//tipo que contem todas as operações básicas:pesquisar, salvar, deletar e atualizar do usuário

//Criada uma instancia do JPA repository para fazer o acesso aos dados,o JPA repository é uma interface
import org.springframework.data.jpa.repository.JpaRepository;

import com.hugoproject.userdept.entities.User;

//Ela herda o JPA repository
public interface UserRepository extends JpaRepository<User, Long> {

}
