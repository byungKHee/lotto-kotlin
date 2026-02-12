package org.example.domain.lotto

data class LottoNumber(val value: Int) {

    init {
        require(value in 1..45) {
            "로또 숫자는 1에서 45 사이의 숫자여야 합니다."
        }
    }
}
