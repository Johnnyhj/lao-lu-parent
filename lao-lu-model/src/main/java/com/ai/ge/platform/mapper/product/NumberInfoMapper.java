package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.product.NumberInfo;
import com.ai.ge.platform.model.product.NumberInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NumberInfoMapper {
    int countByExample(NumberInfoExample example);

    int deleteByExample(NumberInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NumberInfo record);

    int insertSelective(NumberInfo record);

    List<NumberInfo> selectByExample(NumberInfoExample example);

    NumberInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NumberInfo record, @Param("example") NumberInfoExample example);

    int updateByExample(@Param("record") NumberInfo record, @Param("example") NumberInfoExample example);

    int updateByPrimaryKeySelective(NumberInfo record);

    int updateByPrimaryKey(NumberInfo record);

    List<NumberInfo> findListBycount(@Param("count") int count,@Param("provinceAreaId") Long provinceAreaId,@Param("cityareaId") Long cityareaId);

    List<NumberInfoDto> listNumberInfo(NumberInfoDto record);

    List<NumberInfo> findListRand(@Param("numberCount") int numberCount,@Param("provinceAreaId") Long provinceAreaId,@Param("cityareaId") Long cityareaId);

    /**
     * 号码是否存在
     * @param numbers
     * @return
     */
    List<Map<String, Object>> isExistsNumber(@Param("numbers") List<List<String>> numbers);

    /**
     * 批量插入号码
     * @param objects
     * @return
     */
    int insertBatch(@Param("objects") List<NumberInfo> objects);
}