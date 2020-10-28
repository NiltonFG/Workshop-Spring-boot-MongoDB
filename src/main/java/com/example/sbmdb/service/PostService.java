package com.example.sbmdb.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbmdb.domain.Post;
import com.example.sbmdb.repository.PostRepository;
import com.example.sbmdb.service.exception.ObjectNotFoundExcepition;

@Service
public class PostService {

	@Autowired
	PostRepository rep;

	public Post findById(String id) {
		Optional<Post> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepition("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return rep.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date mindate, Date maxdate){
		maxdate = new Date(maxdate.getTime()+24 * 60 * 60 * 1000);
		return rep.fullSearch(text, mindate, maxdate);
	}
}