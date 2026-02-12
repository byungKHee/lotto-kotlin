package org.example.domain.lotto

class LottoTicket(var lottoNumbers: List<LottoNumber>) {

    init {
        require(lottoNumbers.size == 6) {
            "로또 티켓은 6개의 숫자로만 구성될 수 있습니다."
        }
        require(lottoNumbers.toSet().size == 6) {
            "로또 티켓은 중복된 숫자를 가질 수 없습니다."
        }
    }

    fun countMatchingNumbers(other: LottoTicket): Int {
        return this.lottoNumbers.count({it in other})
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return this.lottoNumbers.contains(lottoNumber)
    }
}
