package be.nmine.gtd.unit

import be.nmine.gtd.infrastructure.basket.InboxZero
import be.nmine.gtd.presentation.fragment.inbox.InboxZeroDTO
import org.fest.assertions.Assertions
import org.junit.Test
import java.time.Instant

class InboxZeroDTOTest {

    @Test
    fun `can have InboxDTO from Inbox`() {
        //Given
        val ondDayMilli: Long = 86400000
        val inbox = InboxZero.from(ondDayMilli)
        //When
        val result = InboxZeroDTO.from(inbox)
        //Then
        val onDay: Long = 1
        Assertions.assertThat(result.duration.toDays()).isEqualTo(onDay)
    }

    @Test
    fun `can have InboxDTO from Inbox with correct period`() {
        //Given
        val dayInMilli = 86400000
        val securityInterval = 1000
        val inboxZero = InboxZero.from(Instant.now().toEpochMilli()
                -(dayInMilli + securityInterval))
        inboxZero.update()
        //When
        val result = InboxZeroDTO.from(inboxZero)
        //Then
        val oneDay: Long = 1
        Assertions.assertThat(result.duration.toDays()).isEqualTo(oneDay)
    }

    @Test
    fun `can get day in string from InboxZeroDTO`() {
        //Given
        val dayInMilli = 86400000
        val securityInterval = 1000
        val inboxZero = InboxZero.from(Instant.now().toEpochMilli()
                -(dayInMilli + securityInterval))
        inboxZero.update()
        //When
        val result = InboxZeroDTO.from(inboxZero).litteralDurationInDay
        //Then
        val oneDay: Long = 1
        Assertions.assertThat(result).isEqualTo("1")
    }
}