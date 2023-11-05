package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
		 		UI.printMatch(chessMatch, captured);
		 		System.out.println();
		 		System.out.println("Source: ");
		 		ChessPosition source = UI.readChessPotion(sc);
		 		
		 		boolean[][] possibleMoves = chessMatch.possibleMoves(source);
		 		UI.clearScreen();
		 		UI.printBoard(chessMatch.GetPieces(), possibleMoves);
		 		
		 		
		 		System.out.println("Target: ");
		 		ChessPosition target = UI.readChessPotion(sc);
		 		
		 		ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		 		
		 		if (capturedPiece != null) {
		 			captured.add(capturedPiece);
		 		}
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			}
			UI.clearScreen();
			UI.printMatch(chessMatch, captured);
	}

}