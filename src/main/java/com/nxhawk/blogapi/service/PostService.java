package com.nxhawk.blogapi.service;

import com.nxhawk.blogapi.payload.PostDto;
import com.nxhawk.blogapi.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
    List<PostDto> getPostsByCategory(Long categoryId);
}
