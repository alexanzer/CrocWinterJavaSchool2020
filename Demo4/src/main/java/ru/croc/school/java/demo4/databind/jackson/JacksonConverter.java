package ru.croc.school.java.demo4.databind.jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.IOException;

public class JacksonConverter {

    public <T> T fromXml(String xml, Class<T> type) throws IOException {
        XmlMapper mapper = createXmlMapper();
        return mapper.readValue(xml, type);
    }

    public String toXml(Object obj) throws JsonProcessingException {
        XmlMapper mapper = createXmlMapper();
        return mapper.writeValueAsString(obj);
    }

    private XmlMapper createXmlMapper() {
        final XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }
}
