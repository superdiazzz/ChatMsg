package zulhija.nanda.chatmsg.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import zulhija.nanda.chatmsg.data.Message
import zulhija.nanda.chatmsg.repositories.MessageRepository
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val repository: MessageRepository) : ViewModel() {
//    val messages: StateFlow<List<Message>> = repository.getAllMessages()
//        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
//
//    fun sendMessage(content: String, sender: String) {
//        viewModelScope.launch {
//            repository.insertMessage(Message(content = content, sender = sender))
//        }
//    }
}
