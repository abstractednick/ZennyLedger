package com.abstractednick.zennyledger.data.dao

import androidx.room.*
import com.abstractednick.zennyledger.data.model.ReminderEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for ReminderEntity operations
 * 
 * Provides CRUD operations and queries for reminder data
 */
@Dao
interface ReminderDao {
    
    /**
     * Get all reminders ordered by reminder time
     */
    @Query("SELECT * FROM reminders ORDER BY reminderTime ASC")
    fun getAllReminders(): Flow<List<ReminderEntity>>
    
    /**
     * Get reminder by ID
     */
    @Query("SELECT * FROM reminders WHERE id = :id")
    suspend fun getReminderById(id: Long): ReminderEntity?
    
    /**
     * Get reminders by transaction ID
     */
    @Query("SELECT * FROM reminders WHERE transactionId = :transactionId ORDER BY reminderTime ASC")
    fun getRemindersByTransactionId(transactionId: Long): Flow<List<ReminderEntity>>
    
    /**
     * Get reminders that are due (reminderTime <= current time)
     */
    @Query("SELECT * FROM reminders WHERE reminderTime <= :currentTime ORDER BY reminderTime ASC")
    suspend fun getDueReminders(currentTime: Long): List<ReminderEntity>
    
    /**
     * Get upcoming reminders (reminderTime > current time)
     */
    @Query("SELECT * FROM reminders WHERE reminderTime > :currentTime ORDER BY reminderTime ASC")
    fun getUpcomingReminders(currentTime: Long): Flow<List<ReminderEntity>>
    
    /**
     * Get reminders within a specific time range
     */
    @Query("SELECT * FROM reminders WHERE reminderTime BETWEEN :startTime AND :endTime ORDER BY reminderTime ASC")
    fun getRemindersByTimeRange(startTime: Long, endTime: Long): Flow<List<ReminderEntity>>
    
    /**
     * Insert a new reminder
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: ReminderEntity): Long
    
    /**
     * Update an existing reminder
     */
    @Update
    suspend fun updateReminder(reminder: ReminderEntity)
    
    /**
     * Delete a reminder
     */
    @Delete
    suspend fun deleteReminder(reminder: ReminderEntity)
    
    /**
     * Delete reminder by ID
     */
    @Query("DELETE FROM reminders WHERE id = :id")
    suspend fun deleteReminderById(id: Long)
    
    /**
     * Delete all reminders for a specific transaction
     */
    @Query("DELETE FROM reminders WHERE transactionId = :transactionId")
    suspend fun deleteRemindersByTransactionId(transactionId: Long)
    
    /**
     * Delete all reminders
     */
    @Query("DELETE FROM reminders")
    suspend fun deleteAllReminders()
    
    /**
     * Delete expired reminders (reminderTime < current time)
     */
    @Query("DELETE FROM reminders WHERE reminderTime < :currentTime")
    suspend fun deleteExpiredReminders(currentTime: Long)
}
