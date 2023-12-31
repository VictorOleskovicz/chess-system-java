package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}
	
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

	    Position p = new Position(0, 0);
	    Position p2 = new Position(0, 0);
	    
	    //two steps on first move FOR WHITE
	    if(getColor() == Color.WHITE) {
	    p.setValues(position.getRow() - 2, position.getColumn());
	    p2.setValues(position.getRow() - 1, position.getColumn());
	    if (getBoard().positionExists(p) 
	    		&& !getBoard().thereIsAPiece(p) 
	    		&& !getBoard().thereIsAPiece(p2)
	    		&& getMoveCount() == 0) {
	    	mat[p.getRow()][p.getColumn()] = true;
	    } 
	    // pawn regular move
	    p.setValues(position.getRow() - 1, position.getColumn());
	    if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	    	mat[p.getRow()][p.getColumn()] = true;
	    }
	    
	    //pawn capture moves
	    
	    p.setValues(position.getRow() - 1, position.getColumn() - 1);
	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	    	mat[p.getRow()][p.getColumn()] = true;
	    }
	    
	    p.setValues(position.getRow() - 1, position.getColumn() + 1);
	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	    	mat[p.getRow()][p.getColumn()] = true;
	    }
	    }
	    
	    //for black pawn
	    if(getColor() == Color.BLACK) {
		    p.setValues(position.getRow() + 2, position.getColumn());
		    p2.setValues(position.getRow() + 1, position.getColumn());
		    if (getBoard().positionExists(p) 
		    		&& !getBoard().thereIsAPiece(p) 
		    		&& !getBoard().thereIsAPiece(p2)
		    		&& getMoveCount() == 0) {
		    	mat[p.getRow()][p.getColumn()] = true;
		    } 
		    // pawn regular move
		    p.setValues(position.getRow() + 1, position.getColumn());
		    if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		    	mat[p.getRow()][p.getColumn()] = true;
		    }
		    
		    //pawn capture moves
		    
		    p.setValues(position.getRow() + 1, position.getColumn() + 1);
		    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
		    	mat[p.getRow()][p.getColumn()] = true;
		    }
		    
		    p.setValues(position.getRow() + 1, position.getColumn() - 1);
		    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
		    	mat[p.getRow()][p.getColumn()] = true;
		    }
	    
	    }
		
		return mat;
	}
	
	
	

}
