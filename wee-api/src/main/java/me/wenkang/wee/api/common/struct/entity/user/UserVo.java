package me.wenkang.wee.api.common.struct.entity.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by wenkang
 * on 2017/11/14.
 */

@Data
public class UserVo implements Serializable{

    private Long id;

    @NotBlank
    private String userName;

    private String nickName;

    @NotBlank
    private String password;

    private String avatar;

    private String signature;

    private String introduction;

    private Integer isValid;

    private String ipAddress;

}
