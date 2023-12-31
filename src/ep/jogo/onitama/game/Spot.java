package ep.jogo.onitama.game;

import ep.jogo.onitama.entities.Color;
import ep.jogo.onitama.entities.Piece;
import ep.jogo.onitama.entities.Position;
import ep.jogo.onitama.exceptions.IllegalMovementException;

/** Classe contendo ações e informações sobre cada espaço (quadrado) no tabuleiro */
public class Spot {
  private static final String SPACE_OCCUPIED =
      "Espaço está ocupado por uma peça da mesma cor";
  private Piece piece;
  private Position position;
  private Color color;

  /**
   * Construtor para espaços com peça e com cor
   *
   * @param piece Peça que inicia nesse espaço do tabuleiro
   * @param pos Posição do espaço no tabuleiro
   * @param color Cor do espaço no tabuleiro (Templo)
   */
  public Spot(Piece piece, Position pos, Color color) {
    this.piece = piece;
    this.position = pos;
    this.color = color;
  }

  /**
   * Construtor para espaços com peça e sem cor
   *
   * @param piece Peça que inicia nesse espaço do tabuleiro
   * @param pos Posição do espaço no tabuleiro
   */
  public Spot(Piece piece, Position pos) {
    this.piece = piece;
    this.position = pos;
  }

  /**
   * Construtor para espaços sem peça e sem cor
   *
   * @param pos Posição do espaço no tabuleiro
   */
  public Spot(Position pos) {
    this.position = pos;
  }

  /**
   * Método que devolve a posição (coordenadas) do espaço
   *
   * @return Objeto Position contendo a posição (coordenadas) do espaço
   */
  public Position getPosition() {
    return this.position;
  }

  /**
   * Método que devolve a peça contida neste espaço
   *
   * @return Objeto Piece caso tenha uma peça ou null caso o espaço esteja vazio
   */
  public Piece getPiece() {
    return this.piece;
  }

  /**
   * Método que devolve a cor do espaço
   *
   * @return Enum Color com a cor do espaço. Caso o espaço não tenha cor, o valor do enum será NONE
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Método que ocupa o espaço atual com a peça passada
   *
   * @param piece A peça para ocupar este espaço
   * @exception IllegalMovementException Caso o espaço já esteja ocupado por uma peça da mesma cor
   */
  protected void occupySpot(Piece piece) throws IllegalMovementException {
    if (sameColorPiece(this.getPiece(), piece)) {
      throw new IllegalMovementException(SPACE_OCCUPIED);
    }

    this.piece = piece;
  }

  /** Método que "libera" o espaço atual, ou seja, deixa-o vazio */
  protected void clearSpot() {
    this.piece = null;
  }

  private boolean sameColorPiece(Piece piece1, Piece piece2) {
  return piece1 != null
      && piece1.getColor() != null
      && piece2 != null
      && piece2.getColor() != null
      && piece1.getColor().equals(piece2.getColor());
}
}
