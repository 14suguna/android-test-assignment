package com.touchsurgery.thesurgeonstodolist.presenter;

import com.touchsurgery.thesurgeonstodolist.dagger.MainActivityPresenterModule;
import com.touchsurgery.thesurgeonstodolist.dagger.MainActivityPresenterModule_ProvideDefaultListItemsFactory;
import com.touchsurgery.thesurgeonstodolist.utils.Item;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private MainActivityPresenterModule mainActivityPresenterModule;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.mainActivityPresenterModule = builder.mainActivityPresenterModule;
  }

  @Override
  public ArrayList<Item> provideDefaultListItems() {
    return MainActivityPresenterModule_ProvideDefaultListItemsFactory.proxyProvideDefaultListItems(
        mainActivityPresenterModule);
  }

  public static final class Builder {
    private MainActivityPresenterModule mainActivityPresenterModule;

    private Builder() {}

    public AppComponent build() {
      if (mainActivityPresenterModule == null) {
        this.mainActivityPresenterModule = new MainActivityPresenterModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder mainActivityPresenterModule(
        MainActivityPresenterModule mainActivityPresenterModule) {
      this.mainActivityPresenterModule = Preconditions.checkNotNull(mainActivityPresenterModule);
      return this;
    }
  }
}
