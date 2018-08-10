package XML_2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyDOMParcer2 {

	public static void main(String[] args) {
		try{
			File xmlFile = new File (System.getProperty("user.dir")+"\\src\\XML_2\\sourceFile2.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("student");
			
			for (int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				System.out.print(nNode.getNodeName()+ " no = ");
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element student = (Element) nNode;
					System.out.println(student.getAttribute("no"));
					System.out.println("  Last Name = " + student.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("  First Name = " + student.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("  Birth Year = " + student.getElementsByTagName("birthYear").item(0).getTextContent());
					System.out.println("  Average Mark = " + student.getElementsByTagName("averageMark").item(0).getTextContent());
					System.out.println("  Contact Info\n    Address");
					Element contactInfo = (Element) student.getElementsByTagName("contactInfo").item(0);
					Element address = (Element) contactInfo.getElementsByTagName("address").item(0);
					System.out.println("      Country = " + address.getElementsByTagName("country").item(0).getTextContent());
					System.out.println("      City = " + address.getElementsByTagName("city").item(0).getTextContent());
					System.out.println("      Street = " + address.getElementsByTagName("street").item(0).getTextContent());
					
					Element mobilePhone = (Element) contactInfo.getElementsByTagName("mobilePhone").item(0);
					System.out.print("    Mobile phone");
					if (!mobilePhone.getAttribute("countryCod").isEmpty()) System.out.println(" Country code = " + mobilePhone.getAttribute("countryCod"));
					else System.out.println();
					System.out.println("      code = " + mobilePhone.getElementsByTagName("code").item(0).getTextContent());
					int count = mobilePhone.getElementsByTagName("number").getLength();
					for (int j=0;j<count;j++) System.out.println("      number = " + mobilePhone.getElementsByTagName("number").item(j).getTextContent());

					System.out.println("    Ground phone");
					Element groundPhone = (Element) contactInfo.getElementsByTagName("groundPhone").item(0);
					System.out.println("      code = " + groundPhone.getElementsByTagName("code").item(0).getTextContent());
					System.out.println("      number = " + groundPhone.getElementsByTagName("number").item(0).getTextContent());
					Element educProgramElement = (Element) student.getElementsByTagName("educProgram").item(0);
					System.out.print("  Educ Program = "+educProgramElement.getTextContent());
					System.out.println(", domain = " + educProgramElement.getAttribute("domain"));
					System.out.println();
				}
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
