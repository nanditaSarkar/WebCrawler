package com.verizon.crawler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jsoup.select.Elements;

public class Webcrawler
{
  private static final int MAX_PAGES_TO_SEARCH = 10;
  private Set<String> pagesVisited = new HashSet<String>();
  private List<String> pagesToVisit = new LinkedList<String>();
  Elements linksOnPage=null;
  

  /**
   * Our main launching point for the Crawler's functionality. Internally it creates spider legs
   * that make an HTTP request and parse the response (the web page).
   * 
   * @param url
   *            - The starting point of the spider
   * @param searchWord
   *            - The word or string that you are searching for
   */
  //public void search(String url, String searchWord)
  public ArrayList search(String url, String searchWord)
  {
	  HashMap<String,String> res=new HashMap<String,String>();
	  int count=0;
	  ArrayList<CrawlerBean> details=new ArrayList<CrawlerBean>();
      while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
      {
          String currentUrl=null;
          CrawlerHelper helper = new CrawlerHelper();
          if(this.pagesToVisit.isEmpty())
          {
              currentUrl = url;
            System.out.println("The current URL is"+currentUrl);
              this.pagesVisited.add(url);
          }
          else
          {
              currentUrl = this.nextUrl();
          }
          
          helper.crawl(currentUrl); // Lots of stuff happening here. Look at the crawl method in
                                 // SpiderLeg
         ///boolean success = helper.searchForWord(searchWord);
          
          //String searchWordArray[]=searchWord.split(",");
          
         // int length=searchWordArray.length;
          
        //  for (int i=0;i<length;i++)
         // {
        	  CrawlerBean data=new CrawlerBean();
        	  
        	 
          count = helper.searchForWord(searchWord);
          data.setUrl(currentUrl);
          data.setWord(searchWord);
          data.setCount(Integer.toString(count));
          details.add(data);
      
          System.out.println("Monitor"+this.pagesToVisit.size());
          if(count > 0)
          {
              System.out.println(String.format("The  Word "+searchWord+"found at "+currentUrl));
              
              break;
              //this.pagesToVisit.addAll(helper.getLinks());
             //continue;
          }
          this.pagesToVisit.addAll(helper.getLinks());
          System.out.println("Monitor1"+this.pagesToVisit.size());
          
     // }
      }
      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
      return details;
  }


  /**
   * Returns the next URL to visit (in the order that they were found). We also do a check to make
   * sure this method doesn't return a URL that has already been visited.
   * 
   * @return
   */
  private String nextUrl()
  {
      String nextUrl;
    

     do
      {
    	  
        nextUrl = this.pagesToVisit.remove(0);
        
      } while(this.pagesVisited.contains(nextUrl));
      this.pagesVisited.add(nextUrl);
      return nextUrl;
  }
}
