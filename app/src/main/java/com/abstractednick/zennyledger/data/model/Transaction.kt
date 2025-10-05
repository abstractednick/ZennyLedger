package com.abstractednick.zennyledger.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Transaction entity representing a financial transaction in the database
 */
@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val currency: String,
    val description: String,
    val category: String,
    val type: TransactionType,
    val date: Date,
    val accountId: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

/**
 * Enum representing the type of transaction
 */
enum class TransactionType {
    INCOME,
    EXPENSE,
    TRANSFER
}
