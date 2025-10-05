package com.abstractednick.zennyledger.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Reminder entity for transaction-related reminders
 * 
 * @property id Primary key, auto-generated
 * @property transactionId Foreign key referencing TransactionEntity.id
 * @property reminderTime Unix timestamp in milliseconds when reminder should trigger
 */
@Entity(
    tableName = "reminders",
    foreignKeys = [
        ForeignKey(
            entity = TransactionEntity::class,
            parentColumns = ["id"],
            childColumns = ["transactionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ReminderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val transactionId: Long,
    val reminderTime: Long
)
