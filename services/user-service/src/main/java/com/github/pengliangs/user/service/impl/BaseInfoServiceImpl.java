package com.github.pengliangs.user.service.impl;

import com.github.pengliangs.common.core.service.impl.BaseServiceImpl;
import com.github.pengliangs.user.dao.BaseInfoDAO;
import com.github.pengliangs.user.module.entity.BaseInfo;
import com.github.pengliangs.user.service.BaseInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基础信息表 服务实现类
 * </p>
 *
 * @author pengliang
 * @since 2019-08-26
 */
@Service
public class BaseInfoServiceImpl extends BaseServiceImpl<BaseInfoDAO, BaseInfo> implements BaseInfoService {

}
