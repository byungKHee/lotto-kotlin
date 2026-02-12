package domain.lotto

import org.example.domain.lotto.LottoNumber
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class LottoNumberTest {
    @Test
    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
    fun generate_valid_lotto_number() {
        val lottoNumber = LottoNumber(5)
        assert(lottoNumber.value == 5)
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    fun generate_invalid_lotto_number() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }

        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }

    @Test
    @DisplayName("같은 숫자의 로또 번호는 같은 객체로 취급된다.")
    fun same_lotto_number_is_same_object() {
        val lottoNumber1 = LottoNumber(10)
        val lottoNumber2 = LottoNumber(10)
        assertEquals(true, lottoNumber1 == lottoNumber2)
    }
}