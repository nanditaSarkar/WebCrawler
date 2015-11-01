package com.verizon.crawler;

public class MaskAlgorithm {
	
	public static String encrypt(String inputText)
	{
		byte [] bytes = null;
		String result = "";
		String text  = "";
		String trailer = "";
		String trailerLength = "0";
		long code = 0;
		int base = 37;
		int exp = 0;
		
		if(inputText.length()>9)
		{
		 trailerLength = ""+(inputText.length()-9);
		trailer = inputText.substring(9);
		text = inputText.substring(0,9);
		}
		else{
		text = inputText; 
		}

		bytes = text.toUpperCase().getBytes();
		for (int i = 0;i<bytes.length;i++)
		{
			exp = bytes.length-i-1;

			if(bytes[i]>=48 && bytes[i]<=57)
				bytes[i] -= 48;
			else
				bytes[i] -= 55;	

			code += Math.pow(base,exp)*bytes[i];
		}
	code = code*base + bytes.length;

	result = trailerLength+code+trailer;
	result=result.substring(0,10);
	
	System.out.println(text+="hashcode()="+text.hashCode()+"= ; code ="+result);
 	return result;
	}

}
