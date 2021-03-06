package com.kinghao.budai.dto;

import com.kinghao.budai.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * session缓存实体
 * @author kinghao on 2020-10-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionData {

    private Integer id;
    private String tel;
    private String username;

    /**
     * {@link UserType}
     */
    private String type;

}
