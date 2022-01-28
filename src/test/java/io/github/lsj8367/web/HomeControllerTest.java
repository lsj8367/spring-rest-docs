package io.github.lsj8367.web;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
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
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("key").type(JsonFieldType.STRING).description("키 값"))));
    }
}