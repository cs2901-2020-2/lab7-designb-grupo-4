package cs2901.lab7;

import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    static public ArrayList<ArrayList<Integer>> readInputPositions(int testNumber){
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

    static public ArrayList<ArrayList<Integer>> readInputMatrix(int testNumber){
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

    static public List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

    static public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = FileReader.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }

}