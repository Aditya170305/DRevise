public class BinaryToDecimal {
    
    public int binaryToDecimal(String b) {
        
        int len = b.length() - 1;
        int p = 1;
        int num = 0;
        
        for(int i=len;i>=0;i--){
            
            if(b.charAt(i) == '1') num = num + p;
            p = p * 2;
            
        }
        
        return num;
        
    }

}
