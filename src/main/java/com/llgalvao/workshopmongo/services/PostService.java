package com.llgalvao.workshopmongo.services;

import com.llgalvao.workshopmongo.DTO.UserDTO;
import com.llgalvao.workshopmongo.domain.Post;
import com.llgalvao.workshopmongo.domain.User;
import com.llgalvao.workshopmongo.repository.PostRepository;
import com.llgalvao.workshopmongo.repository.UserRepository;
import com.llgalvao.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

}
