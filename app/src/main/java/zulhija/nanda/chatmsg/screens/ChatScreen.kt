package zulhija.nanda.chatmsg.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zulhija.nanda.chatmsg.Constants
import zulhija.nanda.chatmsg.Constants.Color3
import zulhija.nanda.chatmsg.data.Message
import zulhija.nanda.chatmsg.viewmodels.ChatViewModel

@Composable
fun ChatScreen(
    title: String,
    messages: List<Message>,
    onSendMessage: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var messageInput by remember { mutableStateOf("") }

    val focurManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = if (title == "Left Chat") Constants.Color1 else Constants.Color2)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Display messages
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            messages.forEach { message ->

                if (message.sender == "left") {
                    Column {
                        Text(text = message.sender,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = if (title == "Left Chat") TextAlign.End else TextAlign.Start,
                            modifier = Modifier.fillMaxWidth())
                        Text(
                            textAlign = if (title == "Left Chat") TextAlign.End else TextAlign.Start,
                            text = message.content,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }

                }
                else {
                    Column {
                        Text(
                            textAlign = if (title == "Left Chat") TextAlign.Start else TextAlign.End,
                            text = message.sender,
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            textAlign = if (title == "Left Chat") TextAlign.Start else TextAlign.End,
                            text = message.content,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))


            }
        }

        // Message input
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = messageInput,
                onValueChange = { messageInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(
                    onSend = {
                        if (messageInput.isNotBlank()) {
                            onSendMessage(messageInput)
                            messageInput = ""
                        }
                        focurManager.clearFocus()
                    }
                ),
                textStyle = TextStyle(fontSize = 32.sp),
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color3, shape = RoundedCornerShape(16.dp))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (messageInput.isNotBlank()) {
                    onSendMessage(messageInput)
                    messageInput = ""
                }
                focurManager.clearFocus()

            }) {
                Text(text = "Send")
            }
        }
    }
}


