package org.example.domain

class WinningLottoTicket(val lottoTicket: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in lottoTicket) {
            "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        }
    }
}
