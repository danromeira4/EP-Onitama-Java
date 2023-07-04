package ep.jogo.onitama.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import ep.jogo.onitama.entities.Color;
import ep.jogo.onitama.entities.Piece;
import ep.jogo.onitama.entities.Position;
import ep.jogo.onitama.exceptions.IllegalMovementException;

public class SpotTest {
  @Test
  void GenerateSpot() {
    // Given
    Position position = new Position(0, 0);

    // When
    Spot spot = new Spot(position);

    // Then
    assertEquals(position, spot.getPosition());
  }

  @Test
  void GenerateSpotAndPiece() {
    // Given
    Position position = new Position(0, 0);
    Piece piece = new Piece(Color.BLUE, Boolean.TRUE);

    // When
    Spot spot = new Spot(piece, position);

    // Then
    assertEquals(position, spot.getPosition());
    assertEquals(piece, spot.getPiece());
  }

  @Test
  void GenerateSpotEverything() {
    // Given
    Position position = new Position(0, 0);
    Piece piece = new Piece(Color.RED, Boolean.TRUE);

    // When
    Spot spot = new Spot(piece, position, Color.RED);

    // Then
    assertEquals(position, spot.getPosition());
    assertEquals(piece, spot.getPiece());
    assertEquals(Color.RED, spot.getColor());
  }

  @Test
  void ClearSpot() {
    // Given
    Position position = new Position(0, 0);
    Spot spot = new Spot(position);

    // When
    spot.clearSpot();

    // Then
    assertNull(spot.getPiece());
  }

  @Test
  void FillSpotSuccess() {
    // Given
    Position position = new Position(0, 0);
    Piece oldPiece = new Piece(Color.RED, Boolean.TRUE);
    Piece newPiece = new Piece(Color.BLUE, Boolean.TRUE);
    Spot spot = new Spot(oldPiece, position);

    // When
    spot.occupySpot(newPiece);

    // Then
    assertEquals(newPiece, spot.getPiece());
  }

  @Test
  void FillSpotException() {
    // Given
    Position position = new Position(0, 0);
    Piece oldPiece = new Piece(Color.BLUE, Boolean.TRUE);
    Piece newPiece = new Piece(Color.BLUE, Boolean.FALSE);
    Spot spot = new Spot(oldPiece, position);

    // When - Then
    assertThrows(IllegalMovementException.class, () -> spot.occupySpot(newPiece));
  }
}
