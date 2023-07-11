package com.wei.apicommon.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 参数传递
 *
 * @author wei
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}