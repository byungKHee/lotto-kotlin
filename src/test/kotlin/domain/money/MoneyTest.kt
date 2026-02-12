package domain.money

import org.example.domain.money.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun create_valid_money() {
        assertDoesNotThrow {
            val money: Money = Money(5000)
            val money_zero: Money = Money(0)
        }
    }

    @Test
    fun create_invalid_money() {
        assertThrows<IllegalArgumentException> {
            val money: Money = Money(-1000)
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

    @Test
    fun multiply_money_objects() {
        // valid case
        val money: Money = Money(4000)
        val resultMoney: Money = money * 3
        assert(resultMoney == Money(12000))

        // invalid case
        assertThrows<IllegalArgumentException> {
            val moneyInvalid: Money = Money(4000)
            val resultMoneyInvalid: Money = moneyInvalid * -2
        }
    }

    @Test
    fun divide_money_objects() {
        // valid case: Money 간의 나눗셈
        val money: Money = Money(8000)
        val resultMoney: Money = money / 4
        assert(resultMoney == Money(2000))

        // valid case: Money 와 Int 간의 나눗셈
        val moneyDivInt: Money = Money(9000)
        val resultMoneyDivInt: Money = moneyDivInt / 3
        assert(resultMoneyDivInt == Money(3000))

        // invalid case: division by zero
        assertThrows<IllegalArgumentException> {
            val moneyInvalid: Money = Money(8000)
            val resultMoneyInvalid: Money = moneyInvalid / 0
        }

        // invalid case: division by negative number
        assertThrows<IllegalArgumentException> {
            val moneyInvalid: Money = Money(8000)
            val resultMoneyInvalid: Money = moneyInvalid / -2
        }

        // invalid case: Money 간의 나눗셈에서 몫이 아닌 경우
        assertThrows<IllegalArgumentException> {
            val moneyInvalid: Money = Money(8500)
            val resultMoneyInvalid: Money = moneyInvalid / 3
        }

        // invalid case: Money 와 Int 간의 나눗셈에서 몫이 아닌 경우
        assertThrows<IllegalArgumentException> {
            val moneyInvalid: Money = Money(8500)
            val resultMoneyInvalid: Money = moneyInvalid / 7
        }
    }
}