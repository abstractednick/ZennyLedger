package com.abstractednick.zennyledger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * ZennyLedger Application class
 * 
 * This class serves as the entry point for the Hilt dependency injection framework.
 * It's annotated with @HiltAndroidApp to enable Hilt in the application.
 * 
 * Hilt will automatically generate the necessary code for dependency injection
 * and create the ApplicationComponent that other components can depend on.
 */
@HiltAndroidApp
class ZennyLedgerApp : Application() {
    
    override fun onCreate() {
        super.onCreate()
        // Application initialization logic can be added here
        // Hilt initialization is handled automatically
    }
}
