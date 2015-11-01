package com.verizon.crawler;



import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class CrawlerHelper
{
    // We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;
    


    /**
     * This performs all the work. It makes an HTTP request, checks the response, and then gathers
     * up all the links on the page. Perform a searchForWord after the successful crawl
     * 
     * @param url
     *            - The URL to visit
     * @return whether or not the crawl was successful
     */
    public boolean crawl(String url)
    {
        try
        {
        	//System.out.println("The current URL is");
        	System.setProperty("http.proxyHost", "proxy.ebiz.verizon.com");
        	System.setProperty("http.proxyPort", "80"); 
        	//String authString = name + ":" + password;
			//System.out.println("auth string: " + authString);
			//byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			//String authStringEnc = new String(authEncBytes);
			//System.out.println("Base64 encoded auth string: " + authStringEnc);
			//URLConnection urlConnection = url.openConnection();
			//urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            //connection.
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            //System.out.println("The current URL is"+connection.response().statusCode());
            if(connection.response().statusCode() == 200) // 200 is the HTTP OK status code
                                                          // indicating that everything is great.
            {
               // System.out.println("\n**Visiting** Received web page at " + url);
            	
            	 System.out.println("\nAnalyzing the page " + url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            //System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href"));
                System.out.println(link.absUrl("href"));
            }
            
             linksOnPage = htmlDocument.select("form");
             
             for(Element link : linksOnPage)
             {
                 this.links.add(link.absUrl("action"));
                 System.out.println(link.absUrl("action"));
             }
             
              linksOnPage = htmlDocument.select("iframe");

              for(Element link : linksOnPage)
              {
                  this.links.add(link.absUrl("src"));
                  System.out.println(link.absUrl("src"));
              }
              linksOnPage = htmlDocument.select("script");

              for(Element link : linksOnPage)
              {
                  this.links.add(link.absUrl("window.location"));
                  System.out.println(link.absUrl("window.location"));
              }
             System.out.println("Found (" + this.links.size() + ") links");

            return true;
        }
        catch(IOException ioe)
        {
            // We were not successful in our HTTP request
        	
        	System.err.println("The exception is"+ioe.getMessage());
        	ioe.printStackTrace();
            return false;
        }
    }


    /**
     * Performs a search on the body of on the HTML document that is retrieved. This method should
     * only be called after a successful crawl.
     * 
     * @param searchWord
     *            - The word or string to look for
     * @return whether or not the word was found
     */
    public int searchForWord(String searchWord)
    {
        // Defensive coding. This method should only be used after a successful crawl.
        if(this.htmlDocument == null)
        {
            System.out.println("ERROR! Call crawl() before performing analysis on the document");
            return 0;
        }
        System.out.println("Searching for the word " + searchWord + "...");
        String bodyText = this.htmlDocument.body().text();
        //String str = "helloslkhellodjladfjhello";
        Pattern p = Pattern.compile(searchWord);
        Matcher m = p.matcher(bodyText);
        int count = 0;
        while (m.find()){
        	count +=1;
        }
        System.out.println(count);
        //bodyText.toLowerCase().
        //return bodyText.toLowerCase().contains(searchWord.toLowerCase());
        return count;   }


    public List<String> getLinks()
    {
        return this.links;
    }

}

