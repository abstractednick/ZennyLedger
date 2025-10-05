package com.abstractednick.zennyledger.data.dao

import androidx.room.*
import com.abstractednick.zennyledger.data.model.Transaction
import com.abstractednick.zennyledger.data.model.TransactionType
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Transaction operations
 */
@Dao
interface TransactionDao {
    
    @Query("SELECT * FROM transactions ORDER BY date DESC")
    fun getAllTransactions(): Flow<List<Transaction>>
    
    @Query("SELECT * FROM transactions WHERE id = :id")
    suspend fun getTransactionById(id: Long): Transaction?
    
    @Query("SELECT * FROM transactions WHERE type = :type ORDER BY date DESC")
    fun getTransactionsByType(type: TransactionType): Flow<List<Transaction>>
    
    @Query("SELECT * FROM transactions WHERE category = :category ORDER BY date DESC")
    fun getTransactionsByCategory(category: String): Flow<List<Transaction>>
    
    @Query("SELECT * FROM transactions WHERE accountId = :accountId ORDER BY date DESC")
    fun getTransactionsByAccount(accountId: String): Flow<List<Transaction>>
    
    @Query("SELECT SUM(amount) FROM transactions WHERE type = :type")
    suspend fun getTotalByType(type: TransactionType): Double?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction): Long
    
    @Update
    suspend fun updateTransaction(transaction: Transaction)
    
    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
    
    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun deleteTransactionById(id: Long)
    
    @Query("DELETE FROM transactions")
    suspend fun deleteAllTransactions()
}
