package com.tarbadev.kotlinexample.kotlinexample

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class CipherUseCaseTest : Spek({
    describe("CipherUseCase") {
        val cipherUseCase = CipherUseCase()

        on("execute with correct input") {
            val ciphered = cipherUseCase.execute("abcdefghijklmnopqrstuvwxyz")

            it("ciphers the input") {
                assertEquals("bcdefghijklmnopqrstuvwxyza", ciphered)
            }
        }
    }
})
