package io.github.lsj8367.web;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.github.lsj8367.RestDocsDependencyImports;
import org.junit.jupiter.api.Test;
import org.springframework.restdocs.payload.JsonFieldType;

class HomeControllerTest extends RestDocsDependencyImports {

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andDo(document("index",
                responseFields(
                    fieldWithPath("key").type(JsonFieldType.STRING).description("key"))));
    }
}