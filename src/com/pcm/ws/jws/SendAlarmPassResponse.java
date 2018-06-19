
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
 *         &lt;element name="SendAlarmPassResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sendAlarmPassResult"
})
@XmlRootElement(name = "SendAlarmPassResponse")
public class SendAlarmPassResponse {

    @XmlElement(name = "SendAlarmPassResult")
    protected String sendAlarmPassResult;

    /**
     * Gets the value of the sendAlarmPassResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendAlarmPassResult() {
        return sendAlarmPassResult;
    }

    /**
     * Sets the value of the sendAlarmPassResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendAlarmPassResult(String value) {
        this.sendAlarmPassResult = value;
    }

}
