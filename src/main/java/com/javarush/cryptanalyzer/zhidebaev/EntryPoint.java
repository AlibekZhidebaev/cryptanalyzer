package com.javarush.cryptanalyzer.zhidebaev;

import com.javarush.cryptanalyzer.zhidebaev.app.Application;
import com.javarush.cryptanalyzer.zhidebaev.controller.MainController;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.view.ConsoleView;
import com.javarush.cryptanalyzer.zhidebaev.view.GUIView;
import com.javarush.cryptanalyzer.zhidebaev.view.View;

import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {

        //-----------------------Main Mode-----------------------
        //View view = new GUIView();
        View view = new ConsoleView();
        MainController maincontroller = new MainController(view);
        Application application = new Application(maincontroller);
        Result result = application.run();
        System.out.println(result);

        //-----------------------Test Mode-----------------------
        // t = new test();
        //Decode decode = new Decode();
        // fileIO io = new fileIO();
        // GUIView gui = new GUIView();
        //  System.out.println(ALPHABET.length());
        //-------------------------------------------------------

    }
}