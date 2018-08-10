package XML_1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyDOMParcer {

	public static void main(String[] args) {
		try{
			File xmlFile = new File (System.getProperty("user.dir")+"\\src\\XML_1\\sourceFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("student");
			
			for (int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				System.out.print("\nCurrent element: "+nNode.getNodeName()+ " no = ");
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					System.out.println(eElement.getAttribute("no"));
					System.out.println("Last Name = "+eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("First Name = "+eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Birth Year = "+eElement.getElementsByTagName("birthYear").item(0).getTextContent());
					System.out.println("Average Mark = "+eElement.getElementsByTagName("averageMark").item(0).getTextContent());
					System.out.println("Address = "+eElement.getElementsByTagName("address").item(0).getTextContent());
					
					Element educProgramElement = (Element) eElement.getElementsByTagName("educProgram").item(0);
					System.out.print("Educ Program = "+educProgramElement.getTextContent());
					System.out.println(", domain = " + educProgramElement.getAttribute("domain"));
				}
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
