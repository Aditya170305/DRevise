public class L3871 {
    
    public long countCommas(long n) {
        
        if(n < 1000) return 0;

        long diff = 0;

        if(n >= 1000){
            
            if(n < (long)(1e6)) diff = n - 1000 + 1;
            else diff = (long)(1e6) - (long)(1e3);

        }

        if(n >= 1000000){
           
           if(n < (long)(1e9)) diff = diff + ((n - (long)(1e6) + 1)) * 2;

           else diff = diff + ((long)(1e9) - (long)(1e6)) * 2;

        }

        if(n >= (long)(1e9)){
            
            if(n < (long)(1e12)) diff = diff + ((n - (long)(1e9) + 1)) * 3;

            else diff = diff + ((long)(1e12) - (long)(1e9)) * 3;

        }

        if(n >= (long)(1e12)){
            
            if(n < (long)(1e15)) diff = diff + (n - (long)(1e12) + 1) * 4;

            else diff = diff + ((long)(1e15) - (long)(1e12)) * 4;

        }

        if(n >= (long)(1e15)){

            diff = diff + (n - (long)(1e15) + 1) * 5;
            
        }

        return diff;

    }
    
}
