package ru.sserg.games;



public class SudokuGrid {

//    public static int[][] Grid;
//
//
//    SudokuGrid(){
//        Grid = new int[9][9];
//
//    }

//    SudokuGrid(){
//
//    }

    public static int[][] initGrid(int[][] arr){
        arr=fillGrid(arr);
        arr=shuffleGrid(arr);
        arr=clearCells(arr,40);
        return arr;
    }

 //   private static int[][] grid= new int[9][9];

    private static int[][] fillGrid(int[][] arr){
        for (int s = 0; s<3; s++){
            for (int i=0;i<3;i++){
                for (int j=0; j<9;j++){
                    arr[3*s+i][j]=j+1+s+3*i;
                    if (arr[3*s+i][j]>9){arr[3*s+i][j]-=9;}
                }
            }
        }
        return arr;
    }

    public static void printGrid(int[][] arr){
        System.out.print("   ");

        for (int i=0; i<arr.length;i++) { System.out.print(" " + i); }

        System.out.println(" ");
        System.out.print("   ");

        for (int i=0; i<arr.length;i++) { System.out.print(" -"); }

        System.out.println(" ");

        for (int i=0; i<arr.length;i++){
            System.out.print("|" + i + "|");

            for (int j=0;j<arr[i].length;j++){
                System.out.print(" "+arr[i][j]);
            }
            System.out.println(' ');
        }
    }

    private static int[][] shuffleGrid(int[][] arr){
        final int iterationcount = 10;

        int metodshuffle;
        int area1;
        int line1;
        int area2;
        int line2;

        for (int i=0; i<iterationcount; i++) {
            metodshuffle = (int) (Math.random() * 5);
            if (metodshuffle == 0) { //Меняем строки
                area1 = (int) (Math.random() * 3);  // Выбираем область для замены
                line1 = (int) (Math.random() * 3);  // выбираем строку 1
                line2 = (int) (Math.random() * 3);  // Выбираем строку 2

                swapArrays(arr[area1 * 3 + line1], arr[area1 * 3 + line2]);
            }
            if (metodshuffle == 1) { // Транспонируем таблицу
                arr = transpanentGrid(arr);
            }
            if (metodshuffle == 2) { // Меняем группы строк
                area1 = (int) (Math.random() * 3);  // Выбираем область 1 для замены
                area2 = (int) (Math.random() * 3);  // Выбираем область 2 для замены

                for (int j=0;j<3;j++){ swapArrays(arr[area1 * 3 + j], arr[area2 * 3 + j]); }
            }
            if (metodshuffle == 3) { //Меняем столбцы
                area1 = (int) (Math.random() * 3);  // Выбираем область для замены
                line1 = (int) (Math.random() * 3);  // выбираем строку 1
                line2 = (int) (Math.random() * 3);  // Выбираем строку 2

                arr = transpanentGrid(arr);
                swapArrays(arr[area1 * 3 + line1], arr[area1 * 3 + line2]);
                arr = transpanentGrid(arr);
            }

            if (metodshuffle == 4) { // Меняем группы столбцов
                area1 = (int) (Math.random() * 3);  // Выбираем область 1 для замены
                area2 = (int) (Math.random() * 3);  // Выбираем область 2 для замены

                arr = transpanentGrid(arr);
                for (int j=0;j<3;j++){ swapArrays(arr[area1 * 3 + j], arr[area2 * 3 + j]); }
                arr = transpanentGrid(arr);
            }
        }
        return arr;
    }

    private static void swapArrays(int[] ar1, int[] ar2){
        if (ar1.length == ar2.length) {
            for (int i=0; i< ar1.length;i++){
                ar1[i]=ar1[i]+ar2[i]-(ar2[i]=ar1[i]);
            }
        }

//        int[] arrtmp = new int[9];
//        arrtmp=ar1;
//        ar1=ar2;
//        ar2=arrtmp;
    }

//    public static void printArray(int[] arr){
//        for (int j=0;j<arr.length;j++){
//            System.out.print(" "+arr[j]);
//        }
//    }

    private static int[][] transpanentGrid(int[][] arr){
        int[][] resultarr = new int[arr.length][arr[0].length];

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length;j++){
                resultarr[j][i]=arr[i][j];
            }
        }
        return resultarr;
    }

    private static int[][] clearCells(int[][] arr, int cnt){
        for (int i=0; i<cnt;i++){
            arr[(int) (Math.random()*9)][(int) (Math.random()*9)]=0;
        }
        return arr;
    }

    public static boolean checkRow(int[][] arr, int row){

        int[] counts = new int[arr.length+1];
        for (int i=0; i<arr.length; i++){
            counts[ Math.abs(arr[row][i])]++;
        }

        for (int i=1; i<arr.length+1; i++){
            if (counts[i]>1) { return false; }
        }
        return true;
    }

    public static boolean checkColumn(int[][] arr, int col){
        return checkRow(transpanentGrid(arr),col);
    }

    public static boolean setCell(int[][] arr, int row, int col, int value){
        if (arr[row][col]<=0) {
            arr[row][col] = -1*value;
            return true;
        }
        else {return false;}

         //checkCell(arr, row, col);
    }

    public static boolean checkSquare(int[][] arr, int row, int col){
        int[] counts = new int[arr.length+1];
        int r = 3*((int) (row/3));
        int c = 3*((int) (col/3));
        for (int i=r; i<(r+3);i++){
            for (int j=c; j<(c+3);j++){
                counts[ Math.abs(arr[row][i])]++;
            }
        }
        for (int i=1; i<arr.length+1; i++){
            if (counts[i]>1) { return false; }
        }
        return true;
    }

}


