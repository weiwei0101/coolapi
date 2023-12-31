package com.wei.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.wei.apicommon.model.entity.InterfaceInfo;
import com.wei.apicommon.model.entity.UserInterfaceInfo;
import com.wei.project.annotation.AuthCheck;
import com.wei.apicommon.common.BaseResponse;
import com.wei.apicommon.common.ErrorCode;
import com.wei.apicommon.common.ResultUtils;
import com.wei.project.exception.BusinessException;
import com.wei.project.mapper.UserInterfaceInfoMapper;
import com.wei.apicommon.model.vo.InterfaceInfoVO;
import com.wei.project.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

	@Resource
	private UserInterfaceInfoMapper userInterfaceInfoMapper;

	@Resource
	private InterfaceInfoService interfaceInfoService;

	@GetMapping("/top/interface/invoke")
	@AuthCheck(mustRole = "admin")
	public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo(){
		List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
		Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
			.collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
		QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.in("id",interfaceInfoIdObjMap.keySet());
		List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
		if (CollectionUtils.isEmpty(list)){
			throw new BusinessException(ErrorCode.SYSTEM_ERROR);
		}
		List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
			InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
			BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
			int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
			interfaceInfoVO.setTotalNum(totalNum);
			return interfaceInfoVO;
		}).collect(Collectors.toList());
		return ResultUtils.success(interfaceInfoVOList);
	}

}
