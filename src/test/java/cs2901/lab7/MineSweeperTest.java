package cs2901.lab7;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static cs2901.lab7.FileReader.*;

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
        List<ArrayList<Integer>> board = new ArrayList<>();
        ms.createGrid();
        Assert.assertEquals(10, ms.getBoard().size());
     }
     public void testCase6() throws IOException {
        int n = 5;
        MineSweeper ms = new MineSweeper(n);
        ms.createGrid();
        Assert.assertEquals(10, ms.getFlags().size());
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

/*    private ArrayList<ArrayList<Integer>> readInputPositions(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        int n = Integer.parseInt(lines.get(0));
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        int count = 0;
        for (int i = n * n + 1; i < lines.size(); i += 2) {
            out.add(new ArrayList<Integer>());
            out.get(count).add(0, Integer.parseInt(lines.get(i)));
            out.get(count).add(1, Integer.parseInt(lines.get(i + 1)));
            count += 1;
        }
        return out;
    }

    private ArrayList<ArrayList<Integer>> readInputMatrix(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        int n = Integer.parseInt(lines.get(0));
        int count = 1;
        ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i) {
            board.add(new ArrayList<Integer>());
            for (int j = 0; j < n; ++j) {
                board.get(i).add(Integer.parseInt(lines.get(count++)));
            }
        }
        return board;
    }

    private List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }*/
}