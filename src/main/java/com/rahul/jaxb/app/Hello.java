package com.rahul.jaxb.app;

import com.rahul.jaxb.model.GreetingListType;
import com.rahul.jaxb.model.GreetingType;
import com.rahul.jaxb.model.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Hello {

    private ObjectFactory of;
    private GreetingListType grList;

    public Hello() {
        of = new ObjectFactory();
        grList = of.createGreetingListType();
    }

    public void make(String t, String l) {
        GreetingType g = of.createGreetingType();
        g.setText(t);
        g.setLanguage(l);
        grList.getGreeting().add(g);
    }

    public void marshal() {
        try {
            JAXBElement<GreetingListType> gl = of.createGreetings(grList);
            JAXBContext jc = JAXBContext.newInstance(GreetingListType.class);
            Marshaller m = jc.createMarshaller();
            m.marshal(gl, System.out);
        } catch (JAXBException jbe) {
            jbe.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Hello hello = new Hello();
        hello.make("Bonjour, madame", "fr");
        hello.make("Hey, you", "en");
        hello.marshal();
    }
}