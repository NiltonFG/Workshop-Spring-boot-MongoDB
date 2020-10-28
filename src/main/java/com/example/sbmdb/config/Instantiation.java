package com.example.sbmdb.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.sbmdb.domain.Post;
import com.example.sbmdb.domain.User;
import com.example.sbmdb.dto.AuthorDTO;
import com.example.sbmdb.dto.CommentDTO;
import com.example.sbmdb.repository.PostRepository;
import com.example.sbmdb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2020"),"partiu sp","viagem braba dms",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("21/03/2020"),"bom dia!","Acordei feliz!",new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("boa viagem man", sdf.parse("25/03/2019"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("boa viagem", sdf.parse("22/03/2019"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("tenha um bom fds", sdf.parse("27/03/2019"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}
}
