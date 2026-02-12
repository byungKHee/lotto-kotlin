package domain.purchase

import org.example.domain.money.Money
import org.example.domain.purchase.LottoReceipt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertFailsWith

class LottoReceiptTest {

    @Test
    fun issue_valid_receipt() {
        val totalPrice : Money = Money(10000)
        val autoCount : Int = 2
        val manualCount : Int = 8

        assertDoesNotThrow {
            val lottoReceipt: LottoReceipt = LottoReceipt(totalPrice, autoCount, manualCount)
        }
    }

    @Test
    fun issue_valid_receipt_with_auto_tickets_only() {
        val totalPrice : Money = Money(5000)
        val autoCount : Int = 5
        val manualCount : Int = 0

        assertDoesNotThrow {
            val lottoReceipt: LottoReceipt = LottoReceipt(totalPrice, autoCount, manualCount)
        }
    }

    @Test
    fun issue_valid_receipt_with_manual_tickets_only() {
        val totalPrice : Money = Money(2000)
        val autoCount : Int = 0
        val manualCount : Int = 2

        assertDoesNotThrow {
            val lottoReceipt: LottoReceipt = LottoReceipt(totalPrice, autoCount, manualCount)
        }
    }

    @Test
    fun issue_invalid_receipt_with_mismatched_price() {
        val totalPrice : Money = Money(3000)
        val autoCount : Int = 2
        val manualCount : Int = 2

        assertFailsWith<IllegalArgumentException> {
            val lottoReceipt: LottoReceipt = LottoReceipt(totalPrice, autoCount, manualCount)
        }
    }

    @Test
    fun issue_invalid_receipt_with_negative_ticket_count() {
        val totalPrice : Money = Money(5000)
        val autoCount : Int = -1
        val manualCount : Int = 6

        assertFailsWith<IllegalArgumentException> {
            val lottoReceipt: LottoReceipt = LottoReceipt(totalPrice, autoCount, manualCount)
        }
    }

    @Test
    @DisplayName("총 금액보다 적은 개수의 티켓으로 영수증을 발급할 수 없다.")
    fun issue_invalid_receipt_with_insufficient_tickets() {
        val totalPrice : Money = Money(6000)
        val autoCount : Int = 3
        val manualCount : Int = 2

        assertFailsWith<IllegalArgumentException> {
            val lottoReceipt : LottoReceipt = LottoReceipt(totalPrice, autoCount, manualCount)
        }
    }

}