
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
 *         &lt;element name="KKMY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KKBH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDH" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HPHM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HPYS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HPZL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TGSK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CarmerIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLSD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="XSFX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TPLJ1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TPLJ2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TPLJ3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "kkmy",
    "kkbh",
    "cdh",
    "hphm",
    "hpys",
    "hpzl",
    "tgsk",
    "carmerIP",
    "clsd",
    "xsfx",
    "tplj1",
    "tplj2",
    "tplj3"
})
@XmlRootElement(name = "SendVehiclePass")
public class SendVehiclePass {

    @XmlElement(name = "KKMY")
    protected String kkmy;
    @XmlElement(name = "KKBH")
    protected String kkbh;
    @XmlElement(name = "CDH")
    protected int cdh;
    @XmlElement(name = "HPHM")
    protected String hphm;
    @XmlElement(name = "HPYS")
    protected String hpys;
    @XmlElement(name = "HPZL")
    protected String hpzl;
    @XmlElement(name = "TGSK")
    protected String tgsk;
    @XmlElement(name = "CarmerIP")
    protected String carmerIP;
    @XmlElement(name = "CLSD")
    protected int clsd;
    @XmlElement(name = "XSFX")
    protected String xsfx;
    @XmlElement(name = "TPLJ1")
    protected String tplj1;
    @XmlElement(name = "TPLJ2")
    protected String tplj2;
    @XmlElement(name = "TPLJ3")
    protected String tplj3;

    /**
     * Gets the value of the kkmy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKKMY() {
        return kkmy;
    }

    /**
     * Sets the value of the kkmy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKKMY(String value) {
        this.kkmy = value;
    }

    /**
     * Gets the value of the kkbh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKKBH() {
        return kkbh;
    }

    /**
     * Sets the value of the kkbh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKKBH(String value) {
        this.kkbh = value;
    }

    /**
     * Gets the value of the cdh property.
     * 
     */
    public int getCDH() {
        return cdh;
    }

    /**
     * Sets the value of the cdh property.
     * 
     */
    public void setCDH(int value) {
        this.cdh = value;
    }

    /**
     * Gets the value of the hphm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPHM() {
        return hphm;
    }

    /**
     * Sets the value of the hphm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPHM(String value) {
        this.hphm = value;
    }

    /**
     * Gets the value of the hpys property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPYS() {
        return hpys;
    }

    /**
     * Sets the value of the hpys property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPYS(String value) {
        this.hpys = value;
    }

    /**
     * Gets the value of the hpzl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPZL() {
        return hpzl;
    }

    /**
     * Sets the value of the hpzl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPZL(String value) {
        this.hpzl = value;
    }

    /**
     * Gets the value of the tgsk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTGSK() {
        return tgsk;
    }

    /**
     * Sets the value of the tgsk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTGSK(String value) {
        this.tgsk = value;
    }

    /**
     * Gets the value of the carmerIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarmerIP() {
        return carmerIP;
    }

    /**
     * Sets the value of the carmerIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarmerIP(String value) {
        this.carmerIP = value;
    }

    /**
     * Gets the value of the clsd property.
     * 
     */
    public int getCLSD() {
        return clsd;
    }

    /**
     * Sets the value of the clsd property.
     * 
     */
    public void setCLSD(int value) {
        this.clsd = value;
    }

    /**
     * Gets the value of the xsfx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXSFX() {
        return xsfx;
    }

    /**
     * Sets the value of the xsfx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXSFX(String value) {
        this.xsfx = value;
    }

    /**
     * Gets the value of the tplj1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPLJ1() {
        return tplj1;
    }

    /**
     * Sets the value of the tplj1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPLJ1(String value) {
        this.tplj1 = value;
    }

    /**
     * Gets the value of the tplj2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPLJ2() {
        return tplj2;
    }

    /**
     * Sets the value of the tplj2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPLJ2(String value) {
        this.tplj2 = value;
    }

    /**
     * Gets the value of the tplj3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPLJ3() {
        return tplj3;
    }

    /**
     * Sets the value of the tplj3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPLJ3(String value) {
        this.tplj3 = value;
    }

}
