{
    "fields": [
        "userUniqueId",
        "sessionId"
    ],
    "query": {
        "bool": {
            "must": [
                {
                    "match": {
                        "orderSeq": "${orderSeq}"
                    }
                }
            ]
        }
    }
}