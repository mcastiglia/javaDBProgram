package me.mvcastiglia.jdbp.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import me.mvcastiglia.jdbp.chess.*;

public class ChessInit {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Chess Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Chessboard());
		
		frame.setSize(1200,900);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
