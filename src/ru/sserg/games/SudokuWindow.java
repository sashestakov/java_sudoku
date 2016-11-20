package ru.sserg.games;
//import ru.sserg.games.SudokuGrid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ssa on 20.11.2016.
 */

public class SudokuWindow extends JFrame{

    private static final int gridx=10;
    private static final int gridy=10;
    private static final int gridxsize=360;
    private static final int gridysize=360;

    private static final int gridstep=40;
    private static final int digitstep=15;

    private static final int windowwidth=500;
    private static final int windowheight=500;

    private static Graphics graphics;


    // TODO: 20.11.2016 Добавить процедуру перерисовки окна
    private static class GameField extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }

    private static Graphics drawGrid(Graphics g){
        g.clearRect(0,0,windowwidth,windowheight);
        g.setColor(Color.black);
        g.drawRect(gridx,gridy,gridxsize,gridysize);
        g.drawRect(gridx-1,gridy-1,gridxsize+2,gridysize+2);
        g.drawRect(gridx-2,gridy-2,gridxsize+4,gridysize+4);

        for (int i=1;i<9;i++) {
            g.drawLine(gridx, gridy +(gridstep* i), gridx+gridxsize, gridy +(gridstep* i));
            g.drawLine(gridx+(gridstep* i), gridy, gridx+(gridstep* i), gridy+gridysize);

            if ((i%3)==0){
                g.drawLine(gridx, gridy +(gridstep* i)-1, gridx+gridxsize, gridy +(gridstep* i)-1);
                g.drawLine(gridx, gridy +(gridstep* i)+1, gridx+gridxsize, gridy +(gridstep* i)+1);

                g.drawLine(gridx+(gridstep* i)-1, gridy, gridx+(gridstep* i)-1, gridy+gridysize);
                g.drawLine(gridx+(gridstep* i)+1, gridy, gridx+(gridstep* i)+1, gridy+gridysize);
            }
        }
        return g;
    }

    private static int rowColToYX(int rowcol){
        return (gridy+(rowcol*gridstep));
    }

    public static Graphics drawDigit(Graphics g, int digit, int row, int column, Color color){
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(color);
        g.drawString( Integer.toString(digit),rowColToYX(column)+digitstep,rowColToYX(row+1)-digitstep);
        return g;
    }

    private static Graphics clearCell(Graphics g, int row, int column){
        g.setColor(Color.black);

        g.clearRect(rowColToYX(column),rowColToYX(row),gridstep,gridstep);
   //     g.drawRect(rowColToYX(column),rowColToYX(row),gridstep,gridstep);
        return g;
    }

//    public static Graphics drawNumbers(Graphics g, int[][] arr){
//        for (int i=0;i<arr.length;i++){
//            for (int j=0; j<arr[0].length;j++){
//               if (arr[i][j]!=0){
//                   if (arr[i][j]>0) { g.setColor(Color.blue); }
//                   if (arr[i][j]<0) { g.setColor(Color.black);}
//                    g=drawDigit(g,Math.abs(arr[i][j]),i,j);
//                }
//            }
//        }
//        return g;
//    }

    public static void putDigit(int digit,int row, int colunm, Color color){
        drawDigit(graphics,digit,row, colunm,color);
    }

    public static void clearCell(int row, int col){
        clearCell(graphics,row,col);
    }

    private static void onRepaint(Graphics g){
        g = drawGrid(g);
//        g = drawDigit(g,9,3,2);

//        g = clearCell(g,3,2);
//        g = drawGrid(g);


    }

    SudokuWindow(){
        GameField gamefield = new GameField();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(windowwidth,windowheight);
        this.setLocation(50,50);
        this.setResizable(false);
        this.add(gamefield);
        this.setTitle("Sudoku");

        this.setVisible(true);

    }




}
