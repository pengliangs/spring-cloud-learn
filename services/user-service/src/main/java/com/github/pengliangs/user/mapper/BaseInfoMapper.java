package com.github.pengliangs.user.mapper;

import com.github.pengliangs.user.module.dto.BaseInfoDTO;
import com.github.pengliangs.user.module.entity.BaseInfo;
import com.github.pengliangs.user.module.vo.BaseInfoVO;
import org.mapstruct.Mapper;

/**
 * @author pengliang
 * @date 2019/8/26 16:35
 */
@Mapper(componentModel = "spring")
public interface BaseInfoMapper {

    BaseInfoDTO toBaseInfoDTO(BaseInfo baseInfo);

    BaseInfoVO toBaseInfoVO(BaseInfoDTO baseInfoDTO);

    BaseInfoVO toBaseInfoVO(BaseInfo baseInfo);

    BaseInfo toBaseInfo(BaseInfoDTO baseInfoDTO);
}
