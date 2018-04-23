/*
 * Copyright (C) 2018 Ryan Castelli
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package RandomNum;

/**
 * To generate a random number Uses LCG (Linear Congruential Generator) method
 * of generation
 *
 * @author NTropy
 * @version 1.0
 */
public class RandomNum {

    private static long systemTime;
    private static int max;
    private static int seed;

    /**
     * Constructor for RandomNum object, specifies max value to be returned
     *
     * @param n
     */
    public RandomNum(int n) {
        max = n;
    }

    /**
     * Generates random number based on seed and system time
     *
     * @return positive random number
     */
    public static int nextInt() {
        systemTime = System.nanoTime();

        seed = (((int) (systemTime % max)) * 2038074743 + 3) % 2038074743; //uses large prime number to give range

        seed = next(Math.abs(seed));

        if (seed % max < 0)
        {
            return -1 * (seed % max);
        } else {
            return seed % max;
        }
    }

    /**
     * Shifts seed to generate new random int
     *
     * @param bits
     * @return new seed
     */
    private static int next(int bits) {
        for (int j = 0; j < bits % max; j++) {
            bits *= 2;
        }
        return bits;
    }
}
