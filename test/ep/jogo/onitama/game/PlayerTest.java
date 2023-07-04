package ep.jogo.onitama.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import ep.jogo.onitama.configs.CardConfigs;
import ep.jogo.onitama.entities.Card;
import ep.jogo.onitama.entities.Color;
import ep.jogo.onitama.exceptions.InvalidCardException;

public class PlayerTest {
  private static final Card[] cards = CardConfigs.getCards();

  @Test
  void TwoCardsPlayer() {
    // Given
    String playerName = "Danilo";

    // When
    Player player = new Player(playerName, Color.BLUE, cards[0], cards[1]);

    // Then
    assertEquals(playerName, player.getName());
    assertEquals(Color.BLUE, player.getPieceColor());
    assertEquals(cards[0], player.getCards()[0]);
  }

  @Test
  void CardListPlayer() {
    // Given
    String playerName = "Danilo";

    // When
    Player player = new Player(playerName, Color.BLUE, cards);

    // Then
    assertEquals(playerName, player.getName());
    assertEquals(Color.BLUE, player.getPieceColor());
    assertEquals(cards, player.getCards());
  }

  @Test
  void SwapCardsSuccess() {
    // Given
    Card oldCard = cards[0];
    Card newCard = cards[2];
    Player player = new Player("Danilo", Color.BLUE, oldCard, cards[1]);

    // When
    player.swapCard(oldCard, newCard);

    // Then
    assertEquals(newCard, player.getCards()[0]);
  }

  @Test
  void SwapCardsInvalidCardException() {
    // Given
    Card nonexistentCard = cards[4];
    Card newCard = cards[2];
    Player player = new Player("Danilo", Color.BLUE, cards[0], cards[1]);

    // When - Then
    assertThrows(InvalidCardException.class, () -> player.swapCard(nonexistentCard, newCard));
  }
}
