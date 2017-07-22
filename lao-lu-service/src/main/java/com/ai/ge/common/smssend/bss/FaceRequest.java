/**
 * FaceRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ai.ge.common.smssend.bss;

public class FaceRequest  implements java.io.Serializable {
    private String interfaceId;

    private String ipAddress;

    private String reqBizArgs;

    private String serialNumber;

    private String signature;

    private String timeStamp;

    private String version;

    public FaceRequest() {
    }

    public FaceRequest(
           String interfaceId,
           String ipAddress,
           String reqBizArgs,
           String serialNumber,
           String signature,
           String timeStamp,
           String version) {
           this.interfaceId = interfaceId;
           this.ipAddress = ipAddress;
           this.reqBizArgs = reqBizArgs;
           this.serialNumber = serialNumber;
           this.signature = signature;
           this.timeStamp = timeStamp;
           this.version = version;
    }


    /**
     * Gets the interfaceId value for this FaceRequest.
     *
     * @return interfaceId
     */
    public String getInterfaceId() {
        return interfaceId;
    }


    /**
     * Sets the interfaceId value for this FaceRequest.
     *
     * @param interfaceId
     */
    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }


    /**
     * Gets the ipAddress value for this FaceRequest.
     *
     * @return ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }


    /**
     * Sets the ipAddress value for this FaceRequest.
     *
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


    /**
     * Gets the reqBizArgs value for this FaceRequest.
     *
     * @return reqBizArgs
     */
    public String getReqBizArgs() {
        return reqBizArgs;
    }


    /**
     * Sets the reqBizArgs value for this FaceRequest.
     *
     * @param reqBizArgs
     */
    public void setReqBizArgs(String reqBizArgs) {
        this.reqBizArgs = reqBizArgs;
    }


    /**
     * Gets the serialNumber value for this FaceRequest.
     *
     * @return serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }


    /**
     * Sets the serialNumber value for this FaceRequest.
     *
     * @param serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    /**
     * Gets the signature value for this FaceRequest.
     *
     * @return signature
     */
    public String getSignature() {
        return signature;
    }


    /**
     * Sets the signature value for this FaceRequest.
     *
     * @param signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }


    /**
     * Gets the timeStamp value for this FaceRequest.
     *
     * @return timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this FaceRequest.
     *
     * @param timeStamp
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the version value for this FaceRequest.
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this FaceRequest.
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof FaceRequest)) return false;
        FaceRequest other = (FaceRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.interfaceId==null && other.getInterfaceId()==null) ||
             (this.interfaceId!=null &&
              this.interfaceId.equals(other.getInterfaceId()))) &&
            ((this.ipAddress==null && other.getIpAddress()==null) ||
             (this.ipAddress!=null &&
              this.ipAddress.equals(other.getIpAddress()))) &&
            ((this.reqBizArgs==null && other.getReqBizArgs()==null) ||
             (this.reqBizArgs!=null &&
              this.reqBizArgs.equals(other.getReqBizArgs()))) &&
            ((this.serialNumber==null && other.getSerialNumber()==null) ||
             (this.serialNumber!=null &&
              this.serialNumber.equals(other.getSerialNumber()))) &&
            ((this.signature==null && other.getSignature()==null) ||
             (this.signature!=null &&
              this.signature.equals(other.getSignature()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) ||
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            ((this.version==null && other.getVersion()==null) ||
             (this.version!=null &&
              this.version.equals(other.getVersion())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getInterfaceId() != null) {
            _hashCode += getInterfaceId().hashCode();
        }
        if (getIpAddress() != null) {
            _hashCode += getIpAddress().hashCode();
        }
        if (getReqBizArgs() != null) {
            _hashCode += getReqBizArgs().hashCode();
        }
        if (getSerialNumber() != null) {
            _hashCode += getSerialNumber().hashCode();
        }
        if (getSignature() != null) {
            _hashCode += getSignature().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FaceRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.em.transfar.com/", "faceRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interfaceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interfaceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ipAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqBizArgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqBizArgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serialNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serialNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signature");
        elemField.setXmlName(new javax.xml.namespace.QName("", "signature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeStamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
