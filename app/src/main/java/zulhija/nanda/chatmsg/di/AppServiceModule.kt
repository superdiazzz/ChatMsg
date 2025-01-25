package zulhija.nanda.chatmsg.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zulhija.nanda.chatmsg.repositories.MessageRepository
import zulhija.nanda.chatmsg.repositories.MessageRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class AppServiceModule {

    @Binds
    abstract fun provideMessageRepository(messageRepository: MessageRepositoryImpl): MessageRepository
}