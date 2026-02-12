package service

import org.example.service.AutoLottoGenerator
import org.example.service.LottoFactory
import org.example.service.ManualLottoGenerator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoFactoryTest {
    @Test
    @DisplayName("자동 로또 티켓 생성한다.")
    fun generate_lotto_ticket() {
        val lottoTicket = LottoFactory(AutoLottoGenerator()).generate()
        assert(lottoTicket.lottoNumbers.size == 6)
    }

    @Test
    @DisplayName("수동 로또 티켓 생성한다.")
    fun generate_manual_lotto_ticket() {
        val numbers = listOf<Int>(3,11,15,29,35,44)
        val lottoTicket = LottoFactory(ManualLottoGenerator(numbers)).generate()
        assert(lottoTicket.lottoNumbers.size == 6)
    }
}