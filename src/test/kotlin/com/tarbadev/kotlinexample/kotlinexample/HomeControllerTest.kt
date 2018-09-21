package com.tarbadev.kotlinexample.kotlinexample

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var cipherUseCase: CipherUseCase

    @Test
    fun show() {
        mvc.perform(get("/"))
                .andExpect(status().isOk)
                .andExpect(view().name("index"))
    }


    @Test
    fun cipher() {
        val input = "abcdef"
        val ciphered = "bcdefg"

        given(cipherUseCase.execute(input)).willReturn(ciphered)

        mvc.perform(post("/")
                .param("input", input)
        )
                .andExpect(redirectedUrl("/"))
                .andExpect(flash().attribute<String>("cipheredText", ciphered))
    }
}