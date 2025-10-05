package com.abstractednick.zennyledger.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abstractednick.zennyledger.data.model.Transaction
import com.abstractednick.zennyledger.data.model.TransactionType
import com.abstractednick.zennyledger.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

/**
 * ViewModel for managing transaction-related UI state
 * 
 * This ViewModel demonstrates the use of @Inject annotation for dependency injection
 * with Hilt, injecting the TransactionRepository.
 */
@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(TransactionUiState())
    val uiState: StateFlow<TransactionUiState> = _uiState.asStateFlow()
    
    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions.asStateFlow()
    
    init {
        loadTransactions()
    }
    
    /**
     * Load all transactions from the repository
     */
    private fun loadTransactions() {
        viewModelScope.launch {
            transactionRepository.getAllTransactions()
                .catch { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
                .collect { transactionList ->
                    _transactions.value = transactionList
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = null
                    )
                }
        }
    }
    
    /**
     * Add a new transaction
     */
    fun addTransaction(
        amount: Double,
        currency: String,
        description: String,
        category: String,
        type: TransactionType,
        accountId: String = "default_account"
    ) {
        viewModelScope.launch {
            try {
                val transaction = Transaction(
                    amount = amount,
                    currency = currency,
                    description = description,
                    category = category,
                    type = type,
                    date = Date(),
                    accountId = accountId
                )
                
                transactionRepository.insertTransaction(transaction)
                
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = null
                )
            } catch (exception: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = exception.message
                )
            }
        }
    }
    
    /**
     * Delete a transaction
     */
    fun deleteTransaction(transaction: Transaction) {
        viewModelScope.launch {
            try {
                transactionRepository.deleteTransaction(transaction)
            } catch (exception: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = exception.message
                )
            }
        }
    }
    
    /**
     * Get total income
     */
    fun getTotalIncome(): Double {
        return _transactions.value
            .filter { it.type == TransactionType.INCOME }
            .sumOf { it.amount }
    }
    
    /**
     * Get total expenses
     */
    fun getTotalExpenses(): Double {
        return _transactions.value
            .filter { it.type == TransactionType.EXPENSE }
            .sumOf { it.amount }
    }
    
    /**
     * Get net balance (income - expenses)
     */
    fun getNetBalance(): Double {
        return getTotalIncome() - getTotalExpenses()
    }
}

/**
 * UI state for the Transaction screen
 */
data class TransactionUiState(
    val isLoading: Boolean = true,
    val error: String? = null
)
