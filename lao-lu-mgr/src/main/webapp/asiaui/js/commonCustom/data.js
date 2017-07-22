"use strict";

/**
 * 产品配置等相关方法
 */
var dataConfig = {

    deleteObj: "",

    node: null,

    initTable: function (object) {

        // 初始化 table
        $("#tree-table").treetable({expandable: true});

        $.each(object, function (index, dataModule) {
            dataConfig.createDataModule(dataModule, dataModule.node);
        });

        var frame = $(window.parent.window.document.getElementById("/platform-mgr/mgr/data/experience"));
        var subH = $(".md-content").height();
        frame.height(subH);

        $("#tree-table").treetable("collapseAll");

    },

    createDataModule: function (dataModule, node) {
        var table = $("#tree-table > tbody");
        var tr;
        var id = dataModule.dataModuleId;
        tr = $('<tr data-tt-id="' + id + '">');

        // 模块ID
        tr.append("<td>" + id + "</td>");

        // 模块名称
        tr.append("<td>" + dataModule.moduleTitle + "</td>");

        // 体验标题
        tr.append("<td></td>");

        // 公司
        tr.append("<td></td>");

        // 模块状态
        tr.append("<td>" + dataConfig.getStatus(dataModule.status) + "</td>");

        // 操作
        dataConfig.getModuleOperate(tr, dataModule);

        if (node) {
            $("#tree-table").treetable("loadBranch", node, tr);
        }
        else {
            $("#tree-table").treetable("loadBranch", null, tr);
        }

        if (dataModule.experienceDataList != null && dataModule.experienceDataList.length > 0) {
            $.each(dataModule.experienceDataList, function(i, experienceData){
                dataConfig.createExperienceDataTr(experienceData, id);
            });
        }

    },

    /**
     * 追加模块下的资料
     *
     * @param experienceData
     * @param parentId
     */
    createExperienceDataTr : function (experienceData, parentId) {

        if (experienceData.dataId == null) {
            return;
        }

        var node = $("#tree-table").treetable("node", parentId);
        var table = $("#tree-table > tbody");
        var tr = $('<tr data-tt-id="'+parentId+'_'+experienceData.dataId+'" data-tt-parent-id="'+parentId+'">');

        // 产品id
        tr.append("<td>"+experienceData.dataId+"</td>");

        tr.append("<td></td>");

        // 产品标题
        tr.append("<td><div>"+experienceData.dataTitle+"</div></td>");

        // 公司
        tr.append("<td>" + experienceData.company + "</td>");

        // 产品状态
        tr.append("<td>" + dataConfig.getStatus(experienceData.status) + "</td>");
        var input = $('<input type="hidden"/>');
        input.attr("id", "hiddenStatus_" + experienceData.dataId);
        input.attr("value", experienceData.status);
        tr.append(input);

        dataConfig.getDataOperate(tr, experienceData);

        $("#tree-table").treetable("loadBranch", node, tr);
    },

    /**
     * 通过状态值获取状态描述
     * @param status
     */
    getStatus: function (status) {
        if (status != undefined) {
            if (status == 1) {
                return "启用";
            }
            else if (status == 0) {
                return "禁用";
            }
        } else {
            return "";
        }
    },

    /**
     * 模块操作栏返回
     * @param status
     */
    getModuleOperate : function (tr, dataModule) {
        // 操作
        var td = $('<td></td>');
        var a1 = $('<a>修改</a>').attr('href', commonConfig.contentName + '/mgr/data/moduleEdit?dataModuleId=' + dataModule.dataModuleId);

        var a2 = $('<a>新增体验资料</a>').attr('href', commonConfig.contentName + '/mgr/data/dataEdit?dataTypeTemp=2&dataType=2&dataModuleId=' + dataModule.dataModuleId + '&moduleTitle='+encodeURI(encodeURI(dataModule.moduleTitle)));
        td.append(a1).append(" | ").append(a2);

        tr.append(td);

    },

    /**
     * 资料操作栏返回
     * @param status
     */
    getDataOperate : function (tr, experienceData) {
        // 操作
        var td = $('<td></td>');
        var a1 = $('<a>修改</a>').attr('href', commonConfig.contentName + '/mgr/data/dataEdit?dataTypeTemp=2&dataId=' + experienceData.dataId + '&dataType=' + experienceData.dataType);

        if (experienceData.status == 1) {
            var a2 = $('<a>禁用</a>');

        }
        else if (experienceData.status == 0)
        {
            var a2 = $('<a>启用</a>');
        }
        a2.attr("id", "status_" + experienceData.dataId);

        td.delegate("#status_" + experienceData.dataId, "click", function(){
            dataConfig.updateDataStatus(experienceData);
        });

        td.append(a1).append(" | ").append(a2);

        tr.append(td);

    },

    // 更新产品状态
    updateDataStatus : function (experienceData) {
        var dataId = $("#status_" + experienceData.dataId).parent().parent().children("td:eq(0)").text().trim();

        // 当前状态值
        var statusVar = $("#" + "hiddenStatus_" + experienceData.dataId).val();
        var updateStatus = (1 == statusVar ? 0 : 1);

        $.ajax({
            type: "POST",
            url: commonConfig.contentName + "/mgr/data/updateStatus",
            data: {dataId: dataId, status: updateStatus},
            success: function (data) {
                var msg = (1 == updateStatus ? "启用" : "禁用");

                if (1 == data.resultCode) {
                    $("#status_" + experienceData.dataId).parent().parent().children("td:eq(4)").text(msg);
                    $("#status_" + experienceData.dataId).text(1 == updateStatus ? "禁用" : "启用");
                    $("#" + "hiddenStatus_" + experienceData.dataId).val(updateStatus);
                }
                alert(data.resultMsg);
            },
            error: function () {
                alert("更新失败");
            }
        });


    },

    // 更新产品状态
    updateStatus : function (obj) {
        var dataId = $(obj).parent().parent().children("td:eq(0)").text().trim();

        // 当前状态值
        var statusVar = $("#" + "hiddenStatus_" + dataId).val();
        var updateStatus = (1 == statusVar ? 0 : 1);

        $.ajax({
            type: "POST",
            url: commonConfig.contentName + "/mgr/data/updateStatus",
            data: {dataId: dataId, status: updateStatus},
            success: function (data) {
                var msg = (1 == updateStatus ? "启用" : "禁用");

                if (1 == data.resultCode) {
                    $(obj).parent().parent().children("td:eq(4)").text(msg);
                    $(obj).text(1 == updateStatus ? "禁用" : "启用");
                    $("#" + "hiddenStatus_" + dataId).val(updateStatus);
                }
                alert(data.resultMsg);
            },
            error: function () {
                alert("更新失败");
            }
        });


    },

    changeDataType : function() {
        // 当选择体验资料时,需要初始化父模块选择下拉框
        var type = $("#dataType").val();
        if (2 == type) {
            // 初始化体验资料的父模块
            $("#dataModuleDiv").show();
        }
        else if (1 == type) {
            $("#dataModuleDiv").hide();
        }
    },

    /**
     * 表里输入值校验
     */
    setValidate: function () {
        $("#customerFrom").validate({
            submitHandler: function (form) {
                form.submit();
            },
            rules: {
                'customer.userName': {
                    required: true,
                    maxlength: 16
                },
                'customer.phoneNum': {
                    required: true,
                    maxlength: 11,
                    number: true
                },
                'customer.idCardNum': {
                    required: true,
                    digits: true,
                    maxlength: 18
                },
                customerManageName: {
                    required: true,
                    maxlength: 16
                },
                'customerManager.phoneNum': {
                    required: true,
                    maxlength: 11
                },
                startTime: {
                    required: true
                },
                endTime: {
                    required: true
                }
            }
        });
    }

};

