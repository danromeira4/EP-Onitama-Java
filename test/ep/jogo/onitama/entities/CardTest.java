package ep.jogo.onitama.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CardTest {
  @Test
  void GenerateCard() {
    // Given
    String cardName = "tiger";
    Position[] positionList = new Position[1];

    // When
    Card card = new Card(cardName, Color.BLUE, new Position[1]);

    // Then
    assertEquals(positionList.length, card.getPositions().length);
    assertEquals(cardName, card.getName());
    assertEquals(Color.BLUE, card.getColor());
  }

  @Test
  void GenerateAllCards() {
    // When
    Card[] cards = Card.createCards();

    // Then
    assertEquals(5, cards.length);
  }
}
