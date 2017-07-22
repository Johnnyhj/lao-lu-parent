<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>新增/修改角色</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="ecfn" uri="http://ec/tags/functions" %>
    <%@include file="/taglib.jsp" %>


    <link rel="stylesheet" href="${ctx}/asiaui/js/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css">

    <style>
        ul.ztree {
            margin-top: 10px;
            border: 1px solid #617775;
            background: #f0f6e4;
            width: 220px;
            height: 200px;
            overflow-y: scroll;
            overflow-x: auto;
        }
    </style>

</head>

<body>
    <div class="con-box">
        <div class="container-fluid">
            <div class="col-md-12" style="margin-top: 5px;">
                <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
            </div>

            <form:form method="post" commandName="role">
                <form:hidden path="id"/>
                <form:hidden path="available"/>

                <div class="row">

                    <div class="col-md-12">
                        <h5><label>角色名：</label></h5>
                        <div class="con-area">
                            <div class="form-group col-md-4 ">
                                <form:input class="form-control" path="role"/>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>


                    <div class="col-md-12">
                        <h5><label>角色描述：</label></h5>
                        <div class="con-area">
                            <div class="form-group col-md-6 ">
                                <form:input class="form-control" path="description"/>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <h5><label>拥有的资源列表：</label></h5>
                        <div class="con-area">
                            <div class="form-group col-md-5 " style="overflow: hidden">
                                <form:hidden path="resourceIds"/>
                                <div id="menuContent" class="menuContent">
                                    <ul id="tree" class="ztree" style="margin-top:0; width:300px; height: 450px;"></ul>
                                </div>
                            </div>
                            <div id="resourceIdsHidden"></div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>

                <div style="padding: 10px; text-align:center">
                    <form:button class="btn btn-sub">${op}</form:button>
                </div>

            </form:form>
        </div>
    </div>



    <script src="${ctx}/asiaui/js/jquery/jquery.ztree.all-3.5.min.js"></script>
    <script>
        $(function () {
            var setting = {
                check: {
                    enable: true ,
                    chkboxType: { "Y": "ps", "N": "ps" }
                },
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onCheck: onCheck,
                    onExpand: function (event, treeId, treeNode) {
                        $("#" + treeNode.tId + "_ul").removeClass("line");
                    }
                }
            };

            var zNodes =[
                <c:forEach items="${resourceList}" var="r">
                    <c:if test="${not r.rootNode}">
                        { id:${r.id}, pId:${r.parentId}, name:"${r.name}", checked:${ecfn:in(role.listResourceIds, r.id)}},
                    </c:if>
                </c:forEach>
            ];

            function onCheck(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getCheckedNodes(true),
                        id = "",
                        name = "";
//                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#resourceIds").val(id);
            }

            $.fn.zTree.init($("#tree"), setting, zNodes);

            if ('${op}' == '删除') {
                $("input").attr("readonly", "readonly");
                $("select").attr("disabled", "disabled");
                var treeObj = $.fn.zTree.getZTreeObj("tree");
                var nodes = treeObj.transformToArray(treeObj.getNodes());
                $.each(nodes, function(j, node){
                    treeObj.setChkDisabled(node, true);
                });
            }

        });
    </script>


</body>
</html>