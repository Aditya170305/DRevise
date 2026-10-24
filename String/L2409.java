public class L2409 {
    
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int month [] = {31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};

        int aliceTime [] = new int [4];
        int bobTime  [] = new int [4];

        aliceTime [0] = (arriveAlice.charAt(0) - '0') * 10 + arriveAlice.charAt(1) - '0';
        aliceTime [1] = (arriveAlice.charAt(3) - '0') * 10 + arriveAlice.charAt(4) - '0';
        aliceTime [2] = (leaveAlice.charAt(0) - '0') * 10 + leaveAlice.charAt(1) - '0';
        aliceTime [3] = (leaveAlice.charAt(3) - '0') * 10 + leaveAlice.charAt(4) - '0';

        bobTime [0] = (arriveBob.charAt(0) - '0') * 10 + arriveBob.charAt(1) - '0';
        bobTime [1] = (arriveBob.charAt(3) - '0') * 10 + arriveBob.charAt(4) - '0';
        bobTime [2] = (leaveBob.charAt(0) - '0') * 10 + leaveBob.charAt(1) - '0';
        bobTime [3] = (leaveBob.charAt(3) - '0') * 10 + leaveBob.charAt(4) - '0';

        int aliceStart = aliceTime [1];
        int aliceEnd = aliceTime [3];
        int bobStart = bobTime [1];
        int bobEnd = bobTime[3];

        for(int i=0;i<aliceTime[0]-1;i++){
            aliceStart = aliceStart + month[i];
        }

        for(int i=0;i<aliceTime[2]-1;i++){
            aliceEnd = aliceEnd + month[i];
        }

        for(int i=0;i<bobTime[0]-1;i++){
            bobStart = bobStart + month[i];
        }

        for(int i=0;i<bobTime[2]-1;i++){
            bobEnd = bobEnd + month[i];
        }

        int start = Math.max(aliceStart , bobStart);
        int end = Math.min(aliceEnd , bobEnd);

        return Math.max(0 , end - start + 1);

    }
    
}
