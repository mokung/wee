package me.wenkang.wee.api.common.struct.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.wenkang.wee.components.constant.page.Pager;

/**
 * @author wenkang
 * @since 2017/11/16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQuery extends Pager {

    private static final long serialVersionUID = -7271642410589648263L;

    private String userName;

    private String nickName;
}
