package com.wei.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.apicommon.model.entity.UserInterfaceInfo;

/**
 * 用户接口信息服务
 * @author wei
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

	/**
	 * 用户接口信息校验
	 * @param userInterfaceInfo
	 * @param add
	 */
	void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

	/**
	 * 调用接口统计
	 * @param interfaceInfoId
	 * @param userId
	 * @return
	 */
	boolean invokeCount(long interfaceInfoId, long userId);

	/**
	 * 查看用户对这个接口是否还有调用次数
	 * @param interfaceInfoId
	 * @param userId
	 * @return
	 */
	boolean hasLeftNum(long interfaceInfoId, long userId);
}
