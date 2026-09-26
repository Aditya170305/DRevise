public class LemanodeChange {
    
    public static boolean lemonadeChange(int []bill) {
        
        int five = 0;
        int ten = 0;

        for(int i=0;i<bill.length;i++){

            if(bill[i] == 5) five = five + 1;
            else if(bill[i] == 10){

                if(five != 0){
                    five = five - 1;
                    ten = ten + 1;
                }

                else{
                    return false;
                }
            }

            else{

                if(ten != 0 && five != 0){
                    ten = ten - 1;
                    five = five - 1;
                }

                else if(five >= 3){
                    five = five - 3;
                }

                else{
                    return false;
                }

            }
            
        }

        return true;
        
    }

}
