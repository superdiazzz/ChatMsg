package zulhija.nanda.chatmsg.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val sender: String, // "left" or "right"
    val timestamp: Long = System.currentTimeMillis()
)