// BookManager.aidl
package com.junhua.testandroid.aidl;

// Declare any non-default types here with import statements
import com.junhua.testandroid.aidl.Book;

interface BookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void addBook(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    void addBook(in Book book);
    Book getBook(in String id);
}