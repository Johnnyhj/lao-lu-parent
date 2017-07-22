<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.org/Webservice_zz/">
   <soapenv:Body>
      <web:CurrAcuReq>
         <ORG_ID>${ORG_ID}</ORG_ID>
         <PASSWORD>${PASSWORD}</PASSWORD>
         <AREA_CODE>${AREA_CODE}</AREA_CODE>
         <ACC_NBR>${ACC_NBR}</ACC_NBR>
         <CUR_DATE>${CUR_DATE}</CUR_DATE>
         <FAMILY_ID>2</FAMILY_ID>
         <GET_FLAG>0</GET_FLAG>
      </web:CurrAcuReq>
   </soapenv:Body>
</soapenv:Envelope>