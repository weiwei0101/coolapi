package com.wei.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.apicommon.common.ErrorCode;
import com.wei.apicommon.model.entity.UserInterfaceInfo;
import com.wei.project.exception.BusinessException;
import com.wei.project.mapper.UserInterfaceInfoMapper;
import com.wei.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

	@Override
	public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
		if (userInterfaceInfo == null) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}
		// 创建时，所有参数必须非空
		if (add) {
			if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0){
				throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口或用户不存在");
			}
		}
		if (userInterfaceInfo.getLeftNum() < 0) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
		}
	}

	@Override
	public boolean invokeCount(long interfaceInfoId, long userId) {
		// 校验
		if (interfaceInfoId <= 0 || userId <= 0){
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}
		UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("interfaceInfoId", interfaceInfoId);
		updateWrapper.eq("userId", userId);
//		updateWrapper.gt("leftNum", 0);
		updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
		return this.update(updateWrapper);
	}

}




