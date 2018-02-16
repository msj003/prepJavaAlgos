package test;


import java.util.*;
import java.lang.*;
import java.io.*;


public class test1 {
    public static int nthMostRare(int[] a, int n) {
      //  throw new UnsupportedOperationException("Waiting to be implemented.");
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		  int maxCount=0, freqValue = -1;
		  for(int i=0; i < a.length; i++) {
		     if(map.get(a[i]) == null) { //Insert new.
		        map.put(a[i], 1);
		     }else { //Already exists. Just increment the count.
		        int count = map.get(a[i])+1;
		        map.put(a[i], count);
		       if(count > maxCount) {
		           maxCount = count;
		           freqValue = a[n];
		        }
		        
		     }
		 
		 }
		  
		  System.out.println(a);
		  System.out.println(map);
		  
		  if(freqValue == -1 && a.length>=0)
		     return a[0];
		  return freqValue-1;
       
    }
    
    

    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5,1 ,5,3,3,3,3,3}, 1);
        System.out.println(x);
    }
}