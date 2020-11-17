package me.thewing.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest //전반적으로 통합 테스트
@AutoConfigureMockMvc //MockMvc 빈 설정 자동 등록
public class FIleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void fileUploadTest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file",
                "test.txt",
                "text/plain",
                "hello file".getBytes());
        this.mockMvc.perform(multipart("/file").file(file))
                    .andDo(print())
                    .andExpect(status().is3xxRedirection())
        ;
    }
}