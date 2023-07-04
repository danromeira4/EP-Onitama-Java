package ep.jogo.onitama.utils;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class NumberUtils {
  /**
   * The function returns a random integer between a minimum and maximum value.
   *
   * @param min The minimum value that the random number can be.
   * @param max The maximum value that the random number can take.
   * @return The method is returning a random integer between the minimum and maximum values
   *     (inclusive) specified as parameters.
   */
  public static int getRandom(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  /**
   * This Java function generates a list of n distinct random integers within a given range.
   *
   * @param n The number of distinct random numbers to generate.
   * @param min The minimum value that the random numbers can take.
   * @param max The "max" parameter represents the maximum value that the randomly generated numbers
   *     can have.
   * @return The method is returning a list of n distinct random integers between the values of min
   *     and max (inclusive).
   */
  public static List<Integer> getDistinctRandomNumbers(int n, int min, int max) {
    List<Integer> integerList = new ArrayList<>();
    int randomNumber;

    while (integerList.size() != n) {
      randomNumber = getRandom(min, max);

      if (!integerList.contains(randomNumber)) {
        integerList.add(randomNumber);
      }
    }

    return integerList;
  }
}
