package me.mvcastiglia.jdbp.chess;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChessDrawFunctions {
	public static void loadSpritesheet() {
		try {
			Chessboard.bi_spritesheet = ImageIO.read(new File("assets/ChessPiecesArray.png"));
		} catch (IOException e) {
			System.out.println("Error: Couldn't load images");
			System.exit(1);
		}

		Chessboard.bi_blackRook = Chessboard.bi_spritesheet.getSubimage(120, 0, 60, 60);
		Chessboard.bi_blackKnight = Chessboard.bi_spritesheet.getSubimage(180, 0, 60, 60);
		Chessboard.bi_blackQueen = Chessboard.bi_spritesheet.getSubimage(0, 0, 60, 60);
		Chessboard.bi_blackKing = Chessboard.bi_spritesheet.getSubimage(60, 0, 60, 60);
		Chessboard.bi_blackBishop = Chessboard.bi_spritesheet.getSubimage(240, 0, 60, 60);
		Chessboard.bi_blackPawn = Chessboard.bi_spritesheet.getSubimage(300, 0, 60, 60);

		Chessboard.bi_whiteRook = Chessboard.bi_spritesheet.getSubimage(120, 60, 60, 60);
		Chessboard.bi_whiteKnight = Chessboard.bi_spritesheet.getSubimage(180, 60, 60, 60);
		Chessboard.bi_whiteQueen = Chessboard.bi_spritesheet.getSubimage(0, 60, 60, 60);
		Chessboard.bi_whiteKing = Chessboard.bi_spritesheet.getSubimage(60, 60, 60, 60);
		Chessboard.bi_whiteBishop = Chessboard.bi_spritesheet.getSubimage(240, 60, 60, 60);
		Chessboard.bi_whitePawn = Chessboard.bi_spritesheet.getSubimage(300, 60, 60, 60);
	}


}
