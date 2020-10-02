package cs.lab;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MineSweeper {

    private List<ArrayList<Integer>> board = new ArrayList<>();
    private List<ArrayList<Boolean>> flags = new ArrayList<>();
    private SecureRandom randomMine = new SecureRandom();

    private int size;
    boolean gameOver = false;

    static final Logger logger = Logger.getLogger(MineSweeper.class.getName());

    public MineSweeper(int boardSize) {
        size = boardSize;
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
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> filaDeBoard = new ArrayList<>();
            ArrayList<Boolean> filaDeFlags = new ArrayList<>();
            board.add(filaDeBoard);
            flags.add(filaDeFlags);
            for (int j = 0; j < size; j++) {
                board.get(i).add(j, 0);
                flags.get(i).add(j, false);
          }
        }
    }

    public void printBoard() {
        String boardValue = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
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
}
