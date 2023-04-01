package com.javarush.cryptanalyzer.zhidebaev;

import com.javarush.cryptanalyzer.zhidebaev.app.Application;
import com.javarush.cryptanalyzer.zhidebaev.controller.MainConroller;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.view.GUIView;
import com.javarush.cryptanalyzer.zhidebaev.view.View;

import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
       //-----------------------Test Mode-----------------------
        // t = new test();
        //Decode decode = new Decode();
       // fileIO io = new fileIO();
       GUIView gui = new GUIView();
      //  System.out.println(ALPHABET.length());
        //-------------------------------------------------------

        //-----------------------Main Mode-----------------------
        View view = new GUIView();
        MainConroller maincontroller = new MainConroller(view);
        Application application = new Application(maincontroller);
        Result result = application.run();
        System.out.println(result);

    }
}