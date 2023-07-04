package ep.jogo.onitama.game;

import java.util.Objects;
import ep.jogo.onitama.configs.CardConfigs;
import ep.jogo.onitama.entities.Card;
import ep.jogo.onitama.entities.Color;
import ep.jogo.onitama.entities.Piece;
import ep.jogo.onitama.entities.Position;
import ep.jogo.onitama.exceptions.IllegalMovementException;
import ep.jogo.onitama.exceptions.IncorrectTurnOrderException;
import ep.jogo.onitama.exceptions.InvalidCardException;
import ep.jogo.onitama.exceptions.InvalidPieceException;

public class ImpGame implements Game {

    // Constantes
    private static final String INVALID_PIECE = "Não há nenhuma peça válida nessa posição";
    private static final String INCORRECT_TURN_MSG = "O jogador só poderá movimentar suas peças no seu respectivo turno";
    private static final String ILLEGAL_MOVEMENT_MSG = "Não é possível mover a peça para essa nova posição.";
    private static final int DIMENSIONS_BOARD = 5;

    // Atributos
    private Player redPlayer;
    private Player bluePlayer;
    private Card tableCard;
    private Spot[][] board;
    private Color nextTurn;
    private Card[] gameCards;

    // Construtores
    public ImpGame() {}

    public ImpGame(Player redPlayer, Player bluePlayer) {
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
    }

    public ImpGame(Player redPlayer, Player bluePlayer, Card[] cardList) {
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        this.gameCards = CardConfigs.selectDistinctRandomCards(cardList);
        this.tableCard = this.gameCards[0];
        this.nextTurn = this.tableCard.getColor();
    }

    // Métodos da interface Game
    @Override
    public Color getSpotColor(Position position) {
        return this.getSpotByPosition(position).getColor();
    }

    @Override
    public Piece getPiece(Position position) {
        return Objects.nonNull(this.getSpotByPosition(position)) ? this.getSpotByPosition(position).getPiece() : null;
    }

    @Override
    public Card getTableCard() {
        return this.tableCard;
    }

    @Override
    public Player getRedPlayer() {
        return this.redPlayer;
    }

    @Override
    public Player getBluePlayer() {
        return this.bluePlayer;
    }

    @Override
    public void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {
        Player actualPlayer = this.nextTurn == Color.RED ? this.redPlayer : this.bluePlayer;
        actualPlayer.findCard(card);

        Spot currentSpot = this.getSpotByPosition(currentPos);
        Piece piece = this.getPiece(currentPos);

        if (Objects.isNull(piece)) {
            throw new InvalidPieceException(INVALID_PIECE);
        }

        if (!actualPlayer.getPieceColor().equals(piece.getColor())) {
            throw new IncorrectTurnOrderException(INCORRECT_TURN_MSG);
        }

        int newRow = currentPos.getRow() + cardMove.getRow();
        int newCol = currentPos.getCol() + cardMove.getCol();
        Spot newSpot = this.getSpotByPosition(newRow, newCol);

        boolean newSpotIsValid = Objects.nonNull(newSpot) && Objects.nonNull(newSpot.getPiece()) && (newSpot.getPiece().getColor() != actualPlayer.getPieceColor());

        if (!this.coordinatesAreValid(newRow, newCol) || !newSpotIsValid) {
            throw new IllegalMovementException(ILLEGAL_MOVEMENT_MSG);
        }

        newSpot.occupySpot(piece);
        currentSpot.clearSpot();
        actualPlayer.swapCard(card, this.tableCard);

        this.tableCard = card;
        this.nextTurn = this.nextTurn == Color.RED ? Color.BLUE : Color.RED;
    }

    @Override
    public boolean checkVictory(Color color) {
        Color looserColor = color == Color.RED ? Color.BLUE : Color.RED;
        int looserRow = looserColor == Color.RED ? Position.RED_ROW : Position.BLUE_ROW;

        Piece possibleWinner = this.board[looserRow][Position.TEMPLE_COL].getPiece();
        if (possibleWinner.getColor() == color && possibleWinner.isMaster()) {
            return true;
        }

        Piece possibleLooserMaster = this.findMasterByColor(looserColor);

        // Caso o mestre da cor perdedora não for encontrado, vitória da cor `color`
        return Objects.isNull(possibleLooserMaster);
    }

    @Override
    public void printBoard() {
    }

    // Métodos auxiliares
    private void initBoard() {
        this.board = new Spot[this.DIMENSIONS_BOARD][this.DIMENSIONS_BOARD];

        for (int row = 0; row < this.DIMENSIONS_BOARD; row++) {
            for (int col = 0; col < this.DIMENSIONS_BOARD; col++) {
                this.board[row][col] = this.initSpotBasedOnPosition(row, col);
            }
        }
    }

    private Spot initSpotBasedOnPosition(int row, int col) {
        Position position = new Position(row, col);
        Piece piece;

        if (position.positionHasATemple()) {
            piece = new Piece(position.getPieceColor(), Boolean.TRUE);
            return new Spot(piece, position, piece.getColor());
        }

        if (position.positionHasAPeace()) {
            piece = new Piece(position.getPieceColor(), Boolean.FALSE);
            return new Spot(piece, position, Color.NONE);
        }

        return new Spot(null, position, Color.NONE);
    }

    private Spot getSpotByPosition(Position position) {
        return this.getSpotByPosition(position.getRow(), position.getCol());
    }

    private Spot getSpotByPosition(int row, int col) {
        if (!this.coordinatesAreValid(row, col)) {
            return null;
        }
        return this.board[row][col];
    }

    private Piece findMasterByColor(Color color) {
        Piece piece;

        for (int row = 0; row < DIMENSIONS_BOARD; row++) {
            for (int col = 0; col < DIMENSIONS_BOARD; col++) {
                piece = this.board[row][col].getPiece();

                if (piece.getColor() == color && piece.isMaster()) {
                    return piece;
                }
            }
        }

        return null;
    }

    private boolean coordinatesAreValid(int row, int col) {
        return (row >= 0 && row < DIMENSIONS_BOARD) && (col >= 0 && col < DIMENSIONS_BOARD);
    }

    public Card[] getGameCards() {
        return this.gameCards;
    }
}