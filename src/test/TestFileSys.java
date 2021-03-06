package test;

import java.util.*;

import test.FileSys.CustomNode;

import java.lang.*;
import java.io.*;

class TestFileSys
{
    public static class CustomNode
    {
        public String Title;
        public CustomNode Parent;
        public ArrayList<CustomNode> Children;
        
        public CustomNode(String title, CustomNode parent)
        {
            Title = title;
            Parent = parent;
            Children = new ArrayList<CustomNode>();
            
            if(Parent!=null)
              Parent.Children.add(this);
        }
        
        public CustomNode Find(String path)
        {
            if (path.equals(Title))
                return this;

            String[] pieces = path.split("/");
    
	        for (CustomNode child : Children) {
                if (child.Title.equals(pieces[1]))
                    return child.Find(path.substring(Title.length() + 1));
            }
    
            return null;
        }
    }
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//Build a test tree (matches the example)
	    CustomNode root = new CustomNode("Root", null);
	    CustomNode userData = new CustomNode("UserData", root);
	    CustomNode ud_browser = new CustomNode("Browser", userData);
	    CustomNode ud_word = new CustomNode("Word", userData);
	    CustomNode priv = new CustomNode("Private", userData);
	    CustomNode priv_word = new CustomNode("Word", priv);
	    
	    CustomNode windows = new CustomNode("Windows", root);
	    CustomNode programs = new CustomNode("Programs", root);
	    CustomNode notepad = new CustomNode("Notepad", programs);
	    CustomNode prog_word = new CustomNode("Word", programs);
	    CustomNode prog_browser = new CustomNode("Browser", programs);

	    CustomNode custom1 = new CustomNode("Custom1", root);
	    CustomNode custom2 = new CustomNode("Custom2", custom1);
	    CustomNode custom3 = new CustomNode("Custom3", custom2);
	    
		RunTests(root, custom1, custom2, custom3);
	}
	
	public static void TestGetShortestUniqueQualifier(CustomNode root, String targetAbsPath, String expected)
    {
        String output;
        try {
            output = GetShortestUniqueQualifier(root, root.Find(targetAbsPath));
        } catch (Exception e) {
        	output = "exception";
        }
        
        if((output != null && output.equals(expected)) || (output == null && expected == null) || (expected==null && "".equals(output)))
          System.out.println("Succeeded for " + targetAbsPath);
        else
        	System.out.println("Failed for " + targetAbsPath + ": Failed with [" + output + "] rather than [" + expected + "]");
    }

	public static void RunTests(CustomNode root, CustomNode custom1, CustomNode custom2, CustomNode custom3)
	{
	    //They are unique
	    TestGetShortestUniqueQualifier(root, "Root", "Root");
	    TestGetShortestUniqueQualifier(root, "Root/Programs", "Programs");
	    TestGetShortestUniqueQualifier(root, "Root/Programs/Notepad", "Notepad");
	    
	    //They have duplicate names
	    TestGetShortestUniqueQualifier(root, "Root/Programs/Browser", "Programs/Browser");
	    TestGetShortestUniqueQualifier(root, "Root/UserData/Browser", "UserData/Browser");

        //Root has a duplicate name
        custom1.Title = "a";
        custom2.Title = "b";
        custom3.Title = "Root";
	    TestGetShortestUniqueQualifier(root, "Root/a/b/Root", "b/Root");

        //Edge cases
        custom1.Title = "Root";
        custom2.Title = "b";
        custom3.Title = "c";
	    TestGetShortestUniqueQualifier(root, "Root/Root", "Root/Root");

        custom1.Title = "a";
        custom2.Title = "a";
        custom3.Title = "a";
	    TestGetShortestUniqueQualifier(root, "Root/a", "Root/a");
	    TestGetShortestUniqueQualifier(root, "Root/a/a", "Root/a/a");
        TestGetShortestUniqueQualifier(root, "Root/a/a/a", "a/a/a");

        custom1.Title = "Root";
        custom2.Title = "UserData";
        custom3.Title = "Word";
	    TestGetShortestUniqueQualifier(root, "Root/Root/UserData/Word", "Root/Root/UserData/Word");

	    TestGetShortestUniqueQualifier(root, "Root", "/Root");
	    TestGetShortestUniqueQualifier(root, "Root/UserData/Word", "/Root/UserData/Word");
	}

	public static String GetShortestUniqueQualifier(CustomNode root, CustomNode target)
	{
	    //return target.Title;
		ArrayList<String> pathArr = new ArrayList<String>();
		pathArr=allPaths(root,pathArr);
		return getUnique(pathArr, root,target);
	}
	public static String path ="";
	
	public static ArrayList<String> allPaths(CustomNode root, ArrayList<String> pathArr ) {
		if(root == null) {
			return pathArr;
		}
		if(root.Children.isEmpty()) {
			return pathArr;	
		}else {
			for(CustomNode child : root.Children) {
			
				path = path+child.Title+"/";
				pathArr.add(path);
				allPaths(child,pathArr);
				//path="";
			}
		}
		path="";
		return pathArr;	
	}
	
	public static String getUnique(ArrayList<String> pathArr, CustomNode root,CustomNode target) {
		String answer="";
		for(int i=0;i<pathArr.size();i++) {
			pathArr.set(i, root.Title+"/"+pathArr.get(i));
		}
		for(String check:pathArr) {
			if(check.endsWith(target.Title+"/")) {
				answer=check;
			}
		}
		return answer;
	}
}

