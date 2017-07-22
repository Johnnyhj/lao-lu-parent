"use strict";

/**
 * 日志管理相关方法
 */
var logConfig = {

    deleteObj : "",

    // 删除日志
    deleteLog : function(obj)
    {
        var logId = $(obj).parent().parent().children("td:eq(0)").text().trim();

        $("#deleteId").val(logId);
        logConfig.deleteObj = $(obj).parent().parent();
        $('#delcfmModel').modal();
    },

    // 删除日志
    deleteLogConfirm : function()
    {
        var processId = $("#deleteId").val();

        $.ajax({
            type : "POST",
            url : commonConfig.contentName + "/mgr/log/delete",
            data : {processId : processId},
            success : function(data)
            {
                if (1 == data.resultCode)
                {
                    logConfig.deleteObj.remove();
                }
                alert(data.resultMsg);
            },
            error : function(){
                alert("删除失败");
            }
        });
    }

}

