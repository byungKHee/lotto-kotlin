package org.example.domain.purchase

import org.example.domain.money.Money

class LottoReceipt (val money : Money, val autoCount : Int, val manualCount : Int) {
    init {
        require(autoCount >= 0) { "autoCount must be > 0" }

        require(manualCount >= 0) { "manualCount must be >= 0" }

        require(money.amount == (autoCount + manualCount) * LOTTO_PRICE.amount) {
            "구입 금액과 로또 개수가 일치하지 않습니다."
        }
    }
    companion object {
        val LOTTO_PRICE = Money(1000)
    }
}