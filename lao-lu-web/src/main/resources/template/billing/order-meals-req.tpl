<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:web="http://www.example.org/Webservice_zz/" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
       <web:ORDER_MEALSReq>
          <REMOTE_SOURCE>${REMOTE_SOURCE}</REMOTE_SOURCE>
          <REMOTE_PASSWD>${REMOTE_PASSWD}</REMOTE_PASSWD>
          <OBJ_ACC_NBR>${OBJ_ACC_NBR}</OBJ_ACC_NBR>
          <ORDER_TYPE>${ORDER_TYPE}</ORDER_TYPE>
          <FAMILY_ID>2</FAMILY_ID>
       </web:ORDER_MEALSReq>
    </soapenv:Body>
</soapenv:Envelope>