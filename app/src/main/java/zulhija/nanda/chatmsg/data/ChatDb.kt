package zulhija.nanda.chatmsg.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Message::class],
    version = 1,
    exportSchema = false)
abstract class ChatDb : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}
