package com.androidtutz.asystechs.ebookshop.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.androidtutz.asystechs.ebookshop.model.EBookShopRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainViewModelFactory implements ViewModelProvider.Factory {

    EBookShopRepository eBookShopRepository;

    @Inject
    MainViewModelFactory(EBookShopRepository eBookShopRepository){
        this. eBookShopRepository=eBookShopRepository;
    };

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new MainActivityViewModel(eBookShopRepository);
    }
}
