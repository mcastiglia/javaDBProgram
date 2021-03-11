package me.mvcastiglia.jdbp.misc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Homework0309 {
    @SuppressWarnings("serial")
    public static class ChessBoard extends JPanel
    {
        //Panel attributes.
        private final int P_WIDTH = 1200, P_HEIGHT = 1000;

        //Images
        private BufferedImage 	bi_spritesheet;
        private BufferedImage bi_blackRook, bi_blackKnight, bi_blackQueen, bi_blackKing, bi_blackPawn, bi_blackBishop;
        private BufferedImage bi_whiteRook, bi_whiteKnight, bi_whiteQueen, bi_whiteKing, bi_whitePawn, bi_whiteBishop;

        //Constructor
        public ChessBoard()
        {
            //Set panel attributes.
            setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
            setBackground(Color.BLACK);

            //Load sprites.
            try
            {
                bi_spritesheet = ImageIO.read(new File("dbProgram/assets/ChessPiecesArray.png"));
            }
            catch (IOException ioe)
            {
                System.out.println("Couldn't load sprites.");
                System.exit(0);
            }

            bi_blackRook = bi_spritesheet.getSubimage(120, 0, 60, 60);
            bi_blackKnight = bi_spritesheet.getSubimage(180, 0, 60, 60);

            /*
             * 1) 	Using bi_blackRook and bi_blackKnight as guides, declare and assign values for BufferedImages for the other 10 chess pieces.
             * 		Open ChessPiecesArray.png to see the locations of each piece.
             *
             * 		Each piece is a 60x60 image, and from left to right are the Queen, King, Rook, Knight, Bishop, and Pawn.
             * 		The black pieces are on the top row, and the white pieces are on the bottom row.
             *
             * 		For example, the black queen would be a 60x60 subimage starting at (0,0),
             * 		and the white knight would be a 60x60 subimage starting at (180,60).
             */
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

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            //Write the title on the screen.
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font(g2d.getFont().getFontName(),Font.BOLD, 30));
            g2d.drawString("CHESS",1000,300);

            /*
             * 2)	Using the code above which writes CHESS on the screen as a guide, write more text on the screen as well.
             *
             * 		Set the font to a size of about 15-20 point, and write your name under the word CHESS.
             *
             * 		Then, write the letters a b c d e f g h above the top row of the chessboard.
             * 		Write the numbers 8 7 6 5 4 3 2 1 to the left of the leftmost column of the chessboard.
             */
            g2d.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 15));
            g2d.drawString("Michael Castiglia", 995,330);
            g2d.drawString("a                  b                  c                  d                  e                  f                  g                  h", 70,15);
            for(int i = 0; i < 8; i++) {
                g2d.drawString(Integer.toString(i+1), 5, 70+100*i);
            }

            /*
             * 3)	Using the two rectangles above as a guide, draw all 64 squares of the chessboard onto the screen.
             *
             * 		Use nested for loops to draw an 8x8 grid of squares. You may erase the two guide squares in order to draw the full grid.
             * 		HINT: You can easily alter the colors by adding the values of the for loop variables.
             */

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


            //Draw the pieces onto the screen.
            AffineTransform at = new AffineTransform();
            at.scale(10.0/6, 10.0/6);
            at.translate(10, 10);
            g2d.drawImage(bi_blackRook, at, this);
            at.translate(60, 0);
            g2d.drawImage(bi_blackKnight, at, this);

            /*
             * 4)	Using the rook and knight as a guide, draw the other chess pieces in their proper positions.
             * 		Use the Internet if you're not sure where each chess piece goes.
             *
             * 		Using the initial scale and translate, you can translate 60 pixels at a time to move to an adjacent square.
             */

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

            g2d.dispose();
        }
    }


    public static void main(String[] args)
    {
        JFrame jf_main = new JFrame("Suncoast Chess");
        jf_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add panel to frame.
        jf_main.getContentPane().add(new ChessBoard());

        //Pack and set visible.
        jf_main.pack();
        jf_main.setResizable(false);
        jf_main.setVisible(true);
    }
}
