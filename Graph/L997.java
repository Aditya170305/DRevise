public class L997 {
    
    public int findJudge(int n, int[][] trust) {
        
        int mat [][] = new int [n + 1][n + 1];

        for(int i=0;i<trust.length;i++){
            
            int a = trust[i][0];
            int b = trust[i][1];

            mat[a][b] = 1;

        }

        int top = 1;
        int bottom = n;

        while(top < bottom){

            if(mat[top][bottom] == 1) top++;
            else if(mat[bottom][top] == 1) bottom--;
            else{

                top++;
                bottom--;

            }

        }

        if(top > bottom) return -1;

        for(int i=1;i<=n;i++){

            if(i == top) continue;

            if(mat[top][i] == 0 && mat[i][top] == 1){

            }

            else{ 
                return -1;
            }

        }

        return top;

    }
    
}
