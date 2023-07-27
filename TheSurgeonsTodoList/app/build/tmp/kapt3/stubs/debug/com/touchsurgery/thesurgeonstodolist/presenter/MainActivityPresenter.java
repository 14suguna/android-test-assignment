package com.touchsurgery.thesurgeonstodolist.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000eR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/touchsurgery/thesurgeonstodolist/presenter/MainActivityPresenter;", "", "view", "Lcom/touchsurgery/thesurgeonstodolist/presenter/MainActivityPresenter$View;", "(Lcom/touchsurgery/thesurgeonstodolist/presenter/MainActivityPresenter$View;)V", "list", "Ljava/util/ArrayList;", "Lcom/touchsurgery/thesurgeonstodolist/utils/Item;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "addItem", "", "item", "removeItem", "pos", "", "updateList", "View", "app_debug"})
public final class MainActivityPresenter {
    private final com.touchsurgery.thesurgeonstodolist.presenter.MainActivityPresenter.View view = null;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.touchsurgery.thesurgeonstodolist.utils.Item> list;
    
    public MainActivityPresenter(@org.jetbrains.annotations.NotNull
    com.touchsurgery.thesurgeonstodolist.presenter.MainActivityPresenter.View view) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.touchsurgery.thesurgeonstodolist.utils.Item> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.touchsurgery.thesurgeonstodolist.utils.Item> p0) {
    }
    
    public final void addItem(@org.jetbrains.annotations.NotNull
    com.touchsurgery.thesurgeonstodolist.utils.Item item) {
    }
    
    public final void removeItem(int pos) {
    }
    
    public final void updateList() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH&\u00a8\u0006\t"}, d2 = {"Lcom/touchsurgery/thesurgeonstodolist/presenter/MainActivityPresenter$View;", "", "onAddItem", "", "updateList", "list", "Ljava/util/ArrayList;", "Lcom/touchsurgery/thesurgeonstodolist/utils/Item;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static abstract interface View {
        
        public abstract void onAddItem();
        
        public abstract void updateList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.touchsurgery.thesurgeonstodolist.utils.Item> list);
    }
}