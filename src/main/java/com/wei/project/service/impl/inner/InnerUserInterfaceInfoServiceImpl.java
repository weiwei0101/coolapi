package com.wei.project.service.impl.inner;

import com.wei.apicommon.service.InnerUserInterfaceInfoService;
import com.wei.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

	@Resource
	private UserInterfaceInfoService userInterfaceInfoService;

	@Override
	public boolean invokeCount(long interfaceInfoId, long userId) {
		return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
	}

	@Override
	public boolean hasLeftNum(long interfaceInfoId, long userId) {
		return userInterfaceInfoService.hasLeftNum(interfaceInfoId, userId);
	}

}
