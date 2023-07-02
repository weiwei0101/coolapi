package com.wei.apicommon.service;

import com.wei.apicommon.model.entity.User;

/**
 * 内部用户服务
 * @author wei
 */
public interface InnerUserService {

    /**
     * 数据库查询是否已分配给用户秘钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
