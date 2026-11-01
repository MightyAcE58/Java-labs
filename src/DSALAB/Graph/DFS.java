package DSALAB.Graph;

class DFS {

    int[][] graph = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 1, 0}
    };

    boolean[] visited = new boolean[5];

    void dfs(int vertex) {
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for (int i = 0; i < 5; i++) {
            if (graph[vertex][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS();

        System.out.print("DFS: ");
        g.dfs(0);
    }
}