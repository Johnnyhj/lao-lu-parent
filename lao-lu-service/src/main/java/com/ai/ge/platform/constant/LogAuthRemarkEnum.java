package com.ai.ge.platform.constant;

/**
 * Created by guochunhao on 16/9/20.
 *
 * logAuthEnum 备注的枚举值
 */
public enum LogAuthRemarkEnum {

    noneEnum(0, "不存在该操作"),

    addUser(1, "新增用户"),

    modifyUser(2, "修改用户"),

    deleteUser(3, "删除用户"),

    lockUser(4, "锁定用户"),

    unlockUser(5, "解锁用户"),

    modifyPwdUser(6, "修改密码"),

    addRole(7, "新增角色"),

    modifyRole(8, "修改角色"),

    deleteRole(9, "删除角色"),

    addSysResource(10, "新增权限"),

    modifySysResource(11, "修改权限"),

    deleteSysResource(12, "删除权限"),

    arrivalDocArticle(13,"发布软文"),

    selectDocRepositoryCatalog(14, "查询知识库目录"),

    addDocRepositoryCatalog(15, "新增知识库目录"),

    modifyDocRepositoryCatalog(16, "修改知识库目录"),

    deleteDocRepositoryCatalog(17, "删除知识库目录"),

    recoveryDocRepositoryCatalog(18, "恢复知识库目录"),

    offShvelDocArticle(19,"下架软文"),

    selectDocRepository(20, "查询知识库文档"),

    addDocRepository(21, "新增知识库文档"),

    modifyDocRepository(22, "修改知识库文档"),

    deleteDocRepository(23, "删除知识库文档"),

    recoveryDocRepository(24, "恢复知识库文档");


    public int value;
    public String typeName;

    LogAuthRemarkEnum(int value, String typeName) {
        this.value = value;
        this.typeName = typeName;
    }
    //通过value获取对应的枚举对象
    public static LogAuthRemarkEnum getLogAuthEnumType(int value) {
        for (LogAuthRemarkEnum examType : LogAuthRemarkEnum.values()) {
            if (value == examType.value) {
                return examType;
            }
        }
        return noneEnum;
    }
}
