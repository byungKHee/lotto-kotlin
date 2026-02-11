package org.example.domain

import java.util.Random

class AutoLottoGenerator(
    val random : Random = Random()
) : LottoGenerator {
    override fun generate(): List<Int> {
        val lottoNumbers = mutableSetOf<Int>()
        while (lottoNumbers.size < 6) {
            val number = random.nextInt(1, 46)
            lottoNumbers.add(number)
        }
        return lottoNumbers.sorted()
    }
}