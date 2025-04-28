package com.example.oop;

import android.util.Log;

abstract public class KittyCat extends Animals{
    private int age;
    String name;
    String helloKitty, hello;
    KittyMood kittyMood;

    final static int numberofLegs = 4;
    static int count = 0;

    static class CountResetter{
        boolean moreThan5;

        CountResetter(){
            if (KittyCat.count > 5){
                moreThan5 = true;
            }
            if (moreThan5){
                resetCount(0);
            }
        }
        void resetCount(int value){
            KittyCat.count = value;
        }
    }
    class KittyMood {
        int levelOfKittyMood;

        KittyMood(){
            if (KittyCat.this.age < 2){
                levelOfKittyMood = 100;
            } else if (KittyCat.this.age >= 2 && KittyCat.this.age < 7){
                levelOfKittyMood = 50;
            } else if (KittyCat.this.age >= 7){
                levelOfKittyMood = 20;
            }
        }

    }

    public KittyCat(){
        count++;
        this.name = "Meowme King";
        this.age = -1;

        kittyMood = new KittyMood();

        switch (kittyMood.levelOfKittyMood){
            case 100:
                helloKitty = "Meow! I'm Youg Kitty and I'm Happy Yahoo!!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 50:
                helloKitty = "Meow! I'm adult Cat >:{} and I'm Storng!!! Bitch!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 20:
                helloKitty = "Meow! I'm old and seek Cat!!! :=( And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
        }
    }

    public KittyCat(int age, String name){
        count++;
        this.age = age;
        this.name = name;

        kittyMood = new KittyMood();

        switch (kittyMood.levelOfKittyMood){
            case 100:
                helloKitty = "Meow! I'm Youg Kitty and I'm Happy Yahoo!!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 50:
                helloKitty = "Meow! I'm adult Cat >:{} and I'm Storng!!! Bitch!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 20:
                helloKitty = "Meow! I'm old and seek Cat!!! :=( And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
        }
    }

    public KittyCat(int age){
        count++;
        age++;
        this.age = age;
        this.name = "Tomerlando";

        kittyMood = new KittyMood();

        switch (kittyMood.levelOfKittyMood){
            case 100:
                helloKitty = "Meow! I'm Youg Kitty and I'm Happy Yahoo!!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 50:
                helloKitty = "Meow! I'm adult Cat >:{} and I'm Storng!!! Bitch!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 20:
                helloKitty = "Meow! I'm old and seek Cat!!! :=( And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
        }
    }
    public KittyCat(String name){
        count++;


        this.hello = "Hello MotherFUcker";
        this.age = 3;
        this.name = name;
        kittyMood = new KittyMood();

        switch (kittyMood.levelOfKittyMood){
            case 100:
                helloKitty = "Meow! I'm Youg Kitty and I'm Happy Yahoo!!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 50:
                helloKitty = "Meow! I'm adult Cat >:{} and I'm Storng!!! Bitch!! And my name's " + name +
                        ", and I'm " + age +" years old.";
                break;
            case 20:
                helloKitty = "Meow! I'm old and seek Cat!!! :=( And my name's " + name +
                        ", and I'm " + age +" years old." + this.hello;
                break;
        }
    }
    public void catchMouse(int mouseWeight){
        class Mouse{

            String color;
            int weight;

            public Mouse(String color, int weight){

                this.color = color;
                this.weight = weight;
            }
            String mouseVoice(){
                return "Pi-pi-pi";
            }
        }
        Mouse mouse = new Mouse("White", mouseWeight);

        if (mouse.weight < 2){
            Log.i("cat say", "I will eat you " + mouse.mouseVoice());
        } else {
            Log.i("cat say","I afraid you");
        }
    }

    public void roar(){
        Log.i("roar()", helloKitty);
    }

    public void roar( int age, String name){
        Log.i("roar()", helloKitty);
    }

    public void roar(int age){
        Log.i("roar()", helloKitty);
    }

    public void roar(String name){
        Log.i("roar()", helloKitty);
    }
}
