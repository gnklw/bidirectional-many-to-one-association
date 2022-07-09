package com.example.manytoone;

import com.example.manytoone.entity.Post;
import com.example.manytoone.entity.Comment;
import com.example.manytoone.repo.PostRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Demo implements CommandLineRunner {

    private final PostRepo postRepo;

    public Demo(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    @Transactional
    public void run(String... args) {
        this.populateDB();

        Post post = this.postRepo.findAll().get(0);
        Comment newComment = new Comment().setAuthor("George").setCommentContent("This is a comment");

        //post.addComment(newComment);

        //post.removeComment(post.getComments().stream().findFirst().get());

        this.postRepo.save(post);
    }

    public void populateDB() {
        if (this.postRepo.count() == 0) {
            this.postRepo.save(new Post().setPostContent("Some content..."));
        }
    }
}
