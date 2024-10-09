package com.nxhawk.blogapi.controller;

import com.nxhawk.blogapi.payload.CommentDto;
import com.nxhawk.blogapi.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    private CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto,
                                                    @AuthenticationPrincipal UserDetails userDetails
    ){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto, userDetails.getUsername()), HttpStatus.CREATED);
    }
}
