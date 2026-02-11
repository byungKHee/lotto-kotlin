package org.example.domain

class LottoFactory(private val lottoGenerator: LottoGenerator) {
    fun generate(): LottoTicket =
        LottoTicket(lottoGenerator.generate().map(::LottoNumber))
}
