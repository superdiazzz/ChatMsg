package zulhija.nanda.chatmsg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import zulhija.nanda.chatmsg.screens.MainScreen
import zulhija.nanda.chatmsg.ui.theme.ChatMsgTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatMsgTheme {
                MainScreen(viewModel = hiltViewModel())
            }
        }
    }
}
