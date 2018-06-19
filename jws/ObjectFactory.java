
package com.pcm.ws.jws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pcm.ws.jws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pcm.ws.jws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendVehiclePass }
     * 
     */
    public SendVehiclePass createSendVehiclePass() {
        return new SendVehiclePass();
    }

    /**
     * Create an instance of {@link SendAlarmPass }
     * 
     */
    public SendAlarmPass createSendAlarmPass() {
        return new SendAlarmPass();
    }

    /**
     * Create an instance of {@link SendAlarmPassResponse }
     * 
     */
    public SendAlarmPassResponse createSendAlarmPassResponse() {
        return new SendAlarmPassResponse();
    }

    /**
     * Create an instance of {@link SendVehiclePassResponse }
     * 
     */
    public SendVehiclePassResponse createSendVehiclePassResponse() {
        return new SendVehiclePassResponse();
    }

}
