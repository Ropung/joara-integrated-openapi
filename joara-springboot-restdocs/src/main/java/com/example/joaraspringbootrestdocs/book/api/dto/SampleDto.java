package com.example.joaraspringbootrestdocs.book.api.dto;

import lombok.Builder;

public record SampleDto() {
    @Builder
    public record SampleResponseDto(Boolean success) {}
}
