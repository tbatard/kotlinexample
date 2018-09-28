package com.tarbadev.kotlinexample.kotlinexample

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify

class CipherUseCaseTest {
    private lateinit var cipherUseCase: CipherUseCase
    private lateinit var cipherHistoryRepository: CipherHistoryRepository

    @Before
    fun setup() {
        cipherHistoryRepository = mock()
        cipherUseCase = CipherUseCase(cipherHistoryRepository)
    }

    @Test
    fun cipherUseCase() {
        val cipheredValue = cipherUseCase.execute("abcdefghijklmnopqrstuvwxyz")

        assertEquals("bcdefghijklmnopqrstuvwxyza", cipheredValue.value)

        verify(cipherHistoryRepository).save(cipheredValue)
    }
}
