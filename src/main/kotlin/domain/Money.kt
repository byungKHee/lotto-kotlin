package org.example.domain

data class Money(val amount: Long) {

    init {
        require(amount >= 0) {
            "금액은 음수일 수 없습니다."
        }
    }

    operator fun plus(other : Money) : Money {
        return Money(this.amount + other.amount)
    }

    operator fun minus(other : Money) : Money {
        val result = this.amount - other.amount
        require(result >= 0) {
            "금액은 음수일 수 없습니다."
        }
        return Money(result)
    }

    operator fun compareTo(other : Money) : Int {
        return this.amount.compareTo(other.amount)
    }
}