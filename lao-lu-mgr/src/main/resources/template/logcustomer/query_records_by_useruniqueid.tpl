<#--
{
    "query": {
        "match": {
            "userUniqueId": "${userUniqueId}"
        }
    },
    "sort": {
        "time": {
            "order": "asc"
        }
    }
}
-->

{
    "query": {
        "bool": {
            "must": [
                {
                    "term": {
                        "userUniqueId": "${userUniqueId}"
                    }
                }
                <#if sessionId??>
                ,{
                    "term": {
                        "sessionId": "${sessionId}"
                    }
                }
                </#if>
            ]
        }
    },
    "from":0,
    "size":1000,
    "sort": {
        "time": {
            "order": "asc"
        }
    }
}

<#--查询返回JSON-->
<#--
{
    "took": 94,
    "timed_out": false,
    "_shards": {
        "total": 10,
        "successful": 10,
        "failed": 0
    },
    "hits": {
        "total": 2,
        "max_score": null,
        "hits": [
            {
                "_index": "logstash_2016.06.27",
                "_type": "logs",
                "_id": "AVWPfL9I6f-jmkHTZLZK",
                "_score": null,
                "_source": {
                    "mm": 32,
                    "pageName": "购买成功",
                    "areaCode": "0518",
                    "userUniqueId": "2c3c1548f8544f27",
                    "hh": 9,
                    "date": "20160627",
                    "customerOperationId": 105625,
                    "requestUrl": "http://sxpc.example.com:8080/flow-market-web/app/page/html/error/success.html?s=2016062709324282498305",
                    "city": "",
                    "country": "本机地址",
                    "ip": "127.0.0.1",
                    "orderSeq": "2016062709324282498305",
                    "phoneNum": "17751697264",
                    "time": "20160627093246",
                    "sessionId": "c756320ffadb905d",
                    "province": "本机地址",
                    "ss": 46,
                    "devices": "iPhone",
                    "channel": "sxpc",
                    "requestReferer": "http://sxpc.example.com:8080/flow-market-web/app/page/html/detail.html?1=1&prodCode=f495b6ab9dcf8d3b",
                    "@version": "1",
                    "@timestamp": "2016-06-27T01:32:47.144Z",
                    "path": "D:/src/monitor.log",
                    "host": "sxpc"
                },
                "sort": [
                    "20160627093246"
                ]
            },
            {
                "_index": "logstash_2016.06.27",
                "_type": "logs",
                "_id": "AVWPfNbR6f-jmkHTZLZL",
                "_score": null,
                "_source": {
                    "mm": 32,
                    "pageName": "流量超市",
                    "areaCode": "0518",
                    "userUniqueId": "2c3c1548f8544f27",
                    "hh": 9,
                    "date": "20160627",
                    "customerOperationId": 105626,
                    "requestUrl": "http://sxpc.example.com:8080/flow-market-web/app/index.html",
                    "city": "",
                    "country": "本机地址",
                    "ip": "127.0.0.1",
                    "phoneNum": "17751697264",
                    "time": "20160627093252",
                    "sessionId": "c756320ffadb905d",
                    "province": "本机地址",
                    "ss": 52,
                    "devices": "iPhone",
                    "channel": "sxpc",
                    "requestReferer": "http://sxpc.example.com:8080/flow-market-web/app/page/html/error/success.html?s=2016062709324282498305",
                    "@version": "1",
                    "@timestamp": "2016-06-27T01:32:53.170Z",
                    "path": "D:/src/monitor.log",
                    "host": "sxpc"
                },
                "sort": [
                    "20160627093252"
                ]
            }
        ]
    }
}
-->