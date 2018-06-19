
package com.pcm.ws.jws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "JupiterServiceSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface JupiterServiceSoap {


    /**
     * 
     * @param tplj2
     * @param carmerIP
     * @param tplj3
     * @param tgsk
     * @param clsd
     * @param xsfx
     * @param hpzl
     * @param hphm
     * @param kkmy
     * @param cdh
     * @param kkbh
     * @param tplj1
     * @param hpys
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "SendVehiclePass", action = "http://tempuri.org/SendVehiclePass")
    @WebResult(name = "SendVehiclePassResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SendVehiclePass", targetNamespace = "http://tempuri.org/", className = "com.pcm.ws.jws.SendVehiclePass")
    @ResponseWrapper(localName = "SendVehiclePassResponse", targetNamespace = "http://tempuri.org/", className = "com.pcm.ws.jws.SendVehiclePassResponse")
    public String sendVehiclePass(
        @WebParam(name = "KKMY", targetNamespace = "http://tempuri.org/")
        String kkmy,
        @WebParam(name = "KKBH", targetNamespace = "http://tempuri.org/")
        String kkbh,
        @WebParam(name = "CDH", targetNamespace = "http://tempuri.org/")
        int cdh,
        @WebParam(name = "HPHM", targetNamespace = "http://tempuri.org/")
        String hphm,
        @WebParam(name = "HPYS", targetNamespace = "http://tempuri.org/")
        String hpys,
        @WebParam(name = "HPZL", targetNamespace = "http://tempuri.org/")
        String hpzl,
        @WebParam(name = "TGSK", targetNamespace = "http://tempuri.org/")
        String tgsk,
        @WebParam(name = "CarmerIP", targetNamespace = "http://tempuri.org/")
        String carmerIP,
        @WebParam(name = "CLSD", targetNamespace = "http://tempuri.org/")
        int clsd,
        @WebParam(name = "XSFX", targetNamespace = "http://tempuri.org/")
        String xsfx,
        @WebParam(name = "TPLJ1", targetNamespace = "http://tempuri.org/")
        String tplj1,
        @WebParam(name = "TPLJ2", targetNamespace = "http://tempuri.org/")
        String tplj2,
        @WebParam(name = "TPLJ3", targetNamespace = "http://tempuri.org/")
        String tplj3);

    /**
     * 
     * @param tgsk
     * @param carPic
     * @param hphm
     * @param kkmy
     * @param kkbh
     * @param hpys
     * @param wfdm
     * @param carmerIP
     * @param clsd
     * @param tplx
     * @param hpzl
     * @param xsfx
     * @param cdh
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "SendAlarmPass", action = "http://tempuri.org/SendAlarmPass")
    @WebResult(name = "SendAlarmPassResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SendAlarmPass", targetNamespace = "http://tempuri.org/", className = "com.pcm.ws.jws.SendAlarmPass")
    @ResponseWrapper(localName = "SendAlarmPassResponse", targetNamespace = "http://tempuri.org/", className = "com.pcm.ws.jws.SendAlarmPassResponse")
    public String sendAlarmPass(
        @WebParam(name = "KKMY", targetNamespace = "http://tempuri.org/")
        String kkmy,
        @WebParam(name = "KKBH", targetNamespace = "http://tempuri.org/")
        String kkbh,
        @WebParam(name = "CDH", targetNamespace = "http://tempuri.org/")
        int cdh,
        @WebParam(name = "TGSK", targetNamespace = "http://tempuri.org/")
        String tgsk,
        @WebParam(name = "HPHM", targetNamespace = "http://tempuri.org/")
        String hphm,
        @WebParam(name = "HPYS", targetNamespace = "http://tempuri.org/")
        String hpys,
        @WebParam(name = "HPZL", targetNamespace = "http://tempuri.org/")
        String hpzl,
        @WebParam(name = "WFDM", targetNamespace = "http://tempuri.org/")
        String wfdm,
        @WebParam(name = "CarmerIP", targetNamespace = "http://tempuri.org/")
        String carmerIP,
        @WebParam(name = "CLSD", targetNamespace = "http://tempuri.org/")
        int clsd,
        @WebParam(name = "XSFX", targetNamespace = "http://tempuri.org/")
        String xsfx,
        @WebParam(name = "CarPic", targetNamespace = "http://tempuri.org/")
        String carPic,
        @WebParam(name = "TPLX", targetNamespace = "http://tempuri.org/")
        String tplx);

}
