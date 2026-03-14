package com.sai.restapi.user_management_system.service;

import com.sai.restapi.user_management_system.exception.CommentNotFoundException;
import com.sai.restapi.user_management_system.model.Comment;
import com.sai.restapi.user_management_system.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //-----------Create Comment-------------------
    public Comment createComment(Comment comment1){
        return commentRepository.save(comment1);
    }

    //-----------Get All Comments----------------
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    //-----------Get Comment By Id-----------------
    public Comment getCommentById(Integer id) throws CommentNotFoundException{
        return commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
    }

    //--------Update Comment By Id-----------------
    public Comment updateCommentById(Comment comment1,Integer id) throws CommentNotFoundException{
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
        comment.setContent(comment1.getContent());

        return commentRepository.save(comment);
    }


    //----------Delete comment By ID-------------------
    public void deleteComment(Integer id) throws CommentNotFoundException{
        if(!commentRepository.existsById(id)){
            throw new CommentNotFoundException(id);
        }
        commentRepository.deleteById(id);
    }
}
