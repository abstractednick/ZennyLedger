package com.abstractednick.zennyledger.data.dao

import androidx.room.*
import com.abstractednick.zennyledger.data.model.TransactionEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for TransactionEntity operations
 * 
 * Provides CRUD operations and queries for transaction data
 */
@Dao
interface TransactionDao {
    
    /**
     * Get all transactions ordered by timestamp (newest first)
     */
    @Query("SELECT * FROM transactions ORDER BY timestamp DESC")
    fun getAllTransactions(): Flow<List<TransactionEntity>>
    
    /**
     * Get transaction by ID
     */
    @Query("SELECT * FROM transactions WHERE id = :id")
    suspend fun getTransactionById(id: Long): TransactionEntity?
    
    /**
     * Get transactions by type (debit/credit)
     */
    @Query("SELECT * FROM transactions WHERE type = :type ORDER BY timestamp DESC")
    fun getTransactionsByType(type: String): Flow<List<TransactionEntity>>
    
    /**
     * Get transactions by category
     */
    @Query("SELECT * FROM transactions WHERE category = :category ORDER BY timestamp DESC")
    fun getTransactionsByCategory(category: String): Flow<List<TransactionEntity>>
    
    /**
     * Get transactions by currency
     */
    @Query("SELECT * FROM transactions WHERE currency = :currency ORDER BY timestamp DESC")
    fun getTransactionsByCurrency(currency: String): Flow<List<TransactionEntity>>
    
    /**
     * Get total amount by transaction type
     */
    @Query("SELECT SUM(amount) FROM transactions WHERE type = :type")
    suspend fun getTotalByType(type: String): Double?
    
    /**
     * Get total amount by category
     */
    @Query("SELECT SUM(amount) FROM transactions WHERE category = :category")
    suspend fun getTotalByCategory(category: String): Double?
    
    /**
     * Get transactions within date range
     */
    @Query("SELECT * FROM transactions WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    fun getTransactionsByDateRange(startTime: Long, endTime: Long): Flow<List<TransactionEntity>>
    
    /**
     * Insert a new transaction
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionEntity): Long
    
    /**
     * Update an existing transaction
     */
    @Update
    suspend fun updateTransaction(transaction: TransactionEntity)
    
    /**
     * Delete a transaction
     */
    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)
    
    /**
     * Delete transaction by ID
     */
    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun deleteTransactionById(id: Long)
    
    /**
     * Delete all transactions
     */
    @Query("DELETE FROM transactions")
    suspend fun deleteAllTransactions()
}
