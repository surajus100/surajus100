package readFile;


import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

import org.junit.Test;



public class TestCases {
	static Document doc;
	File fXmlFile = new File("Books.xml");
     
@Test
public void testCaseToValidateNodeName() throws ParserConfigurationException, SAXException, IOException{
	
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
     doc = dBuilder.parse(fXmlFile); 

     doc.getDocumentElement().normalize(); 

	 assertEquals("catalog", doc.getDocumentElement().getNodeName());
}

@Test
public void testCaseToValidationAuthorName() throws ParserConfigurationException, SAXException, IOException{
	
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
     doc = dBuilder.parse(fXmlFile); 

     doc.getDocumentElement().normalize(); 
     NodeList nList = doc.getElementsByTagName("book");
     String name ="Gambardella, Matthew";
   assertEquals(name, ((Element) nList.item(0)).getElementsByTagName("author").item(0).getTextContent());  ;
     
}

@Test
public void testCaseToValidatePrice() throws ParserConfigurationException, SAXException, IOException{
	
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
     doc = dBuilder.parse(fXmlFile); 

     doc.getDocumentElement().normalize(); 
     NodeList nList = doc.getElementsByTagName("book");
     
   assertEquals(44, ((Element) nList.item(0)).getElementsByTagName("price").item(0).getTextContent());  ;
     
}

}
