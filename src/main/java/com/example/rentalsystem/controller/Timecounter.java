package com.example.rentalsystem.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Timecounter implements Runnable{
    private Thread thread;

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            if(counter == 100)
                counter = 1;
            else
                counter = counter + 1;
            System.out.format("counter = %d\n", counter);
        }
    }
    public void start(){
        thread = new Thread(this);
        thread.start();
    }
}
