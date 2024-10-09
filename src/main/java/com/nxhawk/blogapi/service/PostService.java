package com.nxhawk.blogapi.service;

import com.nxhawk.blogapi.payload.PostDto;
import com.nxhawk.blogapi.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
