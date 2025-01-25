package zulhija.nanda.chatmsg.repositories

import kotlinx.coroutines.flow.Flow
import zulhija.nanda.chatmsg.data.Message
import zulhija.nanda.chatmsg.data.MessageDao
import javax.inject.Inject
import javax.inject.Singleton


interface MessageRepository {

    val lsMessages : Flow<List<Message>>
    suspend fun insertMessage(message: Message)

}

//
//@Singleton
//class MessageRepository @Inject constructor(private val messageDao: MessageDao) {
//    fun getAllMessages() = messageDao.getAllMessages()
//
//    suspend fun insertMessage(message: Message) {
//        messageDao.insertMessage(message)
//    }
//}
