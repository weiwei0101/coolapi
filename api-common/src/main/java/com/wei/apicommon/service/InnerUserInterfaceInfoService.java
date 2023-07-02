package com.wei.apicommon.service;

/**
 * 内部用户接口信息服务
 * @author wei
 */
public interface InnerUserInterfaceInfoService {

	/**
	 * 调用接口统计
	 * @param interfaceInfoId
	 * @param userId
	 * @return
	 */
	boolean invokeCount(long interfaceInfoId, long userId);
}
