package com.example.manytoone.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String author;

    @Column
    private String commentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_post")
    private Post post;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public Comment setId(long id) {
        this.id = id;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Comment setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Comment setCommentContent(String commentContent) {
        this.commentContent = commentContent;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() && Objects.equals(getAuthor(), comment.getAuthor()) && Objects.equals(getCommentContent(), comment.getCommentContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getCommentContent());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
