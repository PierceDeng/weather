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
@TableName("sys_city")
public class SysCityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("cityId")
    private String cityId;

    private String father;

    private String city;

    @TableField("mergerName")
    private String mergerName;

    @TableField("shortName")
    private String shortName;

    @TableField("mergerShortName")
    private String mergerShortName;

    @TableField("levelType")
    private String levelType;

    private String pinyin;

    private String jianpin;

    @TableField("firstChar")
    private String firstChar;

    private String lng;

    private String lat;

    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    public String getJianpin() {
        return jianpin;
    }

    public void setJianpin(String jianpin) {
        this.jianpin = jianpin;
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
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "SysCityEntity{" +
        "id=" + id +
        ", cityId=" + cityId +
        ", father=" + father +
        ", city=" + city +
        ", mergerName=" + mergerName +
        ", shortName=" + shortName +
        ", mergerShortName=" + mergerShortName +
        ", levelType=" + levelType +
        ", pinyin=" + pinyin +
        ", jianpin=" + jianpin +
        ", firstChar=" + firstChar +
        ", lng=" + lng +
        ", lat=" + lat +
        ", remarks=" + remarks +
        "}";
    }
}
