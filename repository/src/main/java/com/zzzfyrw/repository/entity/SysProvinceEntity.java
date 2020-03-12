package com.zzzfyrw.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dpz
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_province")
public class SysProvinceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("province_id")
    private String provinceId;

    @TableField("province")
    private String province;

    @TableField("merger_name")
    private String mergerName;

    @TableField("short_name")
    private String shortName;

    @TableField("merger_short_name")
    private String mergerShortName;

    @TableField("level_type")
    private String levelType;

    @TableField("pin_yin")
    private String pinYin;

    @TableField("jian_pin")
    private String jianPin;

    @TableField("first_char")
    private String firstChar;

    @TableField("lng")
    private String lng;

    @TableField("lat")
    private String lat;


}
