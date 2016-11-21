package com.rahul.jaxb.app;

import com.rahul.jaxb.model.GreetingListType;
import com.rahul.jaxb.model.GreetingType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloUnmarshal {

    public static void main(String args[]) {
        try {
            JAXBContext context = JAXBContext.newInstance(GreetingListType.class);
            Unmarshaller um = context.createUnmarshaller();
            JAXBElement<GreetingListType> gr = null;
            try {
                gr = um.unmarshal(new StreamSource(new FileInputStream(new File("src/main/resources/hello.xml"))),GreetingListType.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            GreetingListType grList = gr.getValue();

            for(GreetingType grType: grList.getGreeting()){
                System.out.println(grType);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
