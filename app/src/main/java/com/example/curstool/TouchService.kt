package com.example.curstool

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class TouchService : AccessibilityService() {
    override fun onInterrupt() {}

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
}