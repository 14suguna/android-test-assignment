package com.touchsurgery.thesurgeonstodolist.dagger;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/touchsurgery/thesurgeonstodolist/dagger/MainActivityPresenterModule;", "", "()V", "provideDefaultListItems", "Ljava/util/ArrayList;", "Lcom/touchsurgery/thesurgeonstodolist/utils/Item;", "Lkotlin/collections/ArrayList;", "app_release"})
@dagger.Module
public final class MainActivityPresenterModule {
    
    public MainActivityPresenterModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final java.util.ArrayList<com.touchsurgery.thesurgeonstodolist.utils.Item> provideDefaultListItems() {
        return null;
    }
}