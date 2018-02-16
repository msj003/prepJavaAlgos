package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubsequenceSum {

	public static List<List<Long>> combinations(long[] arr) {
	    List<List<Long>> c = new ArrayList<List<Long>>();
	    List<Long> l;
	    for (int i = 0; i < arr.length; i++) {
	      int k = c.size();
	      for (int j = 0; j < k; j++) {
	        l = new ArrayList<Long>(c.get(j));
	        l.add(new Long(arr[i]));
	        c.add(l);
	      }
	      l = new ArrayList<Long>();
	      l.add(new Long(arr[i]));
	      c.add(l);
	    }
	    return c;
	}
    
    static long modifiedSubsequenceSum(int n, int k, long[] A) {
        // Complete this function
    	List<List<Long>> subSeq = 	new ArrayList<List<Long>>();
    	subSeq= combinations(A);
    	List<Long> org = new ArrayList<Long>();
    	for (int index = 0; index < A.length; index++)
		 {
		     org.add(A[index]);
		 }
    	subSeq.add(org);
 	ArrayList<Long> sbList = new ArrayList<Long>();
    	for(List<Long> ls : subSeq) {
    		long sum =0;
    		for(Long l : ls) {
    			sum=sum+l;
    		}
    		sbList.add(sum-(k*eachSeqDistSum(ls,org)));
    		}
    	long max = Collections.max(sbList);
   	return max;
  }
    public 	static long eachSeqDistSum(List<Long> eachSeq,List<Long> org) {
    int prevIndex=0;
    int di =0;
    ArrayList<Integer> dDiff = new ArrayList<Integer>();
    	for(long l:eachSeq) {
    		int ind=org.indexOf(l)+1;
    		di=(ind-prevIndex);
    		prevIndex=ind;
    		dDiff.add(di);
    }
    	int s2b=0;
    	
    	for(int i=1 ;i<dDiff.size();i++) {
    		int d= dDiff.get(i);
    		s2b=s2b+((d-1)*(d-1));
    	}
   	return s2b;
 }



    public static void main(String[] args) { 
         Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] A = new long[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextLong();
        }
        long result = modifiedSubsequenceSum(n, k, A);
        System.out.println(result);
        in.close();
        
    }
}
