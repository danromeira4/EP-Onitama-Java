package ep.jogo.onitama.configs;

import java.util.List;
import ep.jogo.onitama.entities.Card;
import ep.jogo.onitama.entities.CardInformation;
import ep.jogo.onitama.entities.Color;
import ep.jogo.onitama.entities.Position;
import ep.jogo.onitama.utils.NumberUtils;

/**
 * The CardConfigs class contains static methods that return instances of the Card class with
 * predefined configurations for different animal cards used in a game.
 */
public class CardConfigs {
  private static final int GAME_TOTAL_CARDS = 5;

  public static Card[] selectDistinctRandomCards(Card[] deck) {
    Card[] randomCards = new Card[GAME_TOTAL_CARDS];

    List<Integer> randomIntegers =
        NumberUtils.getDistinctRandomNumbers(GAME_TOTAL_CARDS, 0, deck.length - 1);

    for (int i = 0; i < GAME_TOTAL_CARDS; i++) {
      randomCards[i] = deck[randomIntegers.get(i)];
    }

    return randomCards;
  }

  public static Card[] getCards() {
    return new Card[] {
      getTiger(),
      getDragon(),
      getFrog(),
      getRabbit(),
      getCrab(),
      getElephant(),
      getGoose(),
      getRooster()
    };
  }

  public static Card getTiger() {
    return new Card(
        CardInformation.TIGER.getName(),
        Color.BLUE,
        new Position[] {new Position(-2, 0), new Position(1, 0)});
  }

  public static Card getDragon() {
    return new Card(
        CardInformation.DRAGON.getName(),
        Color.RED,
        new Position[] {
          new Position(-1, -2), new Position(-1, 2), new Position(1, -1), new Position(1, 1)
        });
  }

  public static Card getFrog() {
    return new Card(
        CardInformation.FROG.getName(),
        Color.RED,
        new Position[] {new Position(-1, -1), new Position(0, -2), new Position(1, 1)});
  }

  public static Card getRabbit() {
    return new Card(
        CardInformation.RABBIT.getName(),
        Color.BLUE,
        new Position[] {new Position(-1, 1), new Position(0, 2), new Position(1, -1)});
  }

  public static Card getCrab() {
    return new Card(
        CardInformation.CRAB.getName(),
        Color.BLUE,
        new Position[] {new Position(-1, 0), new Position(0, 2), new Position(0, -2)});
  }

  public static Card getElephant() {
    return new Card(
        CardInformation.ELEPHANT.name(),
        Color.RED,
        new Position[] {
          new Position(-1, -1), new Position(0, -1), new Position(-1, 1), new Position(0, 1)
        });
  }

  public static Card getGoose() {
    return new Card(
        CardInformation.GOOSE.getName(),
        Color.BLUE,
        new Position[] {
          new Position(0, -1), new Position(-1, -1), new Position(0, 1), new Position(1, 1)
        });
  }

  public static Card getRooster() {
    return new Card(
        CardInformation.ROOSTER.getName(),
        Color.RED,
        new Position[] {
          new Position(0, -1), new Position(0, 1), new Position(-1, 1), new Position(1, -1)
        });
  }
}
