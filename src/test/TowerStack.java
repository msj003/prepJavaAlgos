package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TowerStack {
	  static int tileStackingProblem(int n, int m, int k) {
	        // Complete this function
		  //n   ----> 1- n (height)
	   //m---> max weight used
	//k-> max times one of m tiles can be used.
		  
		  ArrayList<Set<Integer>> setList = new  ArrayList<Set<Integer>>();
		  for(int i = 0; i <= k*m ;i++) {
			 
		  }
	  }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int k = in.nextInt();
	        int result = tileStackingProblem(n, m, k);
	        System.out.println(result);
	        in.close();
	    }
}
