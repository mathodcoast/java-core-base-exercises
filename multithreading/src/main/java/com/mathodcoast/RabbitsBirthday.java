package com.mathodcoast;

public class RabbitsBirthday {
    public static void main(String[] args) {
        int rabbit = 1;
        goRabbits(rabbit);
    }
    public static void goRabbits(int rabbit){
        if (rabbit > 100) return;
        for (int i = 0; i < 1; i++) {

            new Thread(() -> {
                System.out.println("Rabbit" + rabbit);
                goRabbits(rabbit + 1);
            }).start();
        }
    }
}
