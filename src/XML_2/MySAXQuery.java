package XML_2;

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
					boolean educProgram = false;
					boolean country = false;
					boolean city = false;
					boolean street = false;
					boolean code = false;
					boolean number = false;
					String currentStudentNumber="";
					
					String indent = "";
					public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException{
						indent=indent + "     ";
						if (qName.equalsIgnoreCase("student")){
							currentStudentNumber = attributes.getValue("no");
						}
						if (currentStudentNumber.equalsIgnoreCase(studentNo)) System.out.print(indent + "Start Element: " + qName);
						if (qName.equalsIgnoreCase("student") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							System.out.print(" no = " + attributes.getValue("no"));
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
						if (qName.equalsIgnoreCase("country") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							country = true;
						}
						if (qName.equalsIgnoreCase("city") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							city = true;
						}
						if (qName.equalsIgnoreCase("street") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							street = true;
						}
						if (qName.equalsIgnoreCase("code") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							code = true;
						}
						if (qName.equalsIgnoreCase("number") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							number = true;
						}
						if (qName.equalsIgnoreCase("educProgram") && currentStudentNumber.equalsIgnoreCase(studentNo)){
							educProgram = true;
							System.out.print(", " + attributes.getValue("domain") + " domain" );
						}
						if (currentStudentNumber.equalsIgnoreCase(studentNo)) System.out.println();
					} 
					
					public void endElement (String uri, String localName, String qName) throws SAXException{
						if (currentStudentNumber.equalsIgnoreCase(studentNo)) System.out.println(indent + "End element:" + qName);
						indent = indent.substring(0,indent.length()-5);
					}
					
					public void characters(char ch[], int start, int length)throws SAXException{
						if (lastName){
							System.out.println(indent + "     Last Name: " + new String(ch,start,length));
							lastName = false;
						}
						if (firstName){
							System.out.println(indent + "     First Name: " + new String(ch,start,length));
							firstName = false;
						}
						if (birthYear){
							System.out.println(indent + "     Birth Year: " + new String(ch,start,length));
							birthYear = false;
						}
						if (averageMark){
							System.out.println(indent + "     Average Mark: " + new String(ch,start,length));
							averageMark = false;
						}
						if (country){
							System.out.println(indent + "     Country: " + new String(ch,start,length));
							country = false;
						}
						if (city){
							System.out.println(indent + "     City: " + new String(ch,start,length));
							city = false;
						}
						if (street){
							System.out.println(indent + "     Street: " + new String(ch,start,length));
							street = false;
						}
						if (code){
							System.out.println(indent + "     Code: " + new String(ch,start,length));
							code = false;
						}
						if (number){
							System.out.println(indent + "     Number: " + new String(ch,start,length));
							number = false;
						}
						if (educProgram){
							System.out.println(indent + "     Educ Program: " + new String(ch,start,length));
							educProgram = false;
						}

					}
		
				};
				
				saxParser.parse(System.getProperty("user.dir")+"\\src\\XML_2\\sourceFile.xml",handler);
		}	
			catch(Exception e){
				e.printStackTrace();
			}

		}

}
