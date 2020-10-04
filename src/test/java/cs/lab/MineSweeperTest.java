package cs.lab;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cs.lab.FileReader.*;

@Test
public class MineSweeperTest {

    public void testCase0() throws IOException {
        genericMatrix(0);
    }

    public void testCase1() throws IOException {
        genericMatrix(1);
    }

     public void testCase2() throws IOException {
         genericMatrix(2);
     }
     public void testCase3() throws IOException {
         genericMatrix(3);
     }
     public void testCase4() throws IOException {
         
         List<ArrayList<Integer>> board = new ArrayList<>();
         MineSweeper ms = new MineSweeper(board);
         Assert.assertEquals(board, ms.getBoard());
     }
     public void testCase5() throws IOException {
        int n = 5;
        MineSweeper ms = new MineSweeper(n);
        ms.createGrid();
        Assert.assertEquals(ms.getBoard().size(), 10);
     }
     public void testCase6() throws IOException {
        int n = 5;
        MineSweeper ms = new MineSweeper(n);
        ms.createGrid();
        Assert.assertEquals(ms.getFlags().size(), 10);
     }

    private void genericMatrix(int n) throws IOException {
        ArrayList<ArrayList<Integer>> newBoard = readInputMatrix(n);
        ArrayList<ArrayList<Integer>> positions = readInputPositions(n);
        MineSweeper ms = new MineSweeper(newBoard);
        List<String> expectedOutput = readOutput(n);
        for (int i = 0; i < expectedOutput.size(); ++i) { 
            ms.isBomb(positions.get(i).get(0), positions.get(i).get(1));
            Assert.assertEquals(expectedOutput.get(i).equals("1"), ms.gameOver);
        }
    }
}