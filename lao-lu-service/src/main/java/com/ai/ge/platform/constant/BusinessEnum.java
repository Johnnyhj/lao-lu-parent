package com.ai.ge.platform.constant;

/**
 * Created by guochunhao on 16/11/11.
 *
 * 行业的枚举值,暂且不存数据库
 */
public enum BusinessEnum
{
    businessPerson(0, "个人"),
    businessGovernment(1, "政府"),
    businessFinance(2, "金融"),
    businessEducation(3, "文教"),
    businessScientific(4, "科研"),
    businessCommunication(5, "通信"),
    businessOther(6, "其他");

    public int userBusinessId;

    public String userBusiness;

    BusinessEnum(int userBusinessId, String userBusiness)
    {
        this.userBusinessId = userBusinessId;
        this.userBusiness = userBusiness;
    }

    //通过value获取对应的枚举对象
    public static BusinessEnum getBusinessEnum(int value) {
        for (BusinessEnum examType : BusinessEnum.values()) {
            if (value == examType.userBusinessId) {
                return examType;
            }
        }
        return businessOther;
    }
}
