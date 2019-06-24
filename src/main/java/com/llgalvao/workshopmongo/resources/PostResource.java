package com.llgalvao.workshopmongo.resources;

import com.llgalvao.workshopmongo.DTO.UserDTO;
import com.llgalvao.workshopmongo.domain.Post;
import com.llgalvao.workshopmongo.domain.User;
import com.llgalvao.workshopmongo.resources.util.URL;
import com.llgalvao.workshopmongo.services.PostService;
import com.llgalvao.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){

        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }


}
