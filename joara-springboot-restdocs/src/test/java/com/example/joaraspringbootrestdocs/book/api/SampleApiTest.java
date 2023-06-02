package com.example.joaraspringbootrestdocs.book.api;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.example.joaraspringbootrestdocs.book.BaseApiTest;
import com.example.joaraspringbootrestdocs.book.api.dto.SampleDto;
import com.example.joaraspringbootrestdocs.book.api.dto.SampleDto.SampleResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class SampleApiTest extends BaseApiTest {

    @Test
    void sample() throws Exception {
        // TEST
        ResultActions perform = mockMvc.perform(
                    get("/")
                )
                // .andExpect(status().is2xxSuccessful()); // 2xx, 4xx, 5xx
                .andExpect((result) -> {
                    // [1] Status
                    assertEquals(200, result.getResponse().getStatus());

                    String content = result.getResponse().getContentAsString();
                    SampleDto.SampleResponseDto body = gson.fromJson(content, SampleResponseDto.class);

                    // [2] Response Body
                    assertTrue(body.success());
                });

        // DOCS
        perform.andDo(print())
//                .andDo( // Rest Docs Only
//                        document("sample-springboot-restdocs-api",
//                                // pathParameters(parameterWithName("").description(""), ... ),
//                                responseFields(
//                                        fieldWithPath("success").description("성공")
//                                )
//                        )
//                )
                .andDo( // Open API Convertable
                        document("sample-springboot-restdocs",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                resource(
                                        ResourceSnippetParameters.builder()
                                                .summary("API 설명 요약입니다.")
                                                .description("이것이 바로 API 설명입니다.")
                                                // .pathParameters(parameterWithName("").description(""), ... ),
                                                .responseFields(
                                                        fieldWithPath("success").description("성공")
                                                )
                                                .build()
                                )
                        )
                );
    }
}