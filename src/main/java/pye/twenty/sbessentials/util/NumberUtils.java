package pye.twenty.sbessentials.util;

import static java.lang.Math.random;

public final class NumberUtils {

    public static int randomInt(int max) {
        int min = 0;
        return (int) (random() * (max - min + 1) + min);
    }

    public static int randomInt(int min, int max) {
        return (int) (random() * (max - min + 1) + min);
    }

}
