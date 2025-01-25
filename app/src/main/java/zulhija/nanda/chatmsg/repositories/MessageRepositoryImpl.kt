package zulhija.nanda.chatmsg.repositories

import zulhija.nanda.chatmsg.data.ChatDb
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val chatDb: ChatDb
) : MessageRepository {

}