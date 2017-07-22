<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.org/Webservice_zz/">
   <soapenv:Body>
      <web:AREA_CODE_QReq>
         <ORG_ID>${ORG_ID}</ORG_ID>
         <PASSWORD>${PASSWORD}</PASSWORD>
         <QUERY_SERIAL>${QUERY_SERIAL}</QUERY_SERIAL>
         <ACC_NBR>${ACC_NBR}</ACC_NBR>
      </web:AREA_CODE_QReq>
   </soapenv:Body>
</soapenv:Envelope>