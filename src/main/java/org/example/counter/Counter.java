package org.example.counter;

public class Counter implements Runnable {

    private int count = 0; // 상태값을 줘서 왜 안되는지 알려주기 위해 작성.

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getValue() {
        return count;
    }

    @Override
    public void run() {
        synchronized (this) { // 동기화 처리를 통해 문제 해결
            this.increment();
            System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue()); // 1
            this.decrement();
            System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue()); // 0
        }
    }
}
