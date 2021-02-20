package com.androidtutz.asystechs.ebookshop.di;

import android.app.Application;

import com.androidtutz.asystechs.ebookshop.model.EBookShopRepository;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    EBookShopRepository provideEbookShopRespository(Application application){
        return new EBookShopRepository(application);
    }
}
