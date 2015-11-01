package com.verizon.crawler;

import java.util.ArrayList;
import java.util.HashMap;


public class CrawlerTest
{

   //public static void main(String[] args)
public ArrayList crawl (String url,String searchWord)
   {
	//String[] searchWordArray=searchWord.split(",");
	ArrayList result=new ArrayList();
	//for(int i=0;i<searchWordArray.length;i++)
		//	{
	//	ArrayList individualresult=null;
	if(url.equalsIgnoreCase("http://www.customerportal.verizon.com"))
		url="http://localhost:8081/WebCrawler/welcome.jsp";
      Webcrawler spider = new Webcrawler();
      //spider.search("http://localhost:8081/WebCrawler/welcome.jsp", "LOGIN");
      
      ///result= spider.search("http://localhost:8081/WebCrawler/welcome.jsp", "SSN");
      result= spider.search(url, searchWord);
     // if(individualresult!=null)
    	//  result.add(individualresult);
			//}
      
      return result;
    }
	
}




 
  


/*import java.io.BufferedReader; 



 
import java.io.IOException; 


 
import java.io.InputStreamReader; 


 
import java.net.HttpURLConnection; 


 
import java.net.MalformedURLException; 


 
import java.net.URL; 


 
  



public class CrawlerTest { 


 
  


 
    private static final String USER_AGENT = "Mozilla/5.0"; 
    
    
    


 
   //private static final String URL = "http://examples.javacodegeeks.com/core-java/io/bufferedreader/how-to-get-the-standard-input-in-java/";
    
    private static final String URL = "http://thuttu.com/join_group?action=publish&link=98920";


 
  

 
    public static void main(String[] args) { 


 
        try { 

System.getProperties().put("proxySet", "true");
System.getProperties().put("proxyPort", "80");
System.getProperties().put("proxyPort", "www.proxy.ebiz.verizon.com"); 
System.out.println(sendGetRequest(URL)); 


 
  


 
        } catch (MalformedURLException e) { 



            e.printStackTrace(); 


 
        } catch (IOException e) { 




            e.printStackTrace(); 



        } 


 
    } 




  


 
    public static String sendGetRequest(String urlString) throws IOException { 


 
  



System.setProperty("http.proxyHost", "proxy.ebiz.verizon.com");
System.setProperty("http.proxyPort", "80"); 
        URL obj = new URL(urlString); 
        
        //String encoded = new String
        	      //(Base64.base64Encode(new String("username:password").getBytes()));
        	//uc.setRequestProperty("Proxy-Authorization", "Basic " + encoded);



 
        HttpURLConnection httpConnection = (HttpURLConnection) obj 


 
                .openConnection(); 


 
  



 
        httpConnection.setRequestMethod("GET"); 


 
  


 
        httpConnection.setRequestProperty("User-Agent", USER_AGENT); 


 
  


 
        int responseCode = httpConnection.getResponseCode(); 




        if (responseCode == 200) { 

  


 
            BufferedReader responseReader = new BufferedReader(new InputStreamReader( 


 
                    httpConnection.getInputStream())); 



 
              



 
            String responseLine; 


 
            StringBuffer response = new StringBuffer(); 



 
  


 
            while ((responseLine = responseReader.readLine()) != null) { 


 
                response.append(responseLine+"\n"); 



            } 


            responseReader.close(); 


 
  


 
            // print result 


 
            return response.toString(); 




        }  
        return null; 


  


 
    } 


 
} 

*/