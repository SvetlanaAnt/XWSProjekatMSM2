//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.06 at 11:25:37 PM CEST 
//


package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter2
    extends XmlAdapter<String, Float>
{


    public Float unmarshal(String value) {
        return (services.app.carrequestservice.converter.TypeConverter.parseFloat(value));
    }

    public String marshal(Float value) {
        return (services.app.carrequestservice.converter.TypeConverter.printFloat(value));
    }

}
