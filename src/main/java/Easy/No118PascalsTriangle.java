package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class No118PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 1) return List.of(List.of(1));
        if (numRows == 2) return List.of(List.of(1), List.of(1, 1));

        List<List<Integer>> towerList = new ArrayList<>();
        towerList.add(List.of(1));
        towerList.add(List.of(1, 1));

        for (int i = 3; i <= numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    rowList.add(1);
                } else {
                    List<Integer> lastRowList = towerList.get(i - 2);
                    rowList.add(lastRowList.get(j - 1) + lastRowList.get(j));
                }
            }
            towerList.add(rowList);
        }
        return towerList;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        result.forEach(System.out::println);
    }
}
