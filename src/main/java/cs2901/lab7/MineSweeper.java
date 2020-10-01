package cs2901.lab7;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Scanner;

public class MineSweeper {

    private List<ArrayList<Integer>> board = new ArrayList<>();
    private List<ArrayList<Boolean>> flags = new ArrayList<>();
    private SecureRandom randomMine = new SecureRandom();

    private int n;
    boolean gameOver = false;

    static final Logger logger = Logger.getLogger(MineSweeper.class.getName());

    public MineSweeper(int boardSize) {
        n = boardSize;
        createGrid();
        insertMines();
    }

    public MineSweeper(List<ArrayList<Integer>> newBoard) {
        board = newBoard;
    }

    public List<ArrayList<Integer>> getBoard(){
        return board;
    }

    public List<ArrayList<Boolean>> getFlags(){
        return flags;
    }

    public void createGrid() {
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> filaDeBoard = new ArrayList<>();
            ArrayList<Boolean> filaDeFlags = new ArrayList<>();
            board.add(filaDeBoard);
            flags.add(filaDeFlags);
            for (int j = 0; j < n; j++) {
                board.get(i).add(j, 0);
                flags.get(i).add(j, false);
          }
        }
    }

    public void printBoard() {
        String boardValue = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = flags.get(i).get(j);
                if(flag || gameOver){
                    boardValue = Integer.toString(board.get(i).get(j)) + " ";
                    logger.info(boardValue);
                }else{
                    logger.info("X ");
                }
            }
        }
    }
    
    public void insertMines() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board.get(i).add(j, this.randomMine.nextBoolean() ? 1 : 0);
            }                   
        }
    }

    public void isBomb(int x, int y){
        if (board.get(x).get(y) == 1){
            gameOver = true;
        }
    }

    public void play(int x, int y){
        flags.get(x).add(y, true);
        isBomb(x, y);
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public static void main(String[] args){
        logger.info("CS-UTEC Software Engineering I");
        Scanner input = new Scanner(System.in);
        Integer boardSize = input.nextInt();
        MineSweeper game = new MineSweeper(boardSize);
        game.printBoard();
        int x;
        int y;
        while(!game.gameOver){
            logger.info("Ingrese la coordenada x: "); x = input.nextInt();
            logger.info("Ingrese la coordenada y: "); y = input.nextInt();
            game.play(x, y);
            game.printBoard();
        }
        logger.info("PERDISTE!!!");
        game.printBoard();
        input.close();
    }
}
