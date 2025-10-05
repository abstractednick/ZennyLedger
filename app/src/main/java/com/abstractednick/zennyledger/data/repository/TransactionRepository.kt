package com.abstractednick.zennyledger.data.repository

import com.abstractednick.zennyledger.data.dao.TransactionDao
import com.abstractednick.zennyledger.data.model.Transaction
import com.abstractednick.zennyledger.data.model.TransactionType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository for managing transaction data
 */
@Singleton
class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao
) {
    
    /**
     * Get all transactions as a Flow
     */
    fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }
    
    /**
     * Get transaction by ID
     */
    suspend fun getTransactionById(id: Long): Transaction? {
        return transactionDao.getTransactionById(id)
    }
    
    /**
     * Get transactions by type
     */
    fun getTransactionsByType(type: TransactionType): Flow<List<Transaction>> {
        return transactionDao.getTransactionsByType(type)
    }
    
    /**
     * Get transactions by category
     */
    fun getTransactionsByCategory(category: String): Flow<List<Transaction>> {
        return transactionDao.getTransactionsByCategory(category)
    }
    
    /**
     * Get transactions by account
     */
    fun getTransactionsByAccount(accountId: String): Flow<List<Transaction>> {
        return transactionDao.getTransactionsByAccount(accountId)
    }
    
    /**
     * Get total amount by transaction type
     */
    suspend fun getTotalByType(type: TransactionType): Double {
        return transactionDao.getTotalByType(type) ?: 0.0
    }
    
    /**
     * Insert a new transaction
     */
    suspend fun insertTransaction(transaction: Transaction): Long {
        return transactionDao.insertTransaction(transaction)
    }
    
    /**
     * Update an existing transaction
     */
    suspend fun updateTransaction(transaction: Transaction) {
        transactionDao.updateTransaction(transaction)
    }
    
    /**
     * Delete a transaction
     */
    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }
    
    /**
     * Delete transaction by ID
     */
    suspend fun deleteTransactionById(id: Long) {
        transactionDao.deleteTransactionById(id)
    }
    
    /**
     * Delete all transactions
     */
    suspend fun deleteAllTransactions() {
        transactionDao.deleteAllTransactions()
    }
}
