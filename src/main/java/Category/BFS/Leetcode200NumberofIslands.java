package Category.BFS;

import java.util.*;

public class Leetcode200NumberofIslands {

    public static int numIslandsV2(char[][] grid) {
        Set<Loc> locations = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') continue;
                Loc loc = new Loc(i, j);
                locations.add(loc);
            }
        }

        List<Set<Loc>> islands = floodIsland(locations);
        return islands.size();
    }

    private static List<Set<Loc>> floodIsland(Set<Loc> boarders) {
        List<Set<Loc>> result = new ArrayList<>();
        while (boarders.size() > 0) {
            Set<Loc> island = new HashSet<>();
            result.add(island);
            Loc loc = boarders.iterator().next();
            deleteNeighbor(loc, boarders, island);
        }
        return result;
    }

    private static void deleteNeighbor(Loc loc, Set<Loc> boarders, Set<Loc> island) {
        boarders.remove(loc);
        island.add(loc);

        Loc locTop = new Loc(loc.x - 1, loc.y);
        Loc locDown = new Loc(loc.x + 1, loc.y);
        Loc locLeft = new Loc(loc.x, loc.y - 1);
        Loc locRight = new Loc(loc.x, loc.y + 1);

        boolean top = boarders.contains(locTop);
        if (top) deleteNeighbor(locTop, boarders, island);
        boolean down = boarders.contains(locDown);
        if (down) deleteNeighbor(locDown, boarders, island);
        boolean left = boarders.contains(locLeft);
        if (left) deleteNeighbor(locLeft, boarders, island);
        boolean right = boarders.contains(locRight);
        if (right) deleteNeighbor(locRight, boarders, island);
    }

    public static int numIslands(char[][] grid) {
        List<Set<Loc>> islands = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') continue;

                Loc loc = new Loc(i, j);
                if (hasCount(loc, islands)) continue;

                Set<Loc> locations = new HashSet<>();
                islands.add(locations);
                findIsland(loc, grid, locations);
            }
        }

        return islands.size();
    }

    private static void findIsland(Loc loc, char[][] grid, Set<Loc> locations) {
        if (loc.x < 0 || loc.x >= grid.length) return;
        if (loc.y < 0 || loc.y >= grid[0].length) return;
        if (grid[loc.x][loc.y] == '0') return;

        if (locations.contains(loc)) return;
        locations.add(loc);

        findIsland(new Loc(loc.x + 1, loc.y), grid, locations);
        findIsland(new Loc(loc.x - 1, loc.y), grid, locations);
        findIsland(new Loc(loc.x, loc.y + 1), grid, locations);
        findIsland(new Loc(loc.x, loc.y - 1), grid, locations);
    }

    private static boolean hasCount(Loc loc, List<Set<Loc>> islands) {
        for (Set<Loc> island : islands) {
            if (island.contains(loc)) return true;
        }
        return false;
    }

    private static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Loc loc = (Loc) o;
            return x == loc.x && y == loc.y;
        }

        @Override
        public int hashCode() {
            return 13 * x + 17 * y;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid1));
        System.out.println(numIslandsV2(grid1));

        char[][] grid2 = {
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}
        };

        System.out.println(numIslands(grid2));
        System.out.println(numIslandsV2(grid2));
    }
}
