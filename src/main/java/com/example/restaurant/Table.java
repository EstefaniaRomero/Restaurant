package com.example.restaurant;

import java.util.UUID;

public class Table {


    private int currentSeatings = 0;
    private String id = UUID.randomUUID().toString();

    public Table() {

    }

    public void addClients(int numOfPeople) throws Exception {
        checkValidNumOfPeople(numOfPeople);
        this.currentSeatings = numOfPeople;
    }

    public String getId() {
        return id;
    }

    private void checkValidNumOfPeople(int numOfPeople) throws Exception {
        if (numOfPeople <= 0) throw new Exception();
    }

    public int getCurrentSeatings() {
        return currentSeatings;
    }

}
