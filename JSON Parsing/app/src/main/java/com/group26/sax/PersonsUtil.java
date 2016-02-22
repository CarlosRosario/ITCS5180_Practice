package com.group26.sax;

import android.app.ProgressDialog;
import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crosario on 2/22/2016.
 */
public class PersonsUtil {

    static public class PersonsJSONParser {

        static ArrayList<Person> parsePersons(String in) throws JSONException{
            ArrayList<Person> personsList = new ArrayList<Person>();

            JSONObject root = new JSONObject(in);
            JSONArray personsJSONArray = root.getJSONArray("persons");

            for(int i = 0; i < personsJSONArray.length(); i++) {
                JSONObject personsJSONObject = personsJSONArray.getJSONObject(i);
                Person person = Person.createPerson(personsJSONObject);

//                person.setName(personsJSONObject.getString("name"));
//                person.setId(personsJSONObject.getInt("id"));
//                person.setDepartment(personsJSONObject.getString("department"));
//                person.setAge(personsJSONObject.getInt("age"));
                personsList.add(person);
            }
            return personsList;
        }

    }

    static public class PersonsPullParser {
        //using pull parser
//        static ArrayList<Person> parsePersons(InputStream in) throws IOException, XmlPullParserException{
//
//            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
//            parser.setInput(in, "UTF-8");
//            Person person = null;
//            ArrayList<Person> personsList = new ArrayList<Person>();
//
//            int event = parser.getEventType();
//
//            while(event != XmlPullParser.END_DOCUMENT){
//
//                switch(event){
//                    case XmlPullParser.START_TAG:
//                        if(parser.getName().equals("person")){
//                            person = new Person();
//                            person.setId(parser.getAttributeValue(null, "id"));
//                        } else if(parser.getName().equals("name")){
//                            person.setName(parser.nextText().trim());
//                        } else if(parser.getName().equals("age")){
//                            person.setAge(parser.nextText().trim());
//                        } else if(parser.getName().equals("department")){
//                            person.setDepartment(parser.nextText().trim());
//                        }
//
//                        break;
//                    case XmlPullParser.END_TAG:
//                        if(parser.getName().equals("person")){
//                            personsList.add(person);
//                            person = null;
//                        }
//
//                        break;
//
//                    default:
//
//                        break;
//                }
//
//                event = parser.next();
//            }
//            return personsList;
//        }
//    }


    }


        // using SAX
//    static public class PersonsSAXParser extends DefaultHandler {
//
//        public ArrayList<Person> getPersonsList() {
//            return personsList;
//        }
//
//        public void setPersonsList(ArrayList<Person> personsList) {
//            this.personsList = personsList;
//        }
//
//        ArrayList<Person> personsList;
//        Person person;
//        StringBuilder xmlInnerText;
//
//        static public ArrayList<Person> parsePerson(InputStream in){
//
//
//            PersonsSAXParser parser = new PersonsSAXParser();
//
//            try {
//                Xml.parse(in, Xml.Encoding.UTF_8, parser);
//                return parser.getPersonsList();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (SAXException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//
//        }
//
//        @Override
//        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//            super.startElement(uri, localName, qName, attributes);
//
//            if(localName.equals("person")){
//                person = new Person();
//                person.setId(attributes.getValue("id"));
//            }
//
//        }
//
//        @Override
//        public void startDocument() throws SAXException {
//            super.startDocument();
//            xmlInnerText = new StringBuilder();
//            personsList = new ArrayList<Person>();
//        }
//
//        @Override
//        public void endElement(String uri, String localName, String qName) throws SAXException {
//            super.endElement(uri, localName, qName);
//
//            if(localName.equals("person")){
//                personsList.add(person);
//            } else if(localName.equals("name")){
//                person.setName(xmlInnerText.toString().trim());
//            } else if(localName.equals("age")){
//                person.setAge(xmlInnerText.toString().trim());
//            } else if (localName.equals("department")){
//                person.setDepartment(xmlInnerText.toString().trim());
//            }
//            xmlInnerText.setLength(0); // flush buffer
//        }
//
//        @Override
//        public void characters(char[] ch, int start, int length) throws SAXException {
//            super.characters(ch, start, length);
//            xmlInnerText.append(ch, start, length);
//        }
//    }
}
