package com.hongkailiu.test.app;

import com.hongkailiu.test.app.cli.MyAppRunner;

/**
 * Hello world!
 */
public class App {

    private App() {
    }



    public static void main(String[] args) {

        MyAppRunner runner = new MyAppRunner();
        runner.runApp(args);
    }


}
