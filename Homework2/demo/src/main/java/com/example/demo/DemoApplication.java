package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.net.URL;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		try {

	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true);
	        Document  doc = factory.newDocumentBuilder().parse(new URL("https://www.ynet.co.il/Integration/StoryRss2.xml").openStream(),"UTF-8");

	    doc.getDocumentElement().normalize();
 
	    NodeList nList = doc.getElementsByTagName("item");
	    System.out.println("----------------------------");
	    String htmlString= "Wehbi's Ynet News" ;
	    htmlString += " <table>\r\n"
	    		+ "	            <tr>\r\n"
	    		+ "	              <th>Description</th>\r\n"
	    		+ "	              <th>----------------</th>\r\n"
	    		+ "	              <th>Title</th>\r\n"
	    		+ "	            </tr>" ; 
	    for (int temp = 0; temp < nList.getLength(); temp++) {
	        Node nNode = nList.item(temp);
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
	            htmlString += "<tr> <td > <div dir=\"rtl\">" ;
	             htmlString +="  "
                         + eElement.getElementsByTagName("description")
                         .item(0).getTextContent();
	             htmlString +=" <br> </td>  <td> "
                         + eElement.getElementsByTagName("title")
                         .item(0).getTextContent(); 
	             htmlString+="</div> </td> </tr>" ; 
	        }
	    } 
	   
 // 
	    htmlString+= "</table>" ; 
	    String title = "New Page";
	    String body = "This is Body";
	    htmlString = htmlString.replace("$title", title);
	    htmlString = htmlString.replace("$body", body);
	    File newHtmlFile = new File("src/main/resources/static/index.html"); 
	    FileUtils.writeStringToFile(newHtmlFile, htmlString);
	    
	    } catch (Exception e) {
	    e.printStackTrace();
	    }
		SpringApplication.run(DemoApplication.class, args);
	}

}
