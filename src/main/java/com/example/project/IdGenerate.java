package com.example.project;

public class IdGenerate{
    private static String currentId="99"; //id should start at 99

    public IdGenerate(){}

    public static String getCurrentId(){
        return currentId;
    }

    public static void reset(){
        currentId = "99";
    }

    public static void generateID(){
        int x = Integer.parseInt(currentId)+1;
        currentId = Integer.toString(x);
       
    }
}