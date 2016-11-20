package ru.sserg.games;

import java.awt.*;
import java.util.Scanner;

import static ru.sserg.games.SudokuGrid.*;
import static ru.sserg.games.SudokuWindow.*;


public class SudokuGame {

        public static void main(String[] args) {
            int[][] grid = new int[9][9];
            grid = initGrid(grid);

            boolean endgameflag=false;
            Scanner scanner = new Scanner(System.in);
            int i=0;
            int r;
            int c;
            int v;

            SudokuWindow sw = new SudokuWindow();

//            for (int i1=0;i1<9; i1++){
//                for (int j1=0; j1<9; j1++){
//
//                    putDigit(grid[i1][j1],i1,j1, Color.black);
//                }
//            }


//        do{
//            printGrid(grid);
//            System.out.println("Выберите действие (1-редактирование ячейки, 0 - выход)");
//            i=scanner.nextInt();
//            if (i==0) {endgameflag=true;}
//            if (i==1) {
//                System.out.println("Введите номер строки");
//                r=scanner.nextInt();
//
//                System.out.println("Введите номер столбца");
//                c=scanner.nextInt();
//
//                System.out.println("Введите значение");
//                v=scanner.nextInt();
//
//                setCell(grid,r,c,v);
//                if (!checkRow(grid,r)){ System.out.println("Ошибочное значение в строке "+r);}
//                if (!checkColumn(grid,c)) {System.out.println("Ошибочное значение в столбце "+c);}
//                if (!checkSquare(grid,r,c)){System.out.println("Ошибочное значение в квадрате ячейки ["+r+";"+c+"]");}
//            }
//
//        }while (!endgameflag);

    }

}
