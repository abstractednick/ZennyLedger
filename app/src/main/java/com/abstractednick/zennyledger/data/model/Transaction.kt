package com.abstractednick.zennyledger.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Transaction entity representing a financial transaction in the database
 * 
 * @property id Primary key, auto-generated
 * @property amount Transaction amount
 * @property currency Currency code (e.g., "USD", "EUR")
 * @property type Transaction type - "debit" or "credit"
 * @property timestamp Unix timestamp in milliseconds
 * @property category Transaction category (e.g., "Food", "Transport", "Salary")
 */
@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val currency: String,
    val type: String, // "debit" or "credit"
    val timestamp: Long,
    val category: String
)
