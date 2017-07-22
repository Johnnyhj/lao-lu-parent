<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8" />
    <title>订单列表</title>
    <%@include file="/taglib.jsp"%>

</head>

<body >
<!-- ↓头部搜索 -->
<form id="frm" class="form-horizontal row">
	<div class="wrapper-md">
    <div class="col-xs-12 form-inline">
            <div class="form-group">
                    <button type="button" intervalDay="1" class="btn btn-info">最近1日</button>
                    <button type="button" intervalDay="3" class="btn btn-info">最近3日</button>
                    <button type="button" intervalDay="7" class="btn btn-info">最近7日</button>
                    <button type="button" intervalDay="30" class="btn btn-info">最近1月</button>
                    <button type="button" intervalDay="90" class="btn btn-info">最近3月</button>
            </div>
	    		<div class="form-group" style="margin-left: 20px;">
	    			<select id="unit" name="unit" class="form-control">
				    <option value="1">按小时</option>
				    <option value="2">按天</option>
			    </select>
	    		</div>
    </div>

    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div class="col-xs-12 panel m-t-md">
        <div id="main" style="height:400px; padding-top: 15px;"></div>
    </div>
    </div>
</form>






</body>

<script src="${ctx}/asiaui/js/echarts-2.2.7/echarts-all.js"></script>
<script type="text/javascript">
    var pageName = '${param.pageName}';
    var legendData = [], xAxisData = [];

    $(function () {
        $(':button').click(function () {

            var $this = $(this);
            var intervalDay = $this.attr('intervalDay');


            // 基于准备好的dom，初始化echarts图表
            var myChart = echarts.init(document.getElementById('main'));

            $.post('${ctx}/mgr/report/baseData?intervalDay=' + intervalDay, {
                pageName : pageName,
                unit : $('#unit').val()
            }, function (respJson) {
                var object = respJson.object;

                if ('pv_uv' == pageName) {
                    legendData = ['PV', 'UV'];
                    xAxisData = object.pv.createDate;
                } else if ('buy_out' == pageName) {
                    legendData = ['转化率%', '跳出率%'];
                    xAxisData = object.buy.createDate;
                }

                var option = {
                    title: {
                        text: '用户行为分析',
                        subtext: ''
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: legendData
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            /*dataView: {show: true, readOnly: false},*/
                            magicType: {show: true, type: ['line', 'bar']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    xAxis: [
                        {
                            type: 'category',
                            boundaryGap: false,
                            data: xAxisData
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }
                    ],
                    series: [
                        <c:choose>
                            <c:when test="${'pv_uv' eq param.pageName}">

                                {
                                    name: 'PV',
                                    type: 'line',
                                    data: object.pv.data,
                                    markPoint: {
                                        data: [
                                            {type: 'max', name: '最大值'},
                                            {type: 'min', name: '最小值'}
                                        ]
                                    },
                                    markLine: {
                                        data: [
                                            {type: 'average', name: '平均值'}
                                        ]
                                    }
                                },
                                {
                                    name: 'UV',
                                    type: 'line',
                                    data: object.uv.data,
                                    markPoint: {
                                        data: [
                                            {type: 'max', name: '最大值'},
                                            {type: 'min', name: '最小值'}
                                        ]
                                    },
                                    markLine: {
                                        data: [
                                            {type: 'average', name: '平均值'}
                                        ]
                                    }
                                }
                            </c:when>
                            <c:when test="${'buy_out' eq param.pageName}">
                                {
                                    name: '转化率%',
                                    type: 'line',
                                    data: object.buy.data,
                                    markPoint: {
                                        data: [
                                            {type: 'max', name: '最大值'},
                                            {type: 'min', name: '最小值'}
                                        ]
                                    },
                                    markLine: {
                                        data: [
                                            {type: 'average', name: '平均值'}
                                        ]
                                    }
                                },
                                {
                                    name: '跳出率%',
                                    type: 'line',
                                    data: object.out.data,
                                    markPoint: {
                                        data: [
                                            {type: 'max', name: '最大值'},
                                            {type: 'min', name: '最小值'}
                                        ]
                                    },
                                    markLine: {
                                        data: [
                                            {type: 'average', name: '平均值'}
                                        ]
                                    }
                                }

                            </c:when>
                        </c:choose>
                    ]
                };

                // 为echarts对象加载数据
                myChart.setOption(option);
            }, 'json');
        });


    });




</script>
</html>

