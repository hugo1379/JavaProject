package com.hugoproject.userdept.controllers;
//Controlador REST:Controlador responsável por receber as requisições e responder a elas

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugoproject.userdept.entities.User;
import com.hugoproject.userdept.repositories.UserRepository;

//Diz que a classe vai ser um controlador REST
//Ela vai responder com requisições
@RestController
//Indica qual o caminho que o controlador vai responder
@RequestMapping(value = "/users")
public class UserController {

	// Injeção de dependencias
	@Autowired
	// Composição
	private UserRepository repository;

	/*
	 * quando fizer uma requisição web deve informar o verbo http que esta usando
	 * (get,post,delete),nesse caso o get
	 */
	@GetMapping
	// findAll vai no banco de dados buscar os usuarios
	public List<User> findAll() {
		// vai retornar uma lista
		List<User> result = repository.findAll();
		return result;
	}

	// Endpoint buscar um usuario pelo id indicando o caminho
	@GetMapping(value = "/{id}")
	// @PathVariable vai sincronizar com o id da url com o do paramentro
	public User findById(@PathVariable Long id) {
		/*
		 * o metodo findById(id) retorna um option que é um objeto especial, dentro
		 * desse objeto é que esta o usuario, usa .get()para pegar esse usuario
		 */
		User result = repository.findById(id).get();
		return result;
	}

	// Endpoint pra salvar um usuario
	@PostMapping
	// @requestBody configura que o objeto "user" vai ser o corpo da requisição
	public User insert(@RequestBody User user) {
		/*
		 * O metodo save(user) vai mandar pro banco de dados um insert como objeto
		 * convertido para relacional e retorna uma nova referencia para o objeto save
		 */
		User result = repository.save(user);
		return result;
	}
}
