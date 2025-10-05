package com.abstractednick.zennyledger.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.abstractednick.zennyledger.data.dao.ReminderDao
import com.abstractednick.zennyledger.data.dao.TransactionDao
import com.abstractednick.zennyledger.data.model.ReminderEntity
import com.abstractednick.zennyledger.data.model.TransactionEntity

/**
 * Room database for ZennyLedger application
 * 
 * This database contains tables for transactions and reminders.
 * Version 2 includes the new entity structure with simplified fields.
 */
@Database(
    entities = [
        TransactionEntity::class,
        ReminderEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class ZennyLedgerDatabase : RoomDatabase() {
    
    /**
     * Provides access to transaction data operations
     */
    abstract fun transactionDao(): TransactionDao
    
    /**
     * Provides access to reminder data operations
     */
    abstract fun reminderDao(): ReminderDao
    
    companion object {
        const val DATABASE_NAME = "zenny_ledger_database"
    }
}
