package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ParaDiscreteValue;
import com.ai.ge.platform.model.product.ParaDiscreteValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParaDiscreteValueMapper {
    int countByExample(ParaDiscreteValueExample example);

    int deleteByExample(ParaDiscreteValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParaDiscreteValue record);

    int insertSelective(ParaDiscreteValue record);

    List<ParaDiscreteValue> selectByExample(ParaDiscreteValueExample example);

    ParaDiscreteValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParaDiscreteValue record, @Param("example") ParaDiscreteValueExample example);

    int updateByExample(@Param("record") ParaDiscreteValue record, @Param("example") ParaDiscreteValueExample example);

    int updateByPrimaryKeySelective(ParaDiscreteValue record);

    int updateByPrimaryKey(ParaDiscreteValue record);
}