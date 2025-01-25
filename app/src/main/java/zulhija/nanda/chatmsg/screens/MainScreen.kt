package zulhija.nanda.chatmsg.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import zulhija.nanda.chatmsg.data.Message
import zulhija.nanda.chatmsg.viewmodels.ChatViewModel


@Composable
fun MainScreen(viewModel: ChatViewModel) {

    val messages by viewModel.messages.collectAsState()
    val onSendMessage: (String, String) -> Unit = { content, sender ->
        viewModel.sendMessage(content, sender)
    }

    Scaffold { paddingValues ->
        ChatPagerScreen(
            modifier = Modifier.padding(paddingValues),
            messagesLeft = messages,
            onSendMessage = onSendMessage
        )
    }


}

