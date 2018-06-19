
package com.pcm.ws.jws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SendVehiclePassResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sendVehiclePassResult"
})
@XmlRootElement(name = "SendVehiclePassResponse")
public class SendVehiclePassResponse {

    @XmlElement(name = "SendVehiclePassResult")
    protected String sendVehiclePassResult;

    /**
     * Gets the value of the sendVehiclePassResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendVehiclePassResult() {
        return sendVehiclePassResult;
    }

    /**
     * Sets the value of the sendVehiclePassResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendVehiclePassResult(String value) {
        this.sendVehiclePassResult = value;
    }

}
