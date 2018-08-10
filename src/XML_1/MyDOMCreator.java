package XML_1;

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
			
			Element address = doc.createElement("address");
			address.appendChild(doc.createTextNode("bd. Stefan cel Mare si Sfant 65"));
			student.appendChild(address);
			
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
			
			address = doc.createElement("address");
			address.appendChild(doc.createTextNode("bd. Stefan cel Mare si Sfant 65"));
			student.appendChild(address);
			
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
			StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+"\\src\\XML_1\\outputFile.xml"));
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
