package ep.jogo.onitama.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PositionTest {
  @Test
  void GeneratePosition() {
    // Given
    int row = 0, col = 1;

    // When
    Position position = new Position(row, col);

    // Then
    assertEquals(row, position.getRow());
    assertEquals(col, position.getCol());
  }
}
