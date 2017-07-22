<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:aut="http://authinfo.webservice.crm.bss.linkage.com">
   <soapenv:Header/>
   <soapenv:Body>
      <aut:createOrderForEC>
         <aut:orderListInfo>
			<![CDATA[ 
				<orderListInfo>
					<partyId>${partyId}</partyId>
					<offerSpecId>${offerSpecId}</offerSpecId>
					<custOrderId>${custOrderId}</custOrderId>
					<depCustOrderId>${depCustOrderId}</depCustOrderId>
					<accessNumber>${accessNumber}</accessNumber>
					<staffid>${staffid}</staffid>
					<channelId>${channelId}</channelId>
				</orderListInfo>
			]]>
		 </aut:orderListInfo>
         <aut:areaCode>${areaCode}</aut:areaCode>
      </aut:createOrderForEC>
   </soapenv:Body>
</soapenv:Envelope>