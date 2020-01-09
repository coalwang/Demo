package com.example.demo;

import android.content.Context;

public class SingClass {
    private static SingClass singClass;
    private static Context context;

    private SingClass(){}

    public static SingClass getInstance(Context ctx) {
        context = ctx;
        if (singClass == null) {
            context = ctx;
            singClass = new SingClass();
        }
        return singClass;
    }
}
