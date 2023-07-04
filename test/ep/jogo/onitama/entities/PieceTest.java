package ep.jogo.onitama.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PieceTest {
  @Test
  void GeneratePiece() {
    // When
    Piece piece = new Piece(Color.BLUE, Boolean.TRUE);

    // Then
    assertEquals(Boolean.TRUE, piece.isMaster());
    assertEquals(Color.BLUE, piece.getColor());
  }
}
