package zulhija.nanda.chatmsg.repositories

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import zulhija.nanda.chatmsg.data.ChatDb
import zulhija.nanda.chatmsg.data.Message
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val chatDb: ChatDb
) : MessageRepository {


    override val lsMessages: Flow<List<Message>>
        get() = chatDb.messageDao().getAllMessages()

    override suspend fun insertMessage(message: Message) {

        chatDb.messageDao().insertMessage(message)

    }

}