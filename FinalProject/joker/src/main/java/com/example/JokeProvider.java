package com.example;

import java.util.ArrayList;
import java.util.List;

public class JokeProvider {

    List<Joke> jokes;
    private int badJokeIndex = -1;
    private int goodJokeIndex = -1;

    public JokeProvider(){
        initialize();
    }

    private void initialize(){
        jokes = new ArrayList<>(10);
        jokes.add(new Joke(true,"A man asks a farmer near a field, \"Sorry sir, would you mind if I crossed your field instead of going around it? You see, I have to catch the 4:23 train.\"\n" +
                "\n" +
                "The farmer says, \"Sure, go right ahead. And if my bull sees you, you’ll even catch the 4:11 one.\" \n" +
                "\n" +
                "More jokes at: http://www.short-funny.com/#ixzz4PnSuB0ik"));

        jokes.add(new Joke(true,"My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.\n" +
                "\n" +
                "More jokes at: http://www.short-funny.com/#ixzz4PnT12FUO"));
        jokes.add(new Joke(true,"What is the difference between a snowman and a snowwoman?\n" +
                "-\n" +
                "Snowballs.\n" +
                "\n" +
                "More jokes at: http://www.short-funny.com/#ixzz4PnTAw6ZQ"));
        jokes.add(new Joke(true,"Mother, \"How was school today, Patrick?\"\n" +
                "\n" +
                "Patrick, \"It was really great mum! Today we made explosives!\"\n" +
                "\n" +
                "Mother, \"Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow?\"\n" +
                "\n" +
                "Patrick, \"What school?\"\n" +
                "\n" +
                "More jokes at: http://www.short-funny.com/#ixzz4PnTCuh7k"));
        jokes.add(new Joke(true,"Knock, knock!\n" +
                "\n" +
                "Who’s there?\n" +
                "\n" +
                "Opportunity!\n" +
                "\n" +
                "That is impossible. Opportunity doesn’t come knocking twice!\n" +
                "\n" +
                "More jokes at: http://www.short-funny.com/best-knock-jokes.php#ixzz4PnTIjNPy"));
        jokes.add(new Joke(true,"Knock knock.\n" +
                "\n" +
                "Who's there?\n" +
                "\n" +
                "Beats.\n" +
                "\n" +
                "Beats who?\n" +
                "\n" +
                "Beats me.\n" +
                "\n" +
                "More jokes at: http://www.short-funny.com/best-knock-jokes.php#ixzz4PnTMRsqT"));
        jokes.add(new Joke(true,"Why did the chicken cross the road?\n" +
                "\n" +
                "To hunt somebody down.\n" +
                "\n" +
                "Knock knock.\n" +
                "\n" +
                "Who's there? \n" +
                "\n" +
                "The chicken.\n" +
                "\n" +
                "More jokes at: http://www.short-funny.com/best-knock-jokes.php#ixzz4PnTShwpT"));

        jokes.add(new Joke(false,"I am a bad joke"));
        jokes.add(new Joke(false,"To listen to good jokes, check out the paid version"));
    }

    public Joke getBadJoke(){

        for(int j=badJokeIndex+1;j<jokes.size();j++){
            if(!jokes.get(j).isGood()){
                badJokeIndex = j;
                return jokes.get(j);
            }
        }

        if(badJokeIndex == -1){
            //There is  no bad joke in jokes.
            return null;
        }else{
            badJokeIndex = -1;
            return getBadJoke();
        }
    }

    public Joke getGoodJoke(){

        for(int j=goodJokeIndex+1;j<jokes.size();j++){
            if(jokes.get(j).isGood()){
                goodJokeIndex = j;
                return jokes.get(j);
            }
        }

        if(goodJokeIndex == -1){
            //There is  no good joke in jokes.
            return null;
        }else{
            goodJokeIndex = -1;
            return getGoodJoke();
        }
    }
}