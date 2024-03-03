package free.BasicArrays;

import java.util.Scanner;

public class SpreadsheetSimulator {

    private int x, y;
    private int upperLimit = 100;
    private int[][] dataSource;

    SpreadsheetSimulator(){
        this(10, 10, 100);
    }

    SpreadsheetSimulator(int width, int height){
        this(width, height, 100);
    }

    /** Subtask 1.6
     *  Rewrite your program so that the array size and the number of random
     * numbers are variable and can be entered.
     * */
    SpreadsheetSimulator(int width, int height, int upperLimit){
        x = width;
        y = height;
        this.upperLimit = upperLimit;

        dataSource = new int[x][y];
    }

    /** Subtask 1.1 */
    void fillWithRandomNumbers(){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                dataSource[i][j] = getRandomInt();
            }
        }
    }

    /** Subtask 1.2 */
    void print(){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                System.out.print(dataSource[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /** Subtask 1.3 */
    void expandOneRowAndOneColumn(){
        int[][] newDataSource = new int[x+1][y+1];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                newDataSource[i][j] = dataSource[i][j];
            }
        }

        for(int i = 0; i < x+1; i++){
            newDataSource[i][y] = getRandomInt();
        }

        for(int j = 0; j < y+1; j++){
            newDataSource[x][j] = getRandomInt();
        }

        dataSource = newDataSource;
    }

    /** Subtask 1.4 */
    void changeOneCell(int x, int y, int newValue){
        dataSource[x][y] = newValue;
    }

    /** Subtask 1.5
     * Determine how often each possible number occurs. Use another array to solve.
     * Write a new method for this.
     * */
    void reportNumbersAndCounts(){
        int[] count = new int[upperLimit+1];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                count[dataSource[i][j]]++;
            }
        }
        for(int i = 0; i < 100; i++){
            if(count[i]!= 0){
                System.out.println(i + "\t" + count[i]);
            }
        }
    }

    private int getRandomInt() {
        return (int) (Math.random() * upperLimit);
    }

    public static void main(String[] args) {
        SpreadsheetSimulator spreadsheetSimulator = new SpreadsheetSimulator();
        
        System.out.println(" Subtask 1.1");
        spreadsheetSimulator.fillWithRandomNumbers();
        System.out.println("-----------------------------------------");
        
        System.out.println(" Subtask 1.2");
        spreadsheetSimulator.print();
        System.out.println("-----------------------------------------");
        
        System.out.println(" Subtask 1.3");
        spreadsheetSimulator.expandOneRowAndOneColumn();
        spreadsheetSimulator.print();
        System.out.println("-----------------------------------------");
        
        System.out.println(" Subtask 1.4");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int x = scanner.nextInt();
        System.out.println("Enter column: ");
        int y = scanner.nextInt();
        System.out.println("Enter newValue: ");
        int newValue = scanner.nextInt();
        spreadsheetSimulator.changeOneCell(x, y, newValue);
        spreadsheetSimulator.print();
        System.out.println("-----------------------------------------");
        
        System.out.println(" Subtask 1.5");
        spreadsheetSimulator.reportNumbersAndCounts();
    }
}

