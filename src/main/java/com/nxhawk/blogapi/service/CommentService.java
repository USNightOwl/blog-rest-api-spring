package com.nxhawk.blogapi.service;

import com.nxhawk.blogapi.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto, String username);
}
