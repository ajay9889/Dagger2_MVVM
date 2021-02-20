package com.androidtutz.asystechs.ebookshop.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.androidtutz.asystechs.ebookshop.model.Book;
import com.androidtutz.asystechs.ebookshop.model.Category;
import com.androidtutz.asystechs.ebookshop.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(EBookShopRepository mEbookRepository) {
     eBookShopRepository=mEbookRepository;
    }

    public LiveData<List<Category>> getAllCategories() {

        allCategories=eBookShopRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId) {

        booksOfASelectedCategory=eBookShopRepository.getBooks(categoryId);
        return booksOfASelectedCategory;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }

    public void updateBook(Book book){
        eBookShopRepository.updateBook(book);
    }

    public void deleteBook(Book book){
        eBookShopRepository.deleteBook(book);
    }
}