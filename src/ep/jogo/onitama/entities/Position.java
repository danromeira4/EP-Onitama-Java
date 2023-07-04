package ep.jogo.onitama.entities;

/** Classe usada para definição de estrutura de posições e movimentos do jogo */
public class Position {
  public static final int RED_ROW = 4;
  public static final int TEMPLE_COL = 2;
  public static final int BLUE_ROW = 0;
  private final int row;
  private final int col;

  /**
   * Construtor que define o valor da Linha e da Coluna da posição, baseado no plano cartesiano]
   *
   * @param row Linha
   * @param col Coluna
   */
  public Position(int row, int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Método que devolve o valor do eixo X da posição
   *
   * @return Um valor int representando o eixo X
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Método que devolve o valor do eixo Y da posição
   *
   * @return Um valor int representando o eixo Y
   */
  public int getCol() {
    return this.col;
  }

  /**
   * Método que verifica se a posição possui uma peça de acordo com a configuração INICIAL do jogo
   *
   * @return Um valor booleano
   */
  public Boolean positionHasAPeace() {
    return this.row == RED_ROW || this.row == BLUE_ROW;
  }

  /**
   * Método que verifica se a posição possui é um templo de acordo configuração do jogo
   *
   * @return Um valor booleano
   */
  public Boolean positionHasATemple() {
    return this.positionHasAPeace() && this.col == TEMPLE_COL;
  }

  /**
   * Método que retorna a cor da peça presente na posição, de acordo com a configuração INICIAL do
   * jogo
   *
   * @return Um valor booleano
   */
  public Color getPieceColor() {
    return (this.row == BLUE_ROW) ? Color.BLUE : (this.row == RED_ROW) ? Color.RED : Color.NONE;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Position - Row: ");
    sb.append(this.getRow());
    sb.append(", Column: ");
    sb.append(this.getCol());
    return sb.toString();
  }
}
