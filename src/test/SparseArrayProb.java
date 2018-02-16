package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SparseArrayProb {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        ArrayList<String> seqList = new ArrayList<>();
        for(int i=0; i<n ; i++) {
        		seqList.add(in.nextLine());
        }
        int q = in.nextInt();
        //System.out.println(q);
        in.nextLine();
        for(int i = 0 ; i < q ; i++) {
        		int count = 0 ;
        		String query = in.nextLine();
        		for(String a : seqList) {
        			if(a.equals(query)) {
        				count++;
        			}
        		}
        		
        		System.out.println(count);
        }
        in.close();
	}

}
