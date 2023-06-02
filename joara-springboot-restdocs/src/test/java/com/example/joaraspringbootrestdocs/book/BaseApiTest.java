package com.example.joaraspringbootrestdocs.book;

import com.google.gson.Gson;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
// MockMvcBuilders.webAppContextSetup(webApplicationContext) ... .build()
@AutoConfigureRestDocs  // .apply(documentationConfiguration(restDocumentation))
@ExtendWith(SpringExtension.class)
public abstract class BaseApiTest {
	@Autowired
	protected MockMvc mockMvc;
	@Autowired protected Gson gson;
}