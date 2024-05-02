package com.entity.model;

import com.entity.ChushouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋出售
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-29
 */
public class ChushouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房屋名称
     */
    private String chushouName;
    /**
     * 房屋名称
     */
    private Integer chushouTypes;

    public Integer getChushouTypes() {
        return chushouTypes;
    }

    public void setChushouTypes(Integer chushouTypes) {
        this.chushouTypes = chushouTypes;
    }

    /**
     * 户型
     */
    private Integer huixingTypes;


    /**
     * 面积
     */
    private Double chushouMianji;


    /**
     * 价格
     */
    private Double chushouMoney;


    /**
     * 总价
     */
    private Double chushouSumMoney;


    /**
     * 图片
     */
    private String chushouPhoto;


    /**
     * 位置
     */
    private String chushouWeizhi;


    /**
     * 发布房东
     */
    private Integer fangdongId;


    /**
     * 详细信息
     */
    private String chushouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：房屋名称
	 */
    public String getChushouName() {
        return chushouName;
    }


    /**
	 * 设置：房屋名称
	 */
    public void setChushouName(String chushouName) {
        this.chushouName = chushouName;
    }
    /**
	 * 获取：户型
	 */
    public Integer getHuixingTypes() {
        return huixingTypes;
    }


    /**
	 * 设置：户型
	 */
    public void setHuixingTypes(Integer huixingTypes) {
        this.huixingTypes = huixingTypes;
    }
    /**
	 * 获取：面积
	 */
    public Double getChushouMianji() {
        return chushouMianji;
    }


    /**
	 * 设置：面积
	 */
    public void setChushouMianji(Double chushouMianji) {
        this.chushouMianji = chushouMianji;
    }
    /**
	 * 获取：价格
	 */
    public Double getChushouMoney() {
        return chushouMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setChushouMoney(Double chushouMoney) {
        this.chushouMoney = chushouMoney;
    }
    /**
	 * 获取：总价
	 */
    public Double getChushouSumMoney() {
        return chushouSumMoney;
    }


    /**
	 * 设置：总价
	 */
    public void setChushouSumMoney(Double chushouSumMoney) {
        this.chushouSumMoney = chushouSumMoney;
    }
    /**
	 * 获取：图片
	 */
    public String getChushouPhoto() {
        return chushouPhoto;
    }


    /**
	 * 设置：图片
	 */
    public void setChushouPhoto(String chushouPhoto) {
        this.chushouPhoto = chushouPhoto;
    }
    /**
	 * 获取：位置
	 */
    public String getChushouWeizhi() {
        return chushouWeizhi;
    }


    /**
	 * 设置：位置
	 */
    public void setChushouWeizhi(String chushouWeizhi) {
        this.chushouWeizhi = chushouWeizhi;
    }
    /**
	 * 获取：发布房东
	 */
    public Integer getFangdongId() {
        return fangdongId;
    }


    /**
	 * 设置：发布房东
	 */
    public void setFangdongId(Integer fangdongId) {
        this.fangdongId = fangdongId;
    }
    /**
	 * 获取：详细信息
	 */
    public String getChushouContent() {
        return chushouContent;
    }


    /**
	 * 设置：详细信息
	 */
    public void setChushouContent(String chushouContent) {
        this.chushouContent = chushouContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
