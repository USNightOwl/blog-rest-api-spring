package com.nxhawk.blogapi.service.impl;

import com.nxhawk.blogapi.entity.Category;
import com.nxhawk.blogapi.entity.Post;
import com.nxhawk.blogapi.exception.ResourceNotFoundException;
import com.nxhawk.blogapi.payload.PostDto;
import com.nxhawk.blogapi.repository.CategoryRepository;
import com.nxhawk.blogapi.repository.PostRepository;
import com.nxhawk.blogapi.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper mapper;
    private CategoryRepository categoryRepository;
    public PostServiceImpl(PostRepository postRepository, ModelMapper mapper,
                           CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDto.getCategoryId()));

        // convert DTO to entity
        Post post = mapToEntity(postDto);
        post.setCategory(category);
        Post newPost = postRepository.save(post);

        return mapToDTO(newPost);
    }

    private PostDto mapToDTO(Post post){
        return mapper.map(post, PostDto.class);
    }

    // convert DTO to entity
    private Post mapToEntity(PostDto postDto){
        return mapper.map(postDto, Post.class);
    }
}
