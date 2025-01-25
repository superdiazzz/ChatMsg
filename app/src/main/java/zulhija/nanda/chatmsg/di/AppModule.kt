package zulhija.nanda.chatmsg.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import zulhija.nanda.chatmsg.data.ChatDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : ChatDb {
        synchronized(ChatDb::class.java){
            return Room.databaseBuilder(
                context, ChatDb::class.java, "chat.db"
            )
                .build()
        }
    }
}