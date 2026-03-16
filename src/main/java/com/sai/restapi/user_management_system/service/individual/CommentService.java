package com.sai.restapi.user_management_system.service.individual;

import com.sai.restapi.user_management_system.dto.individual.CommentDTO;
import com.sai.restapi.user_management_system.exception.CommentNotFoundException;
import com.sai.restapi.user_management_system.model.Comment;
import com.sai.restapi.user_management_system.repository.individual.CommentRepository;
import com.sai.restapi.user_management_system.utility.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //-----------Create Comment-------------------
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        // taskId and authorId can be set via relationships if needed
        Comment savedComment = commentRepository.save(comment);
        return DtoMapper.toCommentDTO(savedComment);
    }

    //-----------Get All Comments----------------
    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(DtoMapper::toCommentDTO)
                .collect(Collectors.toList());
    }

    //-----------Get Comment By Id-----------------
    public CommentDTO getCommentById(Integer id) throws CommentNotFoundException {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));
        return DtoMapper.toCommentDTO(comment);
    }

    //--------Update Comment By Id-----------------
    public CommentDTO updateCommentById(CommentDTO commentDTO, Integer id) throws CommentNotFoundException {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));

        existingComment.setContent(commentDTO.getContent());

        Comment updatedComment = commentRepository.save(existingComment);
        return DtoMapper.toCommentDTO(updatedComment);
    }

    //----------Delete comment By ID-------------------
    public void deleteComment(Integer id) throws CommentNotFoundException {
        if (!commentRepository.existsById(id)) {
            throw new CommentNotFoundException(id);
        }
        commentRepository.deleteById(id);
    }
}