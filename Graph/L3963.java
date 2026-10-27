public class L3963 {
    
    public String[] createGrid(int m, int n) {
        
        String ans [] = new String [m];

        StringBuilder str = new StringBuilder();

        for(int i=0;i<n;i++){
            str.append(".");
        }

        ans[0] = str.toString();

        str = new StringBuilder();

        for(int i=0;i<n;i++){

            if(i != n - 1){
                str.append("#");
            }

            else{
                str.append(".");
            }

        }

        for(int i=1;i<m;i++){

            ans[i] = str.toString();

        }

        return ans;
    
    }
    
}
