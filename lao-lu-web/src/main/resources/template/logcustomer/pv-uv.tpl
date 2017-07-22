{
    "from": 0,
    "size": 0,
    "query": {
        "bool": {
            "must": [
                {
                    "range": {
                        "time": {
                            "gt": "${beginTime}",
                            "lt": "${endTime}"
                        }
                    }
                },
                {
                    "term": {
                        "channel": "${channel}"
                    }
                }
            ]
        }
    },
    "aggregations": {
        "userUniqueId": {
            "cardinality": {
                "field": "userUniqueId"
            }
        }
    }
}
<#-- 返回结果JSON -->
<#--
{
    "took": 7,
    "timed_out": false,
    "_shards": {
        "total": 5,
        "successful": 5,
        "failed": 0
    },
    "hits": {
        "total": 560,
        "max_score": 0,
        "hits": []
    },
    "aggregations": {
        "userUniqueId": {
            "value": 219
        }
    }
}
-->