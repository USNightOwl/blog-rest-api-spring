package com.nxhawk.blogapi.service;

import com.nxhawk.blogapi.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto, String username);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(Long postId, Long commentId);
    CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest, String username);
    void deleteComment(Long postId, Long commentId);
}
