package com.tarbadev.kotlinexample.kotlinexample

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CipherUseCaseTest {
    private lateinit var cipherUseCase: CipherUseCase

    @Before
    fun setup() {
        cipherUseCase = CipherUseCase()
    }

    @Test
    fun cipherUseCase() {
        val ciphered = cipherUseCase.execute("abcdefghijklmnopqrstuvwxyz")

        assertEquals("bcdefghijklmnopqrstuvwxyza", ciphered)
    }
}
