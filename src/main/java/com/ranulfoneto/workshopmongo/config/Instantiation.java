package com.ranulfoneto.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ranulfoneto.workshopmongo.dtos.CommentDTO;
import com.ranulfoneto.workshopmongo.models.Post;
import com.ranulfoneto.workshopmongo.models.User;
import com.ranulfoneto.workshopmongo.repositories.PostRepository;
import com.ranulfoneto.workshopmongo.repositories.UserRepository;
import com.ranulfoneto.workshopmongo.services.UserService;

@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;
    private PostRepository postRepository;
    private UserService userService;

    public Instantiation(UserRepository userRepository, PostRepository postRepository, UserService userService) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", userService.toAuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", userService.toAuthorDTO(maria));
        
        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), userService.toAuthorDTO(alex));
 		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), userService.toAuthorDTO(bob));
 		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), userService.toAuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
    
}
