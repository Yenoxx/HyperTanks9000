package com.yenoxx.ht9k;

public abstract class Utils {
    public static int sign(float num) {
        if (num > 0) return 1;
        else if (num < 0) return -1;
        else return 0;
    }

    public static void log(String string) {
        System.out.println(string);
    }
}
