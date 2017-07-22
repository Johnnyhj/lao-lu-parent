package com.ai.ge.platform.service.sys;


import com.ai.ge.platform.model.sys.SystemAccessWhiteListExample;
import com.ai.ge.platform.model.sys.SystemAccessWhiteList;

import java.util.List;

public interface SystemAccessWhiteListService {


    List<SystemAccessWhiteList> selectByExample(SystemAccessWhiteListExample example);
}
