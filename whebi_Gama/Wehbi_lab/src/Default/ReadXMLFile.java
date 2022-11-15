package Default;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
public class ReadXMLFile {


	  
	public static void main(String argv[]) {
	    try {

	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true);
	        DocumentBuilder dBuilder = factory.newDocumentBuilder();
	        Document  doc = factory.newDocumentBuilder().parse(new URL("https://www.ynet.co.il/Integration/StoryRss2.xml").openStream(),"UTF-8");

	    doc.getDocumentElement().normalize();
 
	   // System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
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
	      //  System.out.println("\nCurrent Element :" + nNode.getNodeName());
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
//	            System.out.println("news Title  : "
//	                               + eElement.getAttribute("title"));
	            
	            //------------------------
//	            System.out.println("News title  : "
//	                               + eElement.getElementsByTagName("title")
//	                                 .item(0).getTextContent());
//	            
//	            System.out.println("description : "
//	                               + eElement.getElementsByTagName("description")
//	                                 .item(0).getTextContent());
	            //---------------------------
	           
	          
	            htmlString += "<tr> <td > <div dir=\"rtl\">" ;
	             htmlString +="  "
                         + eElement.getElementsByTagName("description")
                         .item(0).getTextContent();
	             htmlString +=" <br> </td>  <td> "
                         + eElement.getElementsByTagName("title")
                         .item(0).getTextContent(); 
	             htmlString+="</div> </td> </tr>" ; 
//	            System.out.println("Nick Name : "
//	                               + eElement.getElementsByTagName("nickname")
//	                                 .item(0).getTextContent());
//	            System.out.println("Salary : "
//	                               + eElement.getElementsByTagName("salary")
//	                                 .item(0).getTextContent());
	        }
	    } // end for loop 
	   
 // 
	    htmlString+= "</table>" ; 
	    String title = "New Page";
	    String body = "This is Body";
	    htmlString = htmlString.replace("$title", title);
	    htmlString = htmlString.replace("$body", body);
	    File newHtmlFile = new File("path/new.html"); 
	    FileUtils.writeStringToFile(newHtmlFile, htmlString);
	    
	    } catch (Exception e) {
	    e.printStackTrace();
	    }
	  }
}
