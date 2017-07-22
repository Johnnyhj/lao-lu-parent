<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:aut="http://authinfo.webservice.crm.bss.linkage.com">
   <soapenv:Header/>
   <soapenv:Body>
      <aut:orderValidateForEC>
         <aut:validateInfo>
		 <![CDATA[
			<validateInfo>
				<orderTypeId>17</orderTypeId>
				<prodSpecId>379</prodSpecId>
				<accessNumber>${accessNumber}</accessNumber>
				<pricePlanPak>
				    <#list pricePlans as pricePlan>
                        <pricePlan>
                            <pricePlanCd>${pricePlan.pricePlanCd}</pricePlanCd>
                            <actionType>0</actionType>
                        </pricePlan>
					</#list>
				</pricePlanPak>
				<staffid>${staffid}</staffid>
				<channelId>${channelId}</channelId>
			</validateInfo>
		]]>
		</aut:validateInfo>
         <aut:areaCode>${areaCode}</aut:areaCode>
      </aut:orderValidateForEC>
   </soapenv:Body>
</soapenv:Envelope>