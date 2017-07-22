package com.ai.ge.platform.common.jcaptcha;

/**
 * Created by guochunhao on 17/2/17.
 */
public interface Constants
{
    interface ORDER_STATUS
    {
        // 待支付
        short WAIT_PAY = 0;

        // 甩单中
        short SHUAI_DAN = 1;

        // 待竣工
        short WAIT_COMPLETE = 2;

        // 待发货
        short WAIT_DELIVER_GOOD = 3;

        // 已发货
        short COMPLETED_DELIVERED = 4;

        // 确认收货
        short TAKE_DELIVERY_CONFIRMATION = 5;

        // 订单超时
        short ORDER_TIMEOUT = 6;

        // 未竣工
        short NOT_COMPLETED = 7;

        // 已退款
        short REFUND = 8;

        // 支付失败
        short PAYMENT_FAILURE = 9;

        // 退款中
        short TUI_KUAN_ZHONG = 10;
    }
}
