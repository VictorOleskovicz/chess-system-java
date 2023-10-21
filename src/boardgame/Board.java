package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board, must be at least 1 row and column long");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	
	
	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is a piece in this positon " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
//verificaçao se a posicao existe, funcao de base que receberá posições
	
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

//funçao principal que receberá a linha e coluna da anterior
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	// ver se há uma peça na position
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position does not exist on board");
		}
		return piece(position) != null;
	}
	
	

}
