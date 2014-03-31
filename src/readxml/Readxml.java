/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readxml;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author hades
 */
public class Readxml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
 
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
 
	DefaultHandler handler = new DefaultHandler() {
 
	boolean bkota = false;
	boolean bcuaca = false;
	boolean bsmin = false;
	boolean bsmax = false;
        boolean bTanggal =false;
 
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
 
		//System.out.println("Start Element :" + qName);
                if (qName.equalsIgnoreCase("TANGGAL")) {
			bTanggal = true;
		}
		if (qName.equalsIgnoreCase("KOTA")) {
			bkota = true;
		}
 
		if (qName.equalsIgnoreCase("CUACA")) {
			bcuaca = true;
		}
 
		if (qName.equalsIgnoreCase("SUHUMIN")) {
			bsmin = true;
		}
 
		if (qName.equalsIgnoreCase("SUHUMAX")) {
			bsmax = true;
		}
 
	}
 
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
 
		//System.out.println("End Element :" + qName);
 
	}
 
	public void characters(char ch[], int start, int length) throws SAXException {
 
            
                if (bTanggal) {
			System.out.println("Tangga : " + new String(ch, start, length));
			bTanggal = false;
		}
		if (bkota) {
			System.out.println("Kota : " + new String(ch, start, length));
			bkota = false;
		}
 
		if (bcuaca) {
			System.out.println("Cuaca : " + new String(ch, start, length));
			bcuaca = false;
		}
 
		if (bsmin) {
			System.out.println("Suhu minimum : " + new String(ch, start, length));
			bsmin = false;
		}
 
		if (bsmax) {
			System.out.println("Suhu maksimum : " + new String(ch, start, length));
			bsmax = false;
		}
 
	}
 
     };
       String url ="http://data.bmkg.go.id/cuaca_indo_1.xml";
       saxParser.parse(url, handler);
 
     } catch (Exception e) {
       e.printStackTrace();
     }
 
        
    }
}
