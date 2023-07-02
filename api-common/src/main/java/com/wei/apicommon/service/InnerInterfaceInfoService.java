package com.wei.apicommon.service;

import com.wei.apicommon.model.entity.InterfaceInfo;

/**
 * 内部接口信息服务
 * @author wei
 */
public interface InnerInterfaceInfoService {

	/**
	 * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
	 * @param path
	 * @param method
	 * @return
	 */
	InterfaceInfo getInterfaceInfo(String path, String method);
}
