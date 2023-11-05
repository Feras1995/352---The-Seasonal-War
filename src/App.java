import java.util.Scanner;

class Main {
    static char[][] adj;
    static boolean[][] visited;
    static int n;
    static int counter = 0;

    
    static int[] moveX = {-1,-1,-1,0,1,1,1,0};
    static int[] moveY = {-1,0,1,1,1,0,-1,-1};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i=0;i<8;i++){
            int xc=x+moveX[i];
            int yc=y+moveY[i];
            if( isvalid(xc, yc) && adj[xc][yc]=='1' && !visited[xc][yc])
            dfs(xc, yc);
        }

    }

    static int warZoneCounter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    static boolean isvalid(int x, int y) {
        if (x < n && y < n && x >= 0 && y >= 0)
            return true;
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int c=1;
        while (sc.hasNext()) {
            n = sc.nextInt();
        adj = new char[n][n];
        visited=new boolean[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++){
                adj[i][j] = line.charAt(j);
                visited[i][j]=false;
            }
        }
        System.out.printf("Image number %d contains %d war eagles.\n",c,warZoneCounter());
        c++;
        counter=0;
        }
    }
}