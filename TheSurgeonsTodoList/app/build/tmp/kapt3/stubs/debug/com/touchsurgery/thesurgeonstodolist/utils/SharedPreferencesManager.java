package com.touchsurgery.thesurgeonstodolist.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/touchsurgery/thesurgeonstodolist/utils/SharedPreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getOrderAscending", "", "getOrderType", "", "setOrderAscending", "", "ascending", "setOrderType", "orderType", "Companion", "app_debug"})
public final class SharedPreferencesManager {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull
    public static final com.touchsurgery.thesurgeonstodolist.utils.SharedPreferencesManager.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREFS_NAME = "prefs";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREF_ORDER = "order";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREF_ASCENDING = "ascending";
    public static final int ORDER_TYPE_NAME = 0;
    public static final int ORDER_TYPE_PRIORITY = 1;
    
    public SharedPreferencesManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void setOrderType(int orderType) {
    }
    
    public final void setOrderAscending(boolean ascending) {
    }
    
    public final int getOrderType() {
        return 0;
    }
    
    public final boolean getOrderAscending() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/touchsurgery/thesurgeonstodolist/utils/SharedPreferencesManager$Companion;", "", "()V", "ORDER_TYPE_NAME", "", "ORDER_TYPE_PRIORITY", "PREFS_NAME", "", "PREF_ASCENDING", "PREF_ORDER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}