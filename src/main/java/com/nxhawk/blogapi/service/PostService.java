package com.nxhawk.blogapi.service;

import com.nxhawk.blogapi.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
