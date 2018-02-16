package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockPurchase {
	 static int stockPurchaseDay(int[] A, int xi) {
		  int lastval=-1;
		 for(int i = A.length-1;i>=0; i--) {
			 if(A[i] <= xi) {
				 lastval =i+1;
				 break;
			 }
		 }
		 return lastval;
}

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] A = new int[n];
	        int min=1000000000;
	        for(int A_i = 0; A_i < n; A_i++){
	        		 A[A_i] = in.nextInt();
	        		if(A[A_i] < min) {
	        			min=A[A_i];
	        		}
	  	    }
	        int q = in.nextInt();
	       
	        
	        for(int a0 = 0; a0 < q; a0++){
	            int xi = in.nextInt();
	            if(xi<min) {
		        		System.out.println(-1);
		        }else {
	            int result = stockPurchaseDay(A, xi);
	            System.out.println(result);
		        }
	        }
	        in.close();
	    }

}
