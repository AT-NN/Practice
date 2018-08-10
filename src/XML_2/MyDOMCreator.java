package XML_2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MyDOMCreator {

	public static void main(String[] args) {
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			Element rootElement = doc.createElement("students");
			doc.appendChild(rootElement);
			
			//first student
			Element student = doc.createElement("student");
			rootElement.appendChild(student);
			Attr attribute = doc.createAttribute("no");
			attribute.setValue("1");
			student.setAttributeNode(attribute);
			
			Element lastName = doc.createElement("lastName");
			lastName.appendChild(doc.createTextNode("Ivanov"));
			student.appendChild(lastName);
			
			Element firstName = doc.createElement("firstName");
			firstName.appendChild(doc.createTextNode("Ivan"));
			student.appendChild(firstName);

			Element birthYear = doc.createElement("birthYear");
			birthYear.appendChild(doc.createTextNode("1981"));
			student.appendChild(birthYear);
			
			Element averageMark = doc.createElement("averageMark");
			averageMark.appendChild(doc.createTextNode("8.1"));
			student.appendChild(averageMark);
			
			Element contactInfo = doc.createElement("contactInfo");
			student.appendChild(contactInfo);
			
			Element address = doc.createElement("address");
			contactInfo.appendChild(address);
			
			Element country = doc.createElement("country");
			country.appendChild(doc.createTextNode("Moldova"));
			address.appendChild(country);
	
			Element city = doc.createElement("city");
			city.appendChild(doc.createTextNode("Chisinau"));
			address.appendChild(city);

			Element street = doc.createElement("street");
			street.appendChild(doc.createTextNode("Tighina 1"));
			address.appendChild(street);

			Element mobilePhone = doc.createElement("mobilePhone");
			contactInfo.appendChild(mobilePhone);
			
			Element code = doc.createElement("code");
			code.appendChild(doc.createTextNode("373"));
			mobilePhone.appendChild(code);
			
			Element number = doc.createElement("number");
			number.appendChild(doc.createTextNode("1234567891"));
			mobilePhone.appendChild(number);
			
			Element groundPhone = doc.createElement("groundPhone");
			contactInfo.appendChild(groundPhone);
			
			code = doc.createElement("code");
			code.appendChild(doc.createTextNode("373"));
			groundPhone.appendChild(code);
			
			number = doc.createElement("number");
			number.appendChild(doc.createTextNode("9876543211"));
			groundPhone.appendChild(number);
			
			Element educProgram = doc.createElement("educProgram");
			attribute = doc.createAttribute("domain");
			attribute.setValue("IT");
			educProgram.setAttributeNode(attribute);
			educProgram.appendChild(doc.createTextNode("Software Developer"));
			student.appendChild(educProgram);
			
			//second student
			student = doc.createElement("student");
			rootElement.appendChild(student);
			attribute = doc.createAttribute("no");
			attribute.setValue("2");
			student.setAttributeNode(attribute);
			
			lastName = doc.createElement("lastName");
			lastName.appendChild(doc.createTextNode("Petrov"));
			student.appendChild(lastName);
			
			firstName = doc.createElement("firstName");
			firstName.appendChild(doc.createTextNode("Petr"));
			student.appendChild(firstName);

			birthYear = doc.createElement("birthYear");
			birthYear.appendChild(doc.createTextNode("1982"));
			student.appendChild(birthYear);
			
			averageMark = doc.createElement("averageMark");
			averageMark.appendChild(doc.createTextNode("8.2"));
			student.appendChild(averageMark);
			
			contactInfo = doc.createElement("contactInfo");
			student.appendChild(contactInfo);
			
			address = doc.createElement("address");
			contactInfo.appendChild(address);
			
			country = doc.createElement("country");
			country.appendChild(doc.createTextNode("Moldova"));
			address.appendChild(country);
	
			city = doc.createElement("city");
			city.appendChild(doc.createTextNode("Chisinau"));
			address.appendChild(city);

			street = doc.createElement("street");
			street.appendChild(doc.createTextNode("Tighina 2"));
			address.appendChild(street);

			mobilePhone = doc.createElement("mobilePhone");
			contactInfo.appendChild(mobilePhone);
			
			code = doc.createElement("code");
			code.appendChild(doc.createTextNode("373"));
			mobilePhone.appendChild(code);
			
			number = doc.createElement("number");
			number.appendChild(doc.createTextNode("1234567892"));
			mobilePhone.appendChild(number);
			
			groundPhone = doc.createElement("groundPhone");
			contactInfo.appendChild(groundPhone);
			
			code = doc.createElement("code");
			code.appendChild(doc.createTextNode("373"));
			groundPhone.appendChild(code);
			
			number = doc.createElement("number");
			number.appendChild(doc.createTextNode("9876543212"));
			groundPhone.appendChild(number);
			
			educProgram = doc.createElement("educProgram");
			attribute = doc.createAttribute("domain");
			attribute.setValue("IT");
			educProgram.setAttributeNode(attribute);
			educProgram.appendChild(doc.createTextNode("QA Engineer"));
			student.appendChild(educProgram);
			
			//write to file
			TransformerFactory trFactory = 	TransformerFactory.newInstance();
			Transformer tr = trFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+"\\src\\XML_2\\outputFile.xml"));
			tr.transform(source,result);
			
			//write to console
			StreamResult consoleResult = new StreamResult(System.out);
			tr.transform(source,consoleResult);			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
