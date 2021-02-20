package com.androidtutz.asystechs.ebookshop;

import android.app.Application;

import com.androidtutz.asystechs.ebookshop.di.AppModule;
import com.androidtutz.asystechs.ebookshop.di.DaggerEbookShopComponant;
import com.androidtutz.asystechs.ebookshop.di.EbookShopComponant;

public class DemoApplication extends Application {

    public static DemoApplication getApp() {
        return app;
    }

    public EbookShopComponant getmEbookShopComponant() {
        return mEbookShopComponant;
    }

    private EbookShopComponant mEbookShopComponant;


    private static DemoApplication app;
    @Override
    public void onCreate() {
        app =this;

        // intialize the dagger depedencies object to use in multiple activity.
        mEbookShopComponant= DaggerEbookShopComponant.
                builder()
                .appModule(new AppModule(this))
                .build();

        super.onCreate();
    }

}
