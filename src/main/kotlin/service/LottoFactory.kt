package org.example.service

import org.example.domain.lotto.LottoNumber
import org.example.domain.lotto.LottoTicket

class LottoFactory(private val lottoGenerator: LottoGenerator) {
    fun generate(): LottoTicket =
        LottoTicket(lottoGenerator.generate().map(::LottoNumber))
}
