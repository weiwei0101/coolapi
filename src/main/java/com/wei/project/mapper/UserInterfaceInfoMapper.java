package com.wei.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @Entity com.wei.project.model.entity.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

	List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




