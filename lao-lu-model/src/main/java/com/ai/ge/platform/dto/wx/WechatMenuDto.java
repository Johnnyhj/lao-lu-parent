package com.ai.ge.platform.dto.wx;

import com.ai.ge.platform.model.wx.WechatMenu;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/*微信菜单JSON格式

http://mp.weixin.qq.com/wiki/10/0234e39a2025342c17a7d23595c6b40a.html

{
    "button": [
        {
            "type": "click",
            "name": "今日歌曲",
            "key": "V1001_TODAY_MUSIC"
        },
        {
            "name": "菜单",
            "sub_button": [
                {
                    "type": "view",
                    "name": "搜索",
                    "url": "http://www.soso.com/"
                },
                {
                    "type": "view",
                    "name": "视频",
                    "url": "http://v.qq.com/"
                },
                {
                    "type": "click",
                    "name": "赞一下我们",
                    "key": "V1001_GOOD"
                }
            ]
        }
    ]
}


*/
public class WechatMenuDto extends WechatMenu
{
    @Override
    @JSONField(serialize = false)
    public Long getMenuId() {
        return super.getMenuId();
    }

    @Override
    @JSONField(serialize = false)
    public Long getParentId() {
        return super.getParentId();
    }

    @Override
    @JSONField(serialize = false)
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    @JSONField(serialize = false)
    public Date getUpdateTime() {
        return super.getUpdateTime();
    }

    @Override
    @JSONField(serialize = false)
    public Short getOrderNum() {
        return super.getOrderNum();
    }

    @JSONField(name = "sub_button")
    private List<WechatMenuDto> subButtons;


    public List<WechatMenuDto> getSubButtons() {
        return subButtons;
    }

    public void setSubButtons(List<WechatMenuDto> subButtons) {
        this.subButtons = subButtons;
    }
}