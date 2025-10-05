package com.abstractednick.zennyledger.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.abstractednick.zennyledger.data.dao.TransactionDao
import com.abstractednick.zennyledger.data.model.Transaction
import com.abstractednick.zennyledger.data.converter.DateConverter

/**
 * Room database for ZennyLedger application
 */
@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class ZennyLedgerDatabase : RoomDatabase() {
    
    abstract fun transactionDao(): TransactionDao
    
    companion object {
        const val DATABASE_NAME = "zenny_ledger_database"
    }
}
