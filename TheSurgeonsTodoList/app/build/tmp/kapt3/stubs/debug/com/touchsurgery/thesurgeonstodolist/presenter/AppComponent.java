package com.touchsurgery.thesurgeonstodolist.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/touchsurgery/thesurgeonstodolist/presenter/AppComponent;", "", "provideDefaultListItems", "Ljava/util/ArrayList;", "Lcom/touchsurgery/thesurgeonstodolist/utils/Item;", "Lkotlin/collections/ArrayList;", "app_debug"})
@dagger.Component(modules = {com.touchsurgery.thesurgeonstodolist.dagger.MainActivityPresenterModule.class})
public abstract interface AppComponent {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.ArrayList<com.touchsurgery.thesurgeonstodolist.utils.Item> provideDefaultListItems();
}