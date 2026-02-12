package org.example.service

class ManualLottoGenerator (
    val picks : List<Int> = listOf(1,2,3,4,5,6)
): LottoGenerator {
    override fun generate(): List<Int> {
        return picks.sorted()

    }
}