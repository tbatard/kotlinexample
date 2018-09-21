package com.tarbadev.kotlinexample.kotlinexample

import org.springframework.stereotype.Component

const val ALPHABET = "abcdefghijklmnopqrstuvwxyz"

@Component
class CipherUseCase {

    fun execute(input: String) : String {
        var ciphered = ""

        for (letter in input){
            var index = ALPHABET.indexOf(letter) + 1

            if (index >= ALPHABET.length) {
                index = ALPHABET.length - index
            }

            ciphered += ALPHABET[index]
        }
        return ciphered
    }
}
