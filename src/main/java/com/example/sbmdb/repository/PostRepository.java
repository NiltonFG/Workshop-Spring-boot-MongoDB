package com.example.sbmdb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sbmdb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
