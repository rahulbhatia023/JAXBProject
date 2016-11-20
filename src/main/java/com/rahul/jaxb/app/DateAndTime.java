package com.rahul.jaxb.app;

import com.rahul.jaxb.model.dateAndTime.DateTimeType;
import com.rahul.jaxb.model.dateAndTime.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateAndTime {

    public static void main(String args[]) throws DatatypeConfigurationException, JAXBException {
        ObjectFactory of = new ObjectFactory();
        DateTimeType meta = of.createDateTimeType();
        GregorianCalendar now = new GregorianCalendar();

        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar gcDate =
                df.newXMLGregorianCalendarDate(
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH),
                        DatatypeConstants.FIELD_UNDEFINED);

        XMLGregorianCalendar gcTime =
                df.newXMLGregorianCalendarTime(
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        now.get(Calendar.SECOND),
                        null,
                        DatatypeConstants.FIELD_UNDEFINED);

        meta.setDate(gcDate);
        meta.setTime(gcTime);

        JAXBElement<DateTimeType> gl = of.createDateTime(meta);
        JAXBContext jc = JAXBContext.newInstance(DateTimeType.class);
        Marshaller m = jc.createMarshaller();
        m.marshal(gl, System.out);
    }
}
