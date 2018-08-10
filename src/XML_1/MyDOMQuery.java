package XML_1;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyDOMQuery {

	public static void main(String[] args) {
		try{
			File xmlFile = new File (System.getProperty("user.dir")+"\\src\\XML_1\\sourceFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Enter the student No you are interested in (1-3):");
			Scanner sc = new Scanner(System.in);
			String studentNo = sc.nextLine();
			
			NodeList nList = doc.getElementsByTagName("student");
			
			for (int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					if (eElement.getAttribute("no").equalsIgnoreCase(studentNo)){
						System.out.print(nNode.getNodeName()+ " no = ");
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
			sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
