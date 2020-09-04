package be.nmine.gtd.infrastructure.basket

import java.time.Duration
import java.time.Instant

class InboxZero(private var time: Duration) {

    fun update() {
        time = Duration.ofMillis( Instant.now().toEpochMilli() - time.toMillis())
    }

    fun timeStamp(): Long {
        return time.toMillis()
    }

    companion object Factory {
        fun from(timestamp: Long): InboxZero {
            return InboxZero(
                time = Duration.ofMillis(timestamp)
            )
        }
    }

}