package com.example.sbmdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbmdb.domain.User;
import com.example.sbmdb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository rep;
	
	public List<User> finfAll(){
		return rep.findAll();
	}
}
