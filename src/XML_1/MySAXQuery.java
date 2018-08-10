package XML_1;

import java.util.Scanner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MySAXQuery {

	public static void main(String[] args) {
		try{
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();
				
				System.out.println("Enter the student No you are interested in (1-3):");
				Scanner sc = new Scanner(System.in);
				String studentNo = sc.nextLine();
				sc.close();
				
				DefaultHandler handler = new DefaultHandler(){
					boolean lastName = false;
					boolean firstName = false;
					boolean birthYear = false;
					boolean averageMark = false;
					boolean address = false;
					boolean educProgram = false;
					String currentStudentNumber="";
					
					public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException{
						if (qName.equalsIgnoreCase("student")){
							currentStudentNumber = attributes.getValue("no");
						}
						if (qName.equalsIgnoreCase("student") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							System.out.println("Student no = " + attributes.getValue("no"));
						}
						if (qName.equalsIgnoreCase("lastName") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							lastName = true;
						}
						if (qName.equalsIgnoreCase("firstName") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							firstName = true;
						}
						if (qName.equalsIgnoreCase("birthYear") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							birthYear = true;
						}
						if (qName.equalsIgnoreCase("averageMark") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							averageMark = true;
						}
						if (qName.equalsIgnoreCase("address") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							address = true;
						}
						if (qName.equalsIgnoreCase("educProgram") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							educProgram = true;
							System.out.print("     " + attributes.getValue("domain") + " domain" );
						}
					
					} 
					
					public void endElement (String uri, String localName, String qName) throws SAXException{
					}
					
					public void characters(char ch[], int start, int length)throws SAXException{
						if (lastName){
							System.out.println("     Last Name: " + new String(ch,start,length));
							lastName = false;
						}
						if (firstName){
							System.out.println("     First Name: " + new String(ch,start,length));
							firstName = false;
						}
						if (birthYear){
							System.out.println("     Birth Year: " + new String(ch,start,length));
							birthYear = false;
						}
						if (averageMark){
							System.out.println("     Average Mark: " + new String(ch,start,length));
							averageMark = false;
						}
						if (address){
							System.out.println("     Address: " + new String(ch,start,length));
							address = false;
						}
						if (educProgram){
							System.out.println(", Educ Program: " + new String(ch,start,length));
							educProgram = false;
						}

					}
		
				};
				
				saxParser.parse(System.getProperty("user.dir")+"\\src\\XML_1\\sourceFile.xml",handler);
		}	
			catch(Exception e){
				e.printStackTrace();
			}

		}

}
