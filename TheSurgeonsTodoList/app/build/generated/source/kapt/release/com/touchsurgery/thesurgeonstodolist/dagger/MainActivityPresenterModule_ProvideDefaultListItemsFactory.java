package com.touchsurgery.thesurgeonstodolist.dagger;

import com.touchsurgery.thesurgeonstodolist.utils.Item;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivityPresenterModule_ProvideDefaultListItemsFactory
    implements Factory<ArrayList<Item>> {
  private final MainActivityPresenterModule module;

  public MainActivityPresenterModule_ProvideDefaultListItemsFactory(
      MainActivityPresenterModule module) {
    this.module = module;
  }

  @Override
  public ArrayList<Item> get() {
    return provideInstance(module);
  }

  public static ArrayList<Item> provideInstance(MainActivityPresenterModule module) {
    return proxyProvideDefaultListItems(module);
  }

  public static MainActivityPresenterModule_ProvideDefaultListItemsFactory create(
      MainActivityPresenterModule module) {
    return new MainActivityPresenterModule_ProvideDefaultListItemsFactory(module);
  }

  public static ArrayList<Item> proxyProvideDefaultListItems(MainActivityPresenterModule instance) {
    return Preconditions.checkNotNull(
        instance.provideDefaultListItems(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
