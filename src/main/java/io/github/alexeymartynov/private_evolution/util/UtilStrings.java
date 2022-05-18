package io.github.alexeymartynov.private_evolution.util;

public class UtilStrings {
	
	public static String getStringWithoutColor(String string) 
	{
		if(string.contains("§"))
		{
			char[] chars = string.toCharArray();
			for(int i = 0; i < chars.length; i++) 
			{
				if(chars[i] != '§') continue;
				
				chars[i + 1] = '$';
				chars[i] = '$';
				
				i = 0;
			}
			
			return new String(chars).replace("$", "");
		}
		
		return string;
	}
	
	public static String getStringColor(String string) 
	{
		String color = "§r";
		if(string.contains("§"))
		{
			color = "";
			char[] chars = string.toCharArray();
			for(int i = 0; i < chars.length; i++) 
			{
				if(chars[i] != '§') continue;
							
				color = "" + chars[i] + chars[i + 1];
			}
		}
		
		return color;
	}
}
