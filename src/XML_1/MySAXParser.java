package XML_1;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MySAXParser {

	public static void main(String[] args) {
		try{
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();
				
				DefaultHandler handler = new DefaultHandler(){
					boolean lastName = false;
					boolean firstName = false;
					boolean birthYear = false;
					boolean averageMark = false;
					boolean address = false;
					boolean educProgram = false;
					String indent = "";
					public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException{
						indent=indent + "     ";
						System.out.print(indent + "Start Element: " + qName);
						if (qName.equalsIgnoreCase("student")){
							System.out.print("no = " + attributes.getValue("no"));
						}
						
						if (qName.equalsIgnoreCase("lastName")){
							lastName = true;
						}
						if (qName.equalsIgnoreCase("firstName")){
							firstName = true;
						}
						if (qName.equalsIgnoreCase("birthYear")){
							birthYear = true;
						}
						if (qName.equalsIgnoreCase("averageMark")){
							averageMark = true;
						}
						if (qName.equalsIgnoreCase("address")){
							address = true;
						}
						if (qName.equalsIgnoreCase("educProgram")){
							educProgram = true;
							System.out.print(", " + attributes.getValue("domain") + " domain" );
						}
						System.out.println();
					} 
					
					public void endElement (String uri, String localName, String qName) throws SAXException{
						System.out.println(indent + "End element:" + qName);
						indent = indent.substring(0,indent.length()-5);
						if (qName.equalsIgnoreCase("student")){
							System.out.println();
						}
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
						if (address){
							System.out.println(indent + "     Address: " + new String(ch,start,length));
							address = false;
						}
						if (educProgram){
							System.out.println(indent + "     Educ Program: " + new String(ch,start,length));
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
