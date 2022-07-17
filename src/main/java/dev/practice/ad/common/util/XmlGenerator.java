package dev.practice.ad.common.util;

import dev.practice.ad.domain.api.AdInitInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlGenerator {
    public static String marshalObjectToXml(AdInitInfo adInitInfo) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AdInitInfo.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter st = new StringWriter();
        marshaller.marshal(adInitInfo, st);
        return st.toString();
    }
}
