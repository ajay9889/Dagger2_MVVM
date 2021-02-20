package com.androidtutz.asystechs.ebookshop.model;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.androidtutz.asystechs.ebookshop.WorkManager.InsertBulkData;

@Database(entities = {Category.class,Book.class},version = 1)
public abstract class BooksDatabase extends RoomDatabase {

    public abstract CategoryDAO categoryDAO();
    public abstract BookDAO bookDAO();

    private static BooksDatabase instance;

    public static synchronized BooksDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BooksDatabase.class, "books_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // New way using work manage

            OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(InsertBulkData.class).build();
            WorkManager.getInstance().enqueue(oneTimeWorkRequest);
                    // old way
//            new InitialDataAsyncTask(instance).execute();
        }
    };

}
