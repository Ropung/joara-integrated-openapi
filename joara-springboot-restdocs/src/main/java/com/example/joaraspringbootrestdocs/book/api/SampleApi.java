package com.example.joaraspringbootrestdocs.book.api;

import com.example.joaraspringbootrestdocs.book.api.dto.SampleDto;
import com.example.joaraspringbootrestdocs.book.api.dto.SampleDto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class SampleApi {
    @GetMapping("/")
    public SampleDto.SampleResponseDto sample() {
        return SampleResponseDto.builder()
                .success(true)
                .build();
    }
}
