package com.example.javajoke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JokeSender {

    private static final String TAG = JokeSender.class.getSimpleName();
    private List<String> jokes = new ArrayList<String>();

    public JokeSender(){
        jokes.add("This is a very funny joke from Java library JokeSender");
        jokes.add("This is second funny joke from Java library JokeSender");
        jokes.add("This is third funny joke from Java library JokeSender");
        jokes.add("This is fourth funny joke from Java library JokeSender");
    }

    public String getJoke(){

        int random = new Random().nextInt(jokes.size());
        return jokes.get(random);
    }
}
