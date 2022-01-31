package io.github.lsj8367.web;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import io.github.lsj8367.RestDocsDependencyImports;
import io.github.lsj8367.domain.User;
import io.github.lsj8367.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;

@WebMvcTest(UserController.class)
class UserControllerTest extends RestDocsDependencyImports {

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void findAll() throws Exception {
        //given
        final List<User> users = List.of(
            new User(1L, "name1", "test1@email.com"),
            new User(2L, "name2", "test2@email.com"),
            new User(3L, "name3", "test3@email.com")
        );
        //when
        when(userService.findAll()).thenReturn(users);
        //then
        mockMvc.perform(get("/api/v1/user/all"))
            .andExpect(status().isOk())
            .andDo(
                document("user-findAll",
                    getResponsePreprocessor(),
                    responseFields(
                        fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("유저의 아이디"),
                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("유저 이름"),
                        fieldWithPath("[].email").type(JsonFieldType.STRING).description("유저 이메일")
                    )
                )
            );

    }

}