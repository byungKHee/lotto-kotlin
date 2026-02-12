package domain.lotto

import org.example.domain.lotto.LottoNumber
import org.example.domain.lotto.LottoTicket
import org.example.domain.lotto.WinningLottoTicket
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTicketTest {
    @Test
    @DisplayName("유효한 당첨 로또 티켓을 생성할 수 있다.")
    fun generate_valid_winning_ticket() {
        val numbers = listOf<Int>(1,2,3,4,5,6)
        val bonusNumber = LottoNumber(7)
        val lottoTicket = LottoTicket(numbers.map { LottoNumber(it) })

        assertDoesNotThrow {
            WinningLottoTicket(lottoTicket, bonusNumber)
        }
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 수 없다")
    fun generate_invalid_winning_ticket() {
        val numbers = listOf<Int>(1,2,3,4,5,6)
        val bonusNumber = LottoNumber(6)
        val lottoTicket = LottoTicket(numbers.map { LottoNumber(it) })

        assertThrows<IllegalArgumentException> {
            WinningLottoTicket(lottoTicket, bonusNumber)
        }
    }
}