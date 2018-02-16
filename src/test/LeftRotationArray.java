package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotationArray {
	  static int[] leftRotation(int[] a, int d) {
	        // Complete this function
		  int arr[] =a;
		  for(int i =0 ; i<d ; i++) {
			  int temp = arr[0];
			  for(int j =0; j <arr.length-1;j++) {
				  arr[j]=arr[j+1];
			  }
			  arr[arr.length-1]=temp;
		  }
		  return arr;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int d = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i = 0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        int[] result = leftRotation(a, d);
	        for (int i = 0; i < result.length; i++) {
	            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
	        }
	        System.out.println("");


	        in.close();
	    }
	    
}
