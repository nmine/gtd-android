package be.nmine.gtd.presentation.fragment.inbox

import be.nmine.gtd.infrastructure.basket.InboxZero
import java.time.Duration

class InboxZeroDTO(var duration: Duration) {
    val litteralDurationInDay = StringBuilder().append(duration.toDays()).toString()


    companion object Factory {
        fun from(inbox: InboxZero): InboxZeroDTO {
            return InboxZeroDTO(Duration.ofMillis(inbox.timeStamp()))
        }
    }

}