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
         try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bkota = false;
                boolean bcuaca = false;
                boolean bsmin = false;
                boolean bsmax = false;
                boolean bTanggal =false;

                public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
                    //System.out.println("Start Element :" + qName);
                    if (qName.equalsIgnoreCase("Tanggal")) {
                            bTanggal = true;
                    }
                    if (qName.equalsIgnoreCase("Kota")) {
                            bkota = true;
                    }

                    if (qName.equalsIgnoreCase("Cuaca")) {
                            bcuaca = true;
                    }

                    if (qName.equalsIgnoreCase("SuhuMin")) {
                            bsmin = true;
                    }

                    if (qName.equalsIgnoreCase("SuhuMax")) {
                            bsmax = true;
                    }
                }

                public void endElement(String uri, String localName,String qName) throws SAXException {
                    //System.out.println("End Element :" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bTanggal) {
                        System.out.println("Tanggal" + "\t\t: " + new String(ch, start, length));
                        bTanggal = false;
                    }
                    if (bkota) {
                        System.out.println("\nKota" + "\t\t: " + new String(ch, start, length));
                        bkota = false;
                    }
                    if (bcuaca) {
                        System.out.println("Cuaca" + "\t\t: " + new String(ch, start, length));
                        bcuaca = false;
                    }
                    if (bsmin) {
                        System.out.println("Suhu Min" + "\t: " + new String(ch, start, length));
                        bsmin = false;
                    }
                    if (bsmax) {
                        System.out.println("Suhu Max" + "\t: " + new String(ch, start, length));
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
    public String cekCuacaHarian(String url) throws RemoteException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bvalid = false;
                boolean bweather = false;
                boolean bwinddir = false;
                boolean bwindspd = false;
                boolean btemp = false;
                boolean bhumid = false;
                boolean bsunrise = false;
                boolean bsunset = false;
                boolean bmoonrise = false;
                boolean bmoonset = false;
                boolean bwavenc = false;
                boolean bwavesc = false;
                //boolean bDate = false;
                boolean bUpdate = false;
                boolean bJamUpdate = false;
                boolean bWarning = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    //System.out.println("Start Element :" + qName);
                    //if (qName.equalsIgnoreCase("Date")) {
                    //    bDate = true;
                    //}
                    if (qName.equalsIgnoreCase("Update")) {
                        bUpdate = true;
                    }
                    if (qName.equalsIgnoreCase("JamUpdate")) {
                        bJamUpdate = true;
                    }
                    if (qName.equalsIgnoreCase("Valid")) {
                        bvalid = true;
                    }
                    if (qName.equalsIgnoreCase("Weather")) {
                        bweather = true;
                    }
                    if (qName.equalsIgnoreCase("WindDirection")) {
                        bwinddir = true;
                    }
                    if (qName.equalsIgnoreCase("WindSpeed")) {
                        bwindspd = true;
                    }
                    if (qName.equalsIgnoreCase("Temperature")) {
                        btemp = true;
                    }
                    if (qName.equalsIgnoreCase("Humidity")) {
                        bhumid = true;
                    }
                    if (qName.equalsIgnoreCase("Sunrise")) {
                        bsunrise = true;
                    }
                    if (qName.equalsIgnoreCase("Sunset")) {
                        bsunset = true;
                    }
                    if (qName.equalsIgnoreCase("Moonrise")) {
                        bmoonrise = true;
                    }
                    if (qName.equalsIgnoreCase("Moonset")) {
                        bmoonset = true;
                    }
                    if (qName.equalsIgnoreCase("WaveHeightNortCoast")) {
                        bwavenc = true;
                    }
                    if (qName.equalsIgnoreCase("WaveHeightSouthCoast")) {
                        bwavesc = true;
                    }
                    if (qName.equalsIgnoreCase("Warning")) {
                        bWarning = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    //System.out.println("End Element :" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    //if (bDate) {
                    //    System.out.println("Date" + "\t\t\t: " + new String(ch, start, length));
                    //    bDate = false;
                    //}
                    if (bUpdate) {
                        System.out.println("Update" + "\t\t\t: " + new String(ch, start, length));
                        bUpdate = false;
                    }
                    if (bJamUpdate) {
                        System.out.println("Jam Update" + "\t\t: " + new String(ch, start, length));
                        bJamUpdate = false;
                    }
                    if (bvalid) {
                        System.out.println("\nValid" + "\t\t\t: " + new String(ch, start, length));
                        bvalid = false;
                    }
                    if (bweather) {
                        System.out.println("Weather" + "\t\t\t: "  + new String(ch, start, length));
                        bweather = false;
                    }
                    if (bwinddir) {
                        System.out.println("Wind Direction" + "\t\t: " + new String(ch, start, length));
                        bwinddir = false;
                    }
                    if (bwindspd) {
                        System.out.println("Wind Speed" + "\t\t: " + new String(ch, start, length));
                        bwindspd = false;
                    }
                    if (btemp) {
                        System.out.println("Temperature" + "\t\t: " + new String(ch, start, length));
                        btemp = false;
                    }
                    if (bhumid) {
                        System.out.println("Humidity" + "\t\t: " + new String(ch, start, length));
                        bhumid = false;
                    }
                    if (bsunrise) {
                        System.out.println("Sun Rise" + "\t\t: " + new String(ch, start, length));
                        bsunrise = false;
                    }
                    if (bsunset) {
                        System.out.println("Sun Set" + "\t\t\t: " + new String(ch, start, length));
                        bsunset = false;
                    }
                    if (bmoonrise) {
                        System.out.println("Moon Rise" + "\t\t: " + new String(ch, start, length));
                        bmoonrise = false;
                    }
                    if (bmoonset) {
                        System.out.println("Moon Set" + "\t\t: " + new String(ch, start, length));
                        bmoonset = false;
                    }
                    if (bwavenc) {
                        System.out.println("Wave Height North Coast" + "\t: " + new String(ch, start, length));
                        bwavenc = false;
                    }
                    if (bwavesc) {
                        System.out.println("Wave Height South Coast" + "\t: " + new String(ch, start, length));
                        bwavesc = false;
                    }
                    if (bWarning) {
                        System.out.println("Warning" + "\t\t\t: " + new String(ch, start, length));
                        bWarning = false;
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
    public String cekCuacaIndo(String url) throws RemoteException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bkota = false;
                boolean bcuaca = false;
                boolean bsmin = false;
                boolean bsmax = false;
                boolean bkmin = false;
                boolean bkmax = false;
                //boolean bTanggal =false;
                boolean bMulai = false;
                boolean bSampai = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    //System.out.println("Start Element :" + qName);
                    //if (qName.equalsIgnoreCase("Tanggal")) {
                    //    bTanggal = true;
                    //}
                    if (qName.equalsIgnoreCase("Mulai")) {
                        bMulai = true;
                    }
                    if (qName.equalsIgnoreCase("Sampai")) {
                        bSampai = true;
                    }
                    if (qName.equalsIgnoreCase("Kota")) {
                        bkota = true;
                    }
                    if (qName.equalsIgnoreCase("Cuaca")) {
                        bcuaca = true;
                    }
                    if (qName.equalsIgnoreCase("SuhuMin")) {
                        bsmin = true;
                    }
                    if (qName.equalsIgnoreCase("SuhuMax")) {
                        bsmax = true;
                    }
                    if (qName.equalsIgnoreCase("KelembapanMin")) {
                        bkmin = true;
                    }
                    if (qName.equalsIgnoreCase("KelembapanMax")) {
                        bkmax = true;
                    }

                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    //System.out.println("End Element :" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    //if (bTanggal) {
                    //    System.out.println("Tanggal" + "\t\t: " + new String(ch, start, length));
                    //    bTanggal = false;
                    //}
                    if (bMulai) {
                        System.out.println("Mulai" + "\t\t: " + new String(ch, start, length));
                        bMulai = false;
                    }
                    if (bSampai) {
                        System.out.println("Sampai" + "\t\t: " + new String(ch, start, length));
                        bSampai = false;
                    }
                    if (bkota) {
                        System.out.println("\nKota" + "\t\t: " + new String(ch, start, length));
                        bkota = false;
                    }
                    if (bcuaca) {
                        System.out.println("Cuaca" + "\t\t: " + new String(ch, start, length));
                        bcuaca = false;
                    }
                    if (bsmin) {
                        System.out.println("Suhu Min" + "\t: "  + new String(ch, start, length));
                        bsmin = false;
                    }
                    if (bsmax) {
                        System.out.println("Suhu Max" + "\t: " + new String(ch, start, length));
                        bsmax = false;
                    }
                    if (bkmin) {
                        System.out.println("Kelembapan Min" + "\t: " + new String(ch, start, length));
                        bkmin = false;
                    }
                    if (bkmax) {
                        System.out.println("Kelembapan Max" + "\t: " + new String(ch, start, length));
                        bkmax = false;
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
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bdaerah = false;
                boolean bpagi = false;
                boolean bsiang = false;
                boolean bmalam = false;
                boolean bTanggal =false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    //System.out.println("Start Element :" + qName);
                    if (qName.equalsIgnoreCase("Tanggal")) {
                        bTanggal = true;
                    }
                    if (qName.equalsIgnoreCase("Daerah")) {
                        bdaerah = true;
                    }
                    if (qName.equalsIgnoreCase("Pagi")) {
                        bpagi = true;
                    }
                    if (qName.equalsIgnoreCase("Siang")) {
                        bsiang = true;
                    }
                    if (qName.equalsIgnoreCase("Malam")) {
                        bmalam = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    //System.out.println("End Element :" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bTanggal) {
                        System.out.println("Tanggal" + "\t\t: " + new String(ch, start, length));
                        bTanggal = false;
                    }
                    if (bdaerah) {
                        System.out.println("\nDaerah" + "\t\t: " + new String(ch, start, length));
                        bdaerah = false;
                    }
                    if (bpagi) {
                        System.out.println("Pagi" + "\t\t: " + new String(ch, start, length));
                        bpagi = false;
                    }
                    if (bsiang) {
                        System.out.println("Siang" + "\t\t: "  + new String(ch, start, length));
                        bsiang = false;
                    }
                    if (bmalam) {
                        System.out.println("Malam" + "\t\t: " + new String(ch, start, length));
                        bmalam = false;
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
    public String cekCuacaWisata(String url) throws RemoteException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean barea = false;
                boolean bweather = false;
                boolean btemp = false;
                boolean bhumid = false;
                boolean bwave = false;
                //boolean bDate = false;
                boolean bValidStart = false;
                boolean bValidTimeStart = false;
                boolean bValidEnd = false;
                boolean bValidTimeEnd = false;
                boolean bBaliWeather = false;
                boolean bWindDir = false;
                boolean bWindSpd = false;
                boolean bSunRise = false;
                boolean bSunSet = false;
               
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    //System.out.println("Start Element :" + qName);
                    //if (qName.equalsIgnoreCase("Date")) {
                    //    bDate = true;
                    //}
                    if (qName.equalsIgnoreCase("ValidStart")) {
                        bValidStart = true;
                    }
                    if (qName.equalsIgnoreCase("ValidTimeStart")) {
                        bValidTimeStart = true;
                    }
                    if (qName.equalsIgnoreCase("ValidEnd")) {
                        bValidEnd = true;
                    }
                    if (qName.equalsIgnoreCase("Weather")) {
                        bweather = true;
                    }
                    if (qName.equalsIgnoreCase("BaliWeather")) {
                        bBaliWeather = true;
                    }
                    if (qName.equalsIgnoreCase("WindDirection")) {
                        bWindDir = true;
                    }
                    if (qName.equalsIgnoreCase("WindSpeed")) {
                        bWindSpd = true;
                    }
                    if (qName.equalsIgnoreCase("Sunrise")) {
                        bSunRise = true;
                    }
                    if (qName.equalsIgnoreCase("Sunset")) {
                        bSunSet = true;
                    }                    
                    if (qName.equalsIgnoreCase("Area")) {
                        barea = true;
                    }
                    if (qName.equalsIgnoreCase("Weather")) {
                        bweather = true;
                    }
                    if (qName.equalsIgnoreCase("Temperature")) {
                        btemp = true;
                    }
                    if (qName.equalsIgnoreCase("Humidity")) {
                        bhumid = true;
                    }
                    if (qName.equalsIgnoreCase("WaveHeight")) {
                        bwave = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    //System.out.println("End Element :" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    //if (bDate) {
                    //    System.out.println("Date" + "\t\t\t: " + new String(ch, start, length));
                    //    bDate = false;
                    //}
                    if (bValidStart) {
                        System.out.println("Valid Start" + "\t\t: " + new String(ch, start, length));
                        bValidStart = false;
                    }
                    if (bValidTimeStart) {
                        System.out.println("Valid Time Start" + "\t: " + new String(ch, start, length));
                        bValidTimeStart = false;
                    }
                    if (bValidEnd) {
                        System.out.println("Valid End" + "\t\t: " + new String(ch, start, length));
                        bValidEnd = false;
                    }
                    if (bValidTimeEnd) {
                        System.out.println("Valid Time End" + "\t: " + new String(ch, start, length));
                        bValidTimeEnd = false;
                    }
                    if (bBaliWeather) {
                        System.out.println("Bali Weather" + "\t\t: "  + new String(ch, start, length));
                        bBaliWeather = false;
                    }
                    if (bWindDir) {
                        System.out.println("Wind Direction" + "\t\t: " + new String(ch, start, length));
                        bWindDir = false;
                    }
                    if (bWindSpd) {
                        System.out.println("Wind Speed" + "\t\t: " + new String(ch, start, length));
                        bWindSpd = false;
                    }
                    if (bSunRise) {
                        System.out.println("Sun Rise" + "\t\t: " + new String(ch, start, length));
                        bSunRise = false;
                    }
                    if (bSunSet) {
                        System.out.println("Sun Set" + "\t\t\t: " + new String(ch, start, length));
                        bSunSet = false;
                    }
                    if (barea) {
                        System.out.println("\nArea" + "\t\t\t: "  + new String(ch, start, length));
                        barea = false;
                    }                    
                    if (bweather) {
                        System.out.println("Weather" + "\t\t\t: "  + new String(ch, start, length));
                        bweather = false;
                    }
                    if (btemp) {
                        System.out.println("Temperature" + "\t\t: " + new String(ch, start, length));
                        btemp = false;
                    }
                    if (bhumid) {
                        System.out.println("Humidity" + "\t\t: " + new String(ch, start, length));
                        bhumid = false;
                    }
                    if (bwave) {
                        System.out.println("Wave Height" + "\t\t: " + new String(ch, start, length));
                        bwave = false;
                    }

                }
            };
            saxParser.parse(url, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ("Message sent");
    }
    
}
