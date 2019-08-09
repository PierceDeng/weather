package com.zzzfyrw.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author dpz
 * @since 2019-08-09
 */
@TableName("sys_province")
public class SysProvinceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("provinceId")
    private String provinceId;

    private String province;

    @TableField("mergerName")
    private String mergerName;

    @TableField("shortName")
    private String shortName;

    @TableField("mergerShortName")
    private String mergerShortName;

    @TableField("levelType")
    private String levelType;

    @TableField("pinYin")
    private String pinYin;

    @TableField("jianPin")
    private String jianPin;

    @TableField("firstChar")
    private String firstChar;

    private String lng;

    private String lat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getMergerShortName() {
        return mergerShortName;
    }

    public void setMergerShortName(String mergerShortName) {
        this.mergerShortName = mergerShortName;
    }
    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }
    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }
    public String getJianPin() {
        return jianPin;
    }

    public void setJianPin(String jianPin) {
        this.jianPin = jianPin;
    }
    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "SysProvinceEntity{" +
        "id=" + id +
        ", provinceId=" + provinceId +
        ", province=" + province +
        ", mergerName=" + mergerName +
        ", shortName=" + shortName +
        ", mergerShortName=" + mergerShortName +
        ", levelType=" + levelType +
        ", pinYin=" + pinYin +
        ", jianPin=" + jianPin +
        ", firstChar=" + firstChar +
        ", lng=" + lng +
        ", lat=" + lat +
        "}";
    }
}
