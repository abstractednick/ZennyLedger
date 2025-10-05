package com.abstractednick.zennyledger.di

import android.content.Context
import androidx.room.Room
import com.abstractednick.zennyledger.data.dao.TransactionDao
import com.abstractednick.zennyledger.data.database.ZennyLedgerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for providing database dependencies
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    /**
     * Provides the Room database instance
     */
    @Provides
    @Singleton
    fun provideZennyLedgerDatabase(
        @ApplicationContext context: Context
    ): ZennyLedgerDatabase {
        return Room.databaseBuilder(
            context,
            ZennyLedgerDatabase::class.java,
            ZennyLedgerDatabase.DATABASE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()
    }
    
    /**
     * Provides the TransactionDao
     */
    @Provides
    fun provideTransactionDao(database: ZennyLedgerDatabase): TransactionDao {
        return database.transactionDao()
    }
}
