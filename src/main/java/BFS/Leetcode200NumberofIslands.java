package BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode200NumberofIslands {

    public int numIslands(char[][] grid) {
        int island = 0;
        Map<Integer, Set<Loc>> islandMap = new HashMap<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {


                    Set<Loc> land = new HashSet<>();
                    findLand(new Loc(x, y), land, grid);
                }
            }
        }

        return 0;
    }

    private void findLand(Loc loc, Set<Loc> land, char[][] grid) {
        if (loc.x < 0 || loc.x >= grid.length) return;
        if (loc.y < 0 || loc.y >= grid[0].length) return;
        if (grid[loc.x][loc.y] == '0') return;

        land.add(loc);
        findLand(new Loc(loc.x + 1, loc.y), land, grid);
        findLand(new Loc(loc.x - 1, loc.y), land, grid);
        findLand(new Loc(loc.x, loc.y + 1), land, grid);
        findLand(new Loc(loc.x, loc.y - 1), land, grid);
    }

    public static class Loc {
        int x;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int y;
    }
}
