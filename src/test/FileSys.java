package test;
import java.util.*;
import java.lang.*;
import java.io.*;

class FileSys
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
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        
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

	    CustomNode custom1 = new CustomNode(console.readLine(), root);
	    CustomNode custom2 = new CustomNode(console.readLine(), custom1);
	    CustomNode custom3 = new CustomNode(console.readLine(), custom2);
	    CustomNode target = root.Find(console.readLine());
	    
		System.out.println(GetShortestUniqueQualifier(root, target));
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
