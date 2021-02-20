package com.androidtutz.asystechs.ebookshop.di;

import com.androidtutz.asystechs.ebookshop.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {AppModule.class, RepositoryModule.class})
public interface EbookShopComponant {
    void inject(MainActivity mainActivity);
}
