package cs.lab;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        MineSweeper.logger.info("CS-UTEC Software Engineering I");
        Scanner input = new Scanner(System.in);
        Integer boardSize = input.nextInt();
        MineSweeper game = new MineSweeper(boardSize);
        game.printBoard();
        int x;
        int y;
        while(!game.gameOver){
            MineSweeper.logger.info("Ingrese la coordenada x: "); x = input.nextInt();
            MineSweeper.logger.info("Ingrese la coordenada y: "); y = input.nextInt();
            game.play(x, y);
            game.printBoard();
        }
        MineSweeper.logger.info("PERDISTE!!!");
        game.printBoard();
        input.close();
    }
}
