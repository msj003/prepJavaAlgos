package test;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SeqListQuery {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int q= in.nextInt();
	        int   lastAnswer = 0;
	        
	        ArrayList<ArrayList<Integer>> queryList = new ArrayList<ArrayList<Integer>>();
	        for(int i=0 ; i<q;i++) {
	        	ArrayList<Integer> query = new ArrayList<>();
	        		for(int j=0;j<3;j++) {
	        			query.add(in.nextInt());
	        		}
	        		queryList.add(query);
	        }
	        
	        ArrayList<ArrayList<Integer>> seqList=new ArrayList<ArrayList<Integer>>();
	        for(int i=0 ; i<n; i++) {
	        		seqList.add(new ArrayList<Integer>());
	        }
	        
	        // operations calculations start here
	        for(int i=0;i<queryList.size();i++) {
	        	int opType = queryList.get(i).get(0);
	        	int xValue = queryList.get(i).get(1);
	        	int yValue = queryList.get(i).get(2);
	        		if(opType==1) {
	        			int indexofSeq = (xValue^lastAnswer)%n;
	        			seqList.get(indexofSeq).add(yValue);
	        		}
	        		if(opType==2) {
	        			int indexofSeq = (xValue^lastAnswer)%n;
	        			lastAnswer=seqList.get(indexofSeq).get(yValue%seqList.get(indexofSeq).size());
	        			System.out.println(lastAnswer);
	        		}
	        }
	 }
}