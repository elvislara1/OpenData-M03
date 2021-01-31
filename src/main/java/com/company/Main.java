package com.company;

public class Main {

    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV();
        Menu menu = new Menu();
        //CSVTOBEAN ->
        menu.consultas(readCSV.parse());
    }
}
