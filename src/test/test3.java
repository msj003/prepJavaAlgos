package test;
import java.util.*;
import java.lang.*;
import java.io.*;

class test3
{
	public static void main (String[] args) throws java.lang.Exception
	{
		RunTests();
	}

	public static void TestGraduatedValue(String testName, long value, int decimalPlaces, boolean addDecimalForSingleDigit, String expected)
    {
        String output;
        try {
          output = GraduatedValue(value, decimalPlaces, addDecimalForSingleDigit);
        } catch (Exception e) {
          output = "exception";
        }
        
        if((output != null && output.equals(expected)) || (output == null && expected == null) || (expected==null && "".equals(output)))
          System.out.println("Succeeded for " + testName);
        else
        System.out.println("Failed for " + testName + ": Failed with [" + output + "] rather than [" + expected + "]");
    }

	public static void RunTests()
	{
	    TestGraduatedValue("Simplest Low Value", 123, 0, false, "123");
	    TestGraduatedValue("Zero", 0, 0, false, "0");
	    TestGraduatedValue("Decimal Zeros", 0, 4, false, "0.0000");

	    TestGraduatedValue("Simple One Grad", 12345, 0, false, "12K");
	    TestGraduatedValue("Simple With Decimals", 12345, 3, false, "12.345K");

	    TestGraduatedValue("AddDec Shouldnt Affect", 12345, 0, true, "12K");
	    TestGraduatedValue("Zero AddDec", 0, 0, true, "0.0");

	    TestGraduatedValue("Round Integer Up", 1880, 0, false, "2K");
	    TestGraduatedValue("Round Decimal Up", 1880, 1, false, "1.9K");
	    TestGraduatedValue("Round After AddDec", 1880, 0, true, "1.9K");

	    TestGraduatedValue("Bankers Rounding Up", 1500, 0, false, "2K");
	    TestGraduatedValue("Bankers Rounding Down", 4500, 0, false, "4K");

	    TestGraduatedValue("Small Negatives", -123, 0, false, "-123");
	    TestGraduatedValue("Negatives", -1000, 0, false, "-1K");
	    TestGraduatedValue("Negatives Bankers Up", -1500, 0, false, "-2K");
	    TestGraduatedValue("Bankers Bankers Down", -4500, 0, false, "-4K");

	    TestGraduatedValue("Large With Decimals", 9372036854775807L, 1, true, "9.37Q");
	    TestGraduatedValue("Large No More Grad", 9223372036854775807L, 0, true, "9223Q");

	    TestGraduatedValue("No Premature Grad", 999, 0, false, "999");
	}

    public static String GraduatedValue(Long value, int decimalPlaces, boolean addDecimalForSingleDigit)
    { String[] suffix = new String[]{"k","m","b","t"};
		    int size = (value != 0) ? (int) Math.log10(value) : 0;
		    if (size >= 3){
		        while (size % 3 != 0) {
		            size = size - 1;
		        }
		    }
		    double notation = Math.pow(10, size);
		    String result = "";
		    if(decimalPlaces==0) {
		    		if(addDecimalForSingleDigit) {
		    			result = (size >= 3) ? + (Math.round((value / notation) * 100) / 100.0d)+suffix[(size/3) - 1] : + value + "";   	
			    }
			    else {
			    		result = (size >= 3) ? + (Math.round((value / notation) * 100) / 100)+suffix[(size/3) - 1] : + value + "";
			    }
		    }
		    
		    	 
		    return result;
    } 
}
