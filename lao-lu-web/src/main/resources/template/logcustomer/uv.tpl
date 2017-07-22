{
    "fields": [
        "channel",
        "userUniqueId"
    ],
    "query": {
        "filtered": {
            "query": {
                "query_string": {
                    "query": "*"
                }
            },
            "filter": {
                "bool": {
                    "must": {
                        "range": {
                            "time": {
                                "gt": "${beginTime}",
                                "lt": "${endTime}"
                            }
                        }
                    }
                }
            }
        }
    },
    "aggs": {
        "channel": {
            "terms": {
                "field": "channel"
            },
            "aggs": {
                "userUniqueId": {
                    "terms": {
                        "field": "userUniqueId"
                    }
                }
            }
        }
    }
}
<#-- 返回结果JSON -->
<#--
    {
        "took": 20,
        "timed_out": false,
        "_shards": {
            "total": 15,
            "successful": 15,
            "failed": 0
        },
        "hits": {
            "total": 6,
            "max_score": 1,
            "hits": [
                {
                    "_index": "logstash_2016.04.21",
                    "_type": "logs",
                    "_id": "AVQ2XYqMhRbGLFDnlnVm",
                    "_score": 1,
                    "fields": {
                        "userUniqueId": [
                            "21ec0fb35d1ed188"
                        ],
                        "channel": [
                            "-10012"
                        ]
                    }
                },
                {
                    "_index": "logstash_2016.04.21",
                    "_type": "logs",
                    "_id": "AVQ2gjeWhRbGLFDnlnVt",
                    "_score": 1,
                    "fields": {
                        "userUniqueId": [
                            "21ec0fb35d1ed189"
                        ],
                        "channel": [
                            "-10013"
                        ]
                    }
                },
                {
                    "_index": "logstash_2016.04.21",
                    "_type": "logs",
                    "_id": "AVQ2XYqMhRbGLFDnlnVl",
                    "_score": 1,
                    "fields": {
                        "userUniqueId": [
                            "21ec0fb35d1ed188"
                        ],
                        "channel": [
                            "-10012"
                        ]
                    }
                },
                {
                    "_index": "logstash_2016.04.21",
                    "_type": "logs",
                    "_id": "AVQ2XcqchRbGLFDnlnVn",
                    "_score": 1,
                    "fields": {
                        "userUniqueId": [
                            "21ec0fb35d1ed188"
                        ],
                        "channel": [
                            "-10013"
                        ]
                    }
                },
                {
                    "_index": "logstash_2016.04.21",
                    "_type": "logs",
                    "_id": "AVQ2gjeWhRbGLFDnlnVu",
                    "_score": 1,
                    "fields": {
                        "userUniqueId": [
                            "21ec0fb35d1ed179"
                        ],
                        "channel": [
                            "-10013"
                        ]
                    }
                },
                {
                    "_index": "logstash_2016.04.21",
                    "_type": "logs",
                    "_id": "AVQ2g0yrhRbGLFDnlnVv",
                    "_score": 1,
                    "fields": {
                        "userUniqueId": [
                            "21ec0fb35d1ed179"
                        ],
                        "channel": [
                            "sxpc"
                        ]
                    }
                }
            ]
        },
        "aggregations": {
            "channel": {
                "doc_count_error_upper_bound": 0,
                "sum_other_doc_count": 0,
                "buckets": [
                    {
                        "key": "10013",
                        "doc_count": 3,
                        "userUniqueId": {
                            "doc_count_error_upper_bound": 0,
                            "sum_other_doc_count": 0,
                            "buckets": [
                                {
                                    "key": "21ec0fb35d1ed179",
                                    "doc_count": 1
                                },
                                {
                                    "key": "21ec0fb35d1ed188",
                                    "doc_count": 1
                                },
                                {
                                    "key": "21ec0fb35d1ed189",
                                    "doc_count": 1
                                }
                            ]
                        }
                    },
                    {
                        "key": "10012",
                        "doc_count": 2,
                        "userUniqueId": {
                            "doc_count_error_upper_bound": 0,
                            "sum_other_doc_count": 0,
                            "buckets": [
                                {
                                    "key": "21ec0fb35d1ed188",
                                    "doc_count": 2
                                }
                            ]
                        }
                    },
                    {
                        "key": "sxpc",
                        "doc_count": 1,
                        "userUniqueId": {
                            "doc_count_error_upper_bound": 0,
                            "sum_other_doc_count": 0,
                            "buckets": [
                                {
                                    "key": "21ec0fb35d1ed179",
                                    "doc_count": 1
                                }
                            ]
                        }
                    }
                ]
            }
        }
    }
-->


