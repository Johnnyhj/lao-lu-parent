"use strict";

/**
 * 用户 区域权限相关
 */
var userConfig = {

    initzTree : function (area_zNodes, flag) {

        var setting = {
            check: {
                enable: flag ,
                chkboxType: { "Y": "ps", "N": "ps" },
                chkStyle: "radio",
                radioType: "all"
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

        function onCheck(e, treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("tree"),
                nodes = zTree.getCheckedNodes(true),
                id = "",
                name = "";
            for (var i=0, l=nodes.length; i<l; i++) {
                id += nodes[i].id + ",";
                name += nodes[i].name + ",";
            }
            if (id.length > 0 ) {
                id = id.substring(0, id.length-1);
            }

            if (name.length > 0 ) {
                name = name.substring(0, name.length-1);
            }

            $("#sysAreaIds").val(id);
        }

        $.fn.zTree.init($("#tree"), setting, area_zNodes);

    }

};

