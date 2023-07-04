package ep.jogo.onitama.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ep.jogo.onitama.configs.CardConfigs;
import ep.jogo.onitama.entities.Color;

public class ImpGameTest {
  @Test
  void InitiateGame() {
    // Given
    Player player1 = new Player("Danilo", Color.RED, null);
    Player player2 = new Player("Otavio", Color.BLUE, null);

    // When
    Game game = new ImpGame(player1, player2);

    // Then
    assertEquals(player1, game.getRedPlayer());
    assertEquals(player2, game.getBluePlayer());
  }

  @Test
  void InitiateGameWithCards() {
    // Given
    Player player1 = new Player("Danilo", Color.RED, null);
    Player player2 = new Player("Otavio", Color.BLUE, null);

    // When
    ImpGame game = new ImpGame(player1, player2, CardConfigs.getCards());

    // Then
    assertEquals(player1, game.getRedPlayer());
    assertEquals(player2, game.getBluePlayer());
    assertEquals(5, game.getGameCards().length);
  }
}
