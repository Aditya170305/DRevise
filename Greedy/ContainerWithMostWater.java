public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        
        int n = height.length;

        int max_area = 0;
        int i = 0 , j = n - 1;

        while(i < j){

            int area = (j - i) * Math.min(height[i] , height[j]);
            max_area = Math.max(area , max_area);

            if(height[i] < height[j]){
                i++;
            }

            else{
                j--;
            }

        }

        return max_area;
        
    }
    
}
