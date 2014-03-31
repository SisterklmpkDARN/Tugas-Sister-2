/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author hades
 */
public class ImplementasiCuaca extends UnicastRemoteObject implements CuacaInterfaces {
int nama;
    public ImplementasiCuaca(int i) throws RemoteException{
        this.nama = i;
    }

    public int getNamaClient(){
        return this.nama;
    }
    @Override
    public String cekCuacaDunia(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cekCuacaHarian(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cekCuacaIndo(String url) throws RemoteException {
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
       
       saxParser.parse(url, handler);
 
     } catch (Exception e) {
       e.printStackTrace();
     }
        return ("Message sent");
    }

    @Override
    public String cekCuacaJabodetabek(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cekCuacaWisata(String url) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
