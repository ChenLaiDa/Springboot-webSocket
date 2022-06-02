package com.example.springbootwebsocket.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("websocket_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("userName")
    private String userName;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
