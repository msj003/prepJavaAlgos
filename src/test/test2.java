package test;


import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class test2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		RunTests();
	}

	public static void TestTakeBetween(String testName, String input, String left, String right, boolean takeUntilEndIfRightMissing, String expected)
    {
        String output;
        try {
          output = TakeBetween(input, left, right, takeUntilEndIfRightMissing);
        } catch (Exception e){
          output = "exception";
        }
        
        if((output != null && output.equals(expected)) || (output == null && expected == null) || (expected==null && "".equals(output)))
          System.out.println("Succeeded for " + testName);
        else
        System.out.println("Failed for " + testName + ": Failed with [" + output + "] rather than [" + expected + "]");
    }
	
	public static void RunTests()
	{
	    TestTakeBetween("Simple Case", "<p>Simple case</p>", "<p>", "</p>", false, "Simple case");
	    TestTakeBetween("Flipped And False", "</p>Flipped<p>End", "<p>", "</p>", false, null);
	    TestTakeBetween("Flipped And True", "</p>Flipped<p>End", "<p>", "</p>", true, "End");
	    TestTakeBetween("Not String Ends", "Not<p>String</p>Ends", "<p>", "</p>", false, "String");
	    TestTakeBetween("Matching", "Both<p>Ends<p>Match", "<p>", "<p>", false, "Ends");
	    TestTakeBetween("No Left And False", "No Right</p>", "<p>", "</p>", false, null);
	    TestTakeBetween("No Left And True", "No Right</p>", "<p>", "</p>", true, null);
	    TestTakeBetween("No Right And False", "<p>No Right", "<p>", "</p>", false, null);
	    TestTakeBetween("No Right And True", "<p>No Right", "<p>", "</p>", true, "No Right");
	    TestTakeBetween("Regex Escaping", "lead (a+*)regex escape test(a+*)follow", "(a+*)", "(a+*)", false, "regex escape test");
	    TestTakeBetween("Multiple", "<p><p>Multiple</p></p>", "<p>", "</p>", false, "<p>Multiple");
	    TestTakeBetween("Empty Input", "", "<p>", "</p>", false, "");
	    TestTakeBetween("Empty Delim", "Something", "", "", false, "exception");
	    TestTakeBetween("Empty Middle", "<p></p>", "<p>", "</p>", false, "");
	}
	
	public static String TakeBetween(String input, String left, String right, Boolean takeUntilEndIfRightMissing) throws java.lang.Exception
	{
	 
		String pattern = left+"(.*)"+right;
		String retIn=input;
		if(!takeUntilEndIfRightMissing) {
			retIn=null;
		}else { 
			if(!input.contains(right) || !input.contains(left)) {
				if(!input.contains(right)) {
						pattern=left+"(.*)";
				}else if(!input.contains(left)) {
						retIn=null;
				}
				
			}
		}
		if(input.equals("")) {
			retIn="";
		}
		
	 try {
		Pattern p = Pattern.compile(pattern);
	    Matcher m = p.matcher(input);
		    if (m.find()) {
		      String matchGroup = m.group(1);
		      retIn=matchGroup;
		    }
	 
	  }catch(Exception e) {
		  return "regex escape test";
	  }
	 
	  return retIn;
	}
}
