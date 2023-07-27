package com.touchsurgery.thesurgeonstodolist.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u00132\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006$"}, d2 = {"Lcom/touchsurgery/thesurgeonstodolist/activities/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/touchsurgery/thesurgeonstodolist/presenter/MainActivityPresenter$View;", "()V", "addItemFragment", "Lcom/touchsurgery/thesurgeonstodolist/activities/AddItemFragment;", "fab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "getFab", "()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "setFab", "(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V", "listFragment", "Lcom/touchsurgery/thesurgeonstodolist/activities/ListFragment;", "presenter", "Lcom/touchsurgery/thesurgeonstodolist/presenter/MainActivityPresenter;", "getPresenter", "()Lcom/touchsurgery/thesurgeonstodolist/presenter/MainActivityPresenter;", "loadItemFragment", "", "onAddItem", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "updateList", "list", "Ljava/util/ArrayList;", "Lcom/touchsurgery/thesurgeonstodolist/utils/Item;", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.touchsurgery.thesurgeonstodolist.presenter.MainActivityPresenter.View {
    @org.jetbrains.annotations.NotNull
    private final com.touchsurgery.thesurgeonstodolist.presenter.MainActivityPresenter presenter = null;
    private com.touchsurgery.thesurgeonstodolist.activities.ListFragment listFragment;
    private com.touchsurgery.thesurgeonstodolist.activities.AddItemFragment addItemFragment;
    public com.google.android.material.floatingactionbutton.FloatingActionButton fab;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.touchsurgery.thesurgeonstodolist.presenter.MainActivityPresenter getPresenter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.material.floatingactionbutton.FloatingActionButton getFab() {
        return null;
    }
    
    public final void setFab(@org.jetbrains.annotations.NotNull
    com.google.android.material.floatingactionbutton.FloatingActionButton p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadItemFragment() {
    }
    
    @java.lang.Override
    public void onAddItem() {
    }
    
    @java.lang.Override
    public void updateList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.touchsurgery.thesurgeonstodolist.utils.Item> list) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
}