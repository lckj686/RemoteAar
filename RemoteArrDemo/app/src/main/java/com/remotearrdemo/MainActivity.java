package com.remotearrdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mylibrary.Hello;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hello hello = new Hello();
        String s = hello.getWord();

    }
}
