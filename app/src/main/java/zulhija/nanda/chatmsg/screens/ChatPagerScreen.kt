package zulhija.nanda.chatmsg.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import zulhija.nanda.chatmsg.data.Message

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatPagerScreen(modifier: Modifier,
                    messagesLeft: List<Message>,
                    onSendMessage: (String, String) -> Unit) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column (modifier = modifier){
        HorizontalPager(
            count = 2, // Two screens: Left Chat and Right Chat
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> ChatScreen(
                    title = "Left Chat",
                    messages = messagesLeft,
                    onSendMessage = { content ->
                        onSendMessage(content, "left")
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                )
                1 -> ChatScreen(
                    title = "Right Chat",
                    messages = messagesLeft,
                    onSendMessage = { content ->
                        onSendMessage(content, "right")
                        scope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    }
                )
            }
        }

        // Optional: Page Indicators
        HorizontalPagerIndicator(
            pagerState = pagerState,
        )
    }


}