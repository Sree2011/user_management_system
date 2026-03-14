package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.annotations.ServerErrorDoc;
import com.sai.restapi.user_management_system.exception.CommentNotFoundException;
import com.sai.restapi.user_management_system.model.Comment;
import com.sai.restapi.user_management_system.repository.CommentRepository;
import com.sai.restapi.user_management_system.service.CommentService;
import com.sai.restapi.user_management_system.utility.DeleteResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@Tag(name = "Comment Controller",description = "Handles operations on comments")
@ServerErrorDoc
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    public CommentController(CommentService commentService,
                             CommentRepository commentRepository){
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    //-------------Create comment--------------
    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(Comment comment){
        Comment cmt = commentService.createComment(comment);
        return ResponseEntity.ok(cmt);
    }


    //-----------Get All Comments-----------------
    @GetMapping("/getall")
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> list = commentService.getAllComments();
        return ResponseEntity.ok(list);
    }

    //--------Get Comment By ID--------------------
    @GetMapping("/getbyid")
    public ResponseEntity<Comment> getCommentById(Integer id){
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    //--------------Update Comment By Id--------------
    @PatchMapping("/update")
    public ResponseEntity<Comment> updateCommentById(Comment cmt1, Integer id){
        Comment cmt2 = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
        cmt2.setContent(cmt1.getContent());
        commentRepository.save(cmt2);
        return ResponseEntity.ok(cmt2);
    }


    //--------------Delete Comment By ID---------------
    @DeleteMapping("/delete")
    public ResponseEntity<DeleteResponse> deleteCommentById(Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.ok(new DeleteResponse("204","Comment deleted successfully"));
    }
}
