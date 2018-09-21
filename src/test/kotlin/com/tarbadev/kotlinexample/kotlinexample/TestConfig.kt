package com.tarbadev.kotlinexample.kotlinexample

import org.mockito.Mockito
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestConfig {
    @Bean
    fun cipherUseCase() : CipherUseCase {
        return Mockito.mock(CipherUseCase::class.java)
    }
}