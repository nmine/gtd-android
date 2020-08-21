package be.nmine.gtd.infrastructure.basket

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class InboxZero(private var time: LocalDateTime) {

    fun update() {
        time = LocalDateTime.now()
    }

    fun timeStamp(): Long {
        return time.atZone(ZoneOffset.UTC).toEpochSecond()
    }

    companion object Factory {
        fun from(timestamp: Long): InboxZero {
            return InboxZero(
                time = LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(timestamp),
                    ZoneOffset.UTC
                )
            )
        }
    }

}