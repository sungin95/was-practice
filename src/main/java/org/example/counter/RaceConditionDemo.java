package org.example.counter;

public class RaceConditionDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        //
        /**
         * 싱글톤에서 상태를 유지하게 관리하면 문제가 생긴다.
         * 멀티 쓰레드 환경에서 하나의 싱글톤을 공유하면 문제가 생긴다.
         *
         * Value for Thread After increment Thread-2 2
         * Value for Thread After increment Thread-1 1
         * Value for Thread After increment Thread-3 3
         * Value for Thread at last Thread-2 2
         * Value for Thread at last Thread-1 1
         * Value for Thread at last Thread-3 0
         */
    }
}
