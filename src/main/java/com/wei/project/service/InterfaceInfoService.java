package com.wei.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.apicommon.model.entity.InterfaceInfo;

/**
 *
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

	void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
