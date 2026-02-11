package domain

import org.example.domain.LottoNumber
import org.example.domain.LottoTicket
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {
    @Test
    @DisplayName("6개의 LottoNumber로 구성된 로또 티켓을 생성할 수 있다.")
    fun generate_valid_lotto_ticket() {
        val numbers = listOf<Int>(1,2,3,4,5,6)
        val lottoNumbers = numbers.map { LottoNumber(it) }
        val lottoTicket = LottoTicket(lottoNumbers)
        assert(lottoTicket.lottoNumbers.size == 6)
    }

    @Test
    @DisplayName("로또 티켓은 6개의 숫자로만 구성될 수 있다.")
    fun generate_invalid_lotto_ticket() {
        val invalidnumbers1 = listOf<Int>(1,2,3,4,5)
        val invalidnumbers2 = listOf<Int>(1,2,3,4,5,6,7)

        val lottoNumbers1 = invalidnumbers1.map { LottoNumber(it) }
        val lottoNumbers2 = invalidnumbers2.map { LottoNumber(it) }

        assertThrows<IllegalArgumentException> {
            LottoTicket(lottoNumbers1)
        }
        assertThrows<IllegalArgumentException> {
            LottoTicket(lottoNumbers2)
        }
    }

    @Test
    @DisplayName("로또 티켓은 중복된 숫자를 가질 수 없다.")
    fun generate_lotto_ticket_with_duplicate_numbers() {
        val duplicatedNumbers = listOf<Int>(1,2,3,4,5,5)
        val lottoNumbers = duplicatedNumbers.map { LottoNumber(it) }

        assertThrows<IllegalArgumentException> {
            LottoTicket(lottoNumbers)
        }
    }
}