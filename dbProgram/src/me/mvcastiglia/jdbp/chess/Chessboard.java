package me.mvcastiglia.jdbp.chess;

import javafx.scene.LightBase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Chessboard extends JPanel {

	static BufferedImage bi_spritesheet;
	static BufferedImage bi_blackRook, bi_blackKnight, bi_blackQueen, bi_blackKing, bi_blackPawn, bi_blackBishop;
	static BufferedImage bi_whiteRook, bi_whiteKnight, bi_whiteQueen, bi_whiteKing, bi_whitePawn, bi_whiteBishop;
	Graphics2D g2d;
	AffineTransform at;

	public Chessboard() {
		this.setBackground(Color.BLACK);
		loadSpritesheet();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		at = new AffineTransform();

		drawText();

		//g2d.drawImage(bi_spritesheet, null, this);
		drawSquares();
		drawDefaultSprites();

		g2d.dispose();
	}
	static void loadSpritesheet() {
		try {
			bi_spritesheet = ImageIO.read(new File("dbProgram/assets/ChessPiecesArray.png"));
		} catch (IOException e) {
			System.out.println("Error: Couldn't load images");
			System.exit(1);
		}

		bi_blackRook = bi_spritesheet.getSubimage(120, 0, 60, 60);
		bi_blackKnight = bi_spritesheet.getSubimage(180, 0, 60, 60);
		bi_blackQueen = bi_spritesheet.getSubimage(0, 0, 60, 60);
		bi_blackKing = bi_spritesheet.getSubimage(60, 0, 60, 60);
		bi_blackBishop = bi_spritesheet.getSubimage(240, 0, 60, 60);
		bi_blackPawn = bi_spritesheet.getSubimage(300, 0, 60, 60);

		bi_whiteRook = bi_spritesheet.getSubimage(120, 60, 60, 60);
		bi_whiteKnight = bi_spritesheet.getSubimage(180, 60, 60, 60);
		bi_whiteQueen = bi_spritesheet.getSubimage(0, 60, 60, 60);
		bi_whiteKing = bi_spritesheet.getSubimage(60, 60, 60, 60);
		bi_whiteBishop = bi_spritesheet.getSubimage(240, 60, 60, 60);
		bi_whitePawn = bi_spritesheet.getSubimage(300, 60, 60, 60);
	}
	void drawText() {
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g2d.drawString("CHESS", 1000, 300);
		g2d.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 15));
		g2d.drawString("Michael Castiglia", 995,330);
		g2d.drawString("a", 70,15);
		g2d.drawString("b", 170,15);
		g2d.drawString("c", 270,15);
		g2d.drawString("d", 370,15);
		g2d.drawString("e", 470,15);
		g2d.drawString("f", 570,15);
		g2d.drawString("g", 670,15);
		g2d.drawString("h", 770,15);

		for(int i = 0; i < 8; i++) {
			g2d.drawString(Integer.toString(i+1), 5, 70+100*i);
		}
	}
	void drawSquares() {
		Color green = new Color(251, 201, 38);
		Color yellow = new Color(0, 86, 22);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 + j % 2 == 1) {
					g2d.setColor(yellow);
				} else {
					g2d.setColor(green);
				}
				g2d.fillRect(100 * i + 20, 100 * j + 20, 100, 100);
			}
		}
	}
	void drawDefaultSprites() {
		at.scale(10.0/6, 10.0/6);
		at.translate(10, 10);
		g2d.drawImage(bi_blackRook, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_blackKnight, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_blackBishop, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_blackQueen, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_blackKing, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_blackBishop, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_blackKnight, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_blackRook, at, this);
		at.translate(0, 60);
		g2d.drawImage(bi_blackPawn, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_blackPawn, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_blackPawn, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_blackPawn, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_blackPawn, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_blackPawn, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_blackPawn, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_blackPawn, at, this);

		at.translate(0, 300);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(60, 0);
		g2d.drawImage(bi_whitePawn, at, this);
		at.translate(0, 60);
		g2d.drawImage(bi_whiteRook, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_whiteKnight, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_whiteBishop, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_whiteQueen, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_whiteKing, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_whiteBishop, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_whiteKnight, at, this);
		at.translate(-60, 0);
		g2d.drawImage(bi_whiteRook, at, this);
	}
}
