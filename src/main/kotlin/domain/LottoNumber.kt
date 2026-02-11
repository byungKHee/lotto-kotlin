package org.example.domain

data class LottoNumber(val value: Int) {

    init {
        require(value in 1..45) {
            "Lotto number must be between 1 and 45."
        }
    }
}
