package org.example.domain.money

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

    operator fun times(other : Int) : Money {
        if (other < 0) {
            throw IllegalArgumentException("Money 곱셈의 피연산자는 음수일 수 없습니다.")
        }
        return Money(this.amount * other)
    }

    operator fun div(other : Money) : Int {
        require(other != Money(0)) {
            "Money 나눗셈의 피연산자는 0일 수 없습니다."
        }
        require(this.amount % other.amount == 0L) {
            "Money간의 나눗셈 결과는 정수여야 합니다."
        }
        return (this.amount / other.amount).toInt()
    }

    operator fun div(other : Int) : Money {
        require(other > 0) {
            "Money 나눗셈의 피연산자는 0 이하일 수 없습니다."
        }
        require(this.amount % other == 0L) {
            "정수로 나누어 떨어지지 않는 Money 나눗셈은 지원하지 않습니다."
        }
        return Money(this.amount / other)
    }

    operator fun compareTo(other : Money) : Int {
        return this.amount.compareTo(other.amount)
    }
}