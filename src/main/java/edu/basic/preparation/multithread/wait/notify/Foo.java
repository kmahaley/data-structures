package edu.basic.preparation.multithread.wait.notify;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.Random;

/**
 * TODO : add description
 */
public class Foo {

    public Random r;
    Object lock= new Object();
    boolean  flag = false;

    public Foo() {
        try {
            r = new Random();

        } catch(Exception e) {}}

    public void first() {

        try {
            synchronized(lock){
                Thread.sleep(1);
                System.out.println("first");
                flag = true;
                lock.notifyAll();
            }

        } catch(Exception e) {}}

    public void second() {
        try {
            synchronized(lock){
                lock.wait();
                while(flag)

                Thread.sleep(1);
                System.out.println("second");
            }
        }

     catch(Exception e) {}}

    public void third() {
        try {
            synchronized(lock){
                lock.wait();
                while(flag){
                    Thread.sleep(1);
                    System.out.println("third");
                }  }

        } catch(Exception e) {}}

// Implement Foo to guarantee that in a system with multiple threads where thread A calls first(), thread B calls second() and thread // C calls third() that the methods are guaranteed to execute in order for example we might have a main like this:

    public static void main(String[] args) {
        final Foo f = new Foo();

        Thread A = new Thread(new Runnable() {
            public void run() {
                f.first();
            }
        });

        Thread B = new Thread(new Runnable() {
            public void run() {
                f.second();
            }
        });

        Thread C = new Thread(new Runnable() {
            public void run() {
                f.third();
            }
        });

        B.start();
        A.start();
        C.start();
    }
}