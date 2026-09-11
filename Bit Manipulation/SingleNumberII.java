public class SingleNumberII {
    
    public static int elementThatAppearsOnce(int[] arr) 
	{
		
		// Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

		// for(int i=0;i<arr.length;i++){

		// 	if(mpp.containsKey(arr[i])){

		// 		mpp.put(arr[i] , mpp.get(arr[i]) + 1);
		// 	}

		// 	else{

		// 		mpp.put(arr[i] , 1);
		// 	}
		// }

		// for(Map.Entry<Integer , Integer> en : mpp.entrySet()){

		// 	if(en.getValue() == 1){

		// 		return en.getKey();

		// 	}
		// }

		// return -1;

		// Arrays.sort(arr);

		// for(int i=1;i<arr.length;i+=3){

		// 	if(arr[i] != arr[i-1]){

		// 		return arr[i-1];
		// 	}
		// }

		// return arr[arr.length-1];

		// int ans = 0;

		// for(int bitIndex=0;bitIndex<=31;bitIndex++){

		// 	int count = 0;

		// 	for(int i=0;i<arr.length;i++){

		// 		if((arr[i] & (1 << bitIndex)) != 0){
		// 			count++;
		// 		}

		// 	}

		// 	if(count % 3 == 1){
		// 		ans = ans | (1 << bitIndex);
		// 	}

		// }

		// return ans;

		int ones = 0 , twos = 0;

		for(int i=0;i<arr.length;i++){

			ones = (ones ^ arr[i]) & (~twos);
			twos = (twos ^ arr[i]) & (~ones);

		}

		return ones;
		
	}
}
