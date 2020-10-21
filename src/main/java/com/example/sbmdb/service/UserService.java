package com.example.sbmdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbmdb.domain.User;
import com.example.sbmdb.dto.UserDTO;
import com.example.sbmdb.repository.UserRepository;
import com.example.sbmdb.service.exception.ObjectNotFoundExcepition;

@Service
public class UserService {

	@Autowired
	UserRepository rep;

	public List<User> finfAll() {
		return rep.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepition("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
}