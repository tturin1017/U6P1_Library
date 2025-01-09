package com.example.project;

public class IdGenerate{
    private String currentId=100; //id should start at 99

    public IdGenerate(){}

    public String getCurrentId(){
        return currentId;
    }

    public void generateID(){
        int x = Integer.parseInt(currentId)+1;
        currentId = String(x);
       
    }
}