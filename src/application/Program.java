package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
	 		UI.printBoard(chessMatch.GetPieces());
	 		System.out.println();
	 		System.out.println("Source: ");
	 		ChessPosition source = UI.readChessPotion(sc);
	 		
	 		System.out.println("Target: ");
	 		ChessPosition target = UI.readChessPotion(sc);
	 		
	 		ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
	 		System.out.println(capturedPiece);
		}
				
	}

}
