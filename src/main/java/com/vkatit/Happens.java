package com.vkatit;

public class Happens {

    public int z;
    public int y;
    public volatile int x;

    public static void main(String[] args) {
        while (true){
            Happens main = new Happens();

            Thread first = new Thread(new Runnable() {
                @Override
                public void run() {
                    main.z = 1;
                    main.y = 1;
                    main.x = 1;
                }
            });
            Thread second = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        if(main.x == 1) System.out.println(main.y);
                    }
                }
            });

            second.start();
            first.start();
        }




    }
}
