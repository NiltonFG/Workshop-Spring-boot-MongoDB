package com.example.sbmdb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbmdb.domain.Post;
import com.example.sbmdb.resources.util.URL;
import com.example.sbmdb.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	PostService service;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullsearch(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "mindate", defaultValue = "") String minDate,
			@RequestParam(value = "mindate", defaultValue = "") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0l));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
