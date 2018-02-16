package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ManipulateArray {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        
	        ArrayList<Integer> list= new ArrayList<Integer>();
	        for(long i = 0 ; i< n ; i++) {
	        	list.add(0);
	        	}
	        for(int a0 = 0; a0 < m; a0++){
	            int a = in.nextInt()-1;
	            int b = in.nextInt()-1;
	            int k = in.nextInt();
	            for(int i =a ;i <= b ; i++) {
	            		list.set(i, list.get(i)+k);	
	            	}
	        }
	        System.out.println(Collections.max(list));
	        
	        in.close();
	    }
	 
	 
	 
	 
	 
	 

}
