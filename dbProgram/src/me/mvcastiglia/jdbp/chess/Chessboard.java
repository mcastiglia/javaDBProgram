package me.mvcastiglia.jdbp.chess;

import javafx.scene.LightBase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	public Chessboard() {
		this.setBackground(Color.BLACK);
		ChessDrawFunctions.loadSpritesheet();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g2d.drawString("CHESS", 1000, 300);
		g2d.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 15));
		g2d.drawString("Michael Castiglia", 995,330);
		g2d.drawString("a                  b                  c                  d                  e                  f                  g                  h", 70,15);
		for(int i = 0; i < 8; i++) {
			g2d.drawString(Integer.toString(i+1), 5, 70+100*i);
		}

		g2d.drawImage(bi_spritesheet, null, this);

		// Draw Green Rectangles
		g2d.setColor(new Color(0, 86, 22));
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 + j % 2 == 1) {
					g2d.fillRect(100 * i + 20, 100 * j + 20, 100, 100);
				}
			}
		}

		// Draw Gold Rectangles
		g2d.setColor(new Color(251, 201, 38));
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!(i % 2 + j % 2 == 1)) {
					g2d.fillRect(100 * i + 20, 100 * j + 20, 100, 100);
				}
			}
		}

		g2d.dispose();
	}
}
