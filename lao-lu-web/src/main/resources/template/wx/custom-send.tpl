{
    "touser":"${openId}",
    "msgtype":"${msgtype}",
    <#if msgtype == "text">
    "text":
    {
        "content":"${content}"
    }
    <#elseif msgtype == "news">
    "news":{
            "articles": [
             {
                 "title":"${title?default("")}",
                 "description":"${description?default("")}",
                 "url":"${url?default("")}",
                 "picurl":"${picurl?default("")}"
             }
             ]
        }
    </#if>
}