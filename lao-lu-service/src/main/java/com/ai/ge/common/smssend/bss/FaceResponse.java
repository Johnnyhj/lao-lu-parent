/**
 * FaceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ai.ge.common.smssend.bss;

public class FaceResponse  implements java.io.Serializable {
    private String description;

    private String interfaceId;

    private String resBizArgs;

    private String result;

    private String serialNumber;

    private String signature;

    private String timeStamp;

    private String version;

    public FaceResponse() {
    }

    public FaceResponse(
           String description,
           String interfaceId,
           String resBizArgs,
           String result,
           String serialNumber,
           String signature,
           String timeStamp,
           String version) {
           this.description = description;
           this.interfaceId = interfaceId;
           this.resBizArgs = resBizArgs;
           this.result = result;
           this.serialNumber = serialNumber;
           this.signature = signature;
           this.timeStamp = timeStamp;
           this.version = version;
    }


    /**
     * Gets the description value for this FaceResponse.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this FaceResponse.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets the interfaceId value for this FaceResponse.
     *
     * @return interfaceId
     */
    public String getInterfaceId() {
        return interfaceId;
    }


    /**
     * Sets the interfaceId value for this FaceResponse.
     *
     * @param interfaceId
     */
    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }


    /**
     * Gets the resBizArgs value for this FaceResponse.
     *
     * @return resBizArgs
     */
    public String getResBizArgs() {
        return resBizArgs;
    }


    /**
     * Sets the resBizArgs value for this FaceResponse.
     *
     * @param resBizArgs
     */
    public void setResBizArgs(String resBizArgs) {
        this.resBizArgs = resBizArgs;
    }


    /**
     * Gets the result value for this FaceResponse.
     *
     * @return result
     */
    public String getResult() {
        return result;
    }


    /**
     * Sets the result value for this FaceResponse.
     *
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }


    /**
     * Gets the serialNumber value for this FaceResponse.
     *
     * @return serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }


    /**
     * Sets the serialNumber value for this FaceResponse.
     *
     * @param serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    /**
     * Gets the signature value for this FaceResponse.
     *
     * @return signature
     */
    public String getSignature() {
        return signature;
    }


    /**
     * Sets the signature value for this FaceResponse.
     *
     * @param signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }


    /**
     * Gets the timeStamp value for this FaceResponse.
     *
     * @return timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this FaceResponse.
     *
     * @param timeStamp
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the version value for this FaceResponse.
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this FaceResponse.
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof FaceResponse)) return false;
        FaceResponse other = (FaceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.description==null && other.getDescription()==null) ||
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.interfaceId==null && other.getInterfaceId()==null) ||
             (this.interfaceId!=null &&
              this.interfaceId.equals(other.getInterfaceId()))) &&
            ((this.resBizArgs==null && other.getResBizArgs()==null) ||
             (this.resBizArgs!=null &&
              this.resBizArgs.equals(other.getResBizArgs()))) &&
            ((this.result==null && other.getResult()==null) ||
             (this.result!=null &&
              this.result.equals(other.getResult()))) &&
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getInterfaceId() != null) {
            _hashCode += getInterfaceId().hashCode();
        }
        if (getResBizArgs() != null) {
            _hashCode += getResBizArgs().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
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
        new org.apache.axis.description.TypeDesc(FaceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.em.transfar.com/", "faceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interfaceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interfaceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resBizArgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resBizArgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "result"));
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
