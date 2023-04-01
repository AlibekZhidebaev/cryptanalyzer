package com.javarush.cryptanalyzer.zhidebaev.controller;

import com.javarush.cryptanalyzer.zhidebaev.view.View;

public class MainConroller {
    private View view;


    public MainConroller(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
