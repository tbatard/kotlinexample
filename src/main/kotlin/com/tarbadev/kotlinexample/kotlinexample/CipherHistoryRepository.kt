package com.tarbadev.kotlinexample.kotlinexample

interface CipherHistoryRepository {
    fun save(cipheredValue: CipheredValue)
}
