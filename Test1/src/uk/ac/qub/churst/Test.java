package uk.ac.qub.churst;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] numbers = {1,2,3,4,5,4589,4,4,4};
		System.out.println(findNumber(numbers,6));
		System.out.println(findNumber(numbers,4));
		
		int[]odds = oddNumbers(1,1);
		
		for(int i =0; i<odds.length;i++){
			System.out.println(odds[i]);
		}
	}
	static String findNumber(int[] arr, int k) {
		String answer = "NO";
		
		for(Integer i: arr){
			if(i==k){
				answer="YES";
			}
		}
return answer;
    }
	
	 static int[] oddNumbers(int l, int r) {
		   int size = ((r-l)/2)+1;
		        
			    int [] answer = new int [size];
		        if(l!=r){
			   int k=0;
			    for(int i =l; i<=r; i++){
			    	if(i%2==1){
			    		answer[k]=i;
			    		k++;
			    	}
			    }}else {
		        if(l%2==1){
		            answer[0]=l;
		        } else {
		            answer=null;
		        }
		    }
return answer;
}
}
