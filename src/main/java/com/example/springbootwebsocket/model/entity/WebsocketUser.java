package com.example.springbootwebsocket.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-05-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WebsocketUser extends Model<WebsocketUser> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
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
