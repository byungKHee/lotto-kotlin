package domain

import org.example.domain.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun create_valid_money() {
        assertDoesNotThrow {
            val money: Money = Money(5000)
            val money_zero : Money = Money(0)
        }
    }

    @Test
    fun create_invalid_money() {
        assertThrows<IllegalArgumentException> {
            val money : Money = Money(-1000)
        }
    }

    @Test
    fun compare_money_objects() {
        val money1: Money = Money(3000)
        val money2: Money = Money(3000)
        val money3: Money = Money(5000)

        assert(money1 == money2)
        assert(money1 != money3)
    }

    @Test
    fun add_money_objects() {
        val money1: Money = Money(2000)
        val money2: Money = Money(3000)
        val totalMoney: Money = money1 + money2

        assert(totalMoney == Money(5000))
    }

    @Test
    fun subtract_money_objects() {
        val money1: Money = Money(7000)
        val money2: Money = Money(2000)
        val resultMoney: Money = money1 - money2

        assert(resultMoney == Money(5000))
    }
}