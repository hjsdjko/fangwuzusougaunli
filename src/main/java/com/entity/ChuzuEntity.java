package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 房屋出租
 *
 * @author 
 * @email
 * @date 2021-04-29
 */
@TableName("chuzu")
public class ChuzuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuzuEntity() {

	}

	public ChuzuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 房屋名称
     */
    @TableField(value = "chuzu_name")

    private String chuzuName;
    /**
     * 房屋名称
     */
    @TableField(value = "chuzu_types")

    private Integer chuzuTypes;

    public Integer getChuzuTypes() {
        return chuzuTypes;
    }

    public void setChuzuTypes(Integer chuzuTypes) {
        this.chuzuTypes = chuzuTypes;
    }

    /**
     * 户型
     */
    @TableField(value = "huixing_types")

    private Integer huixingTypes;


    /**
     * 面积
     */
    @TableField(value = "chuzu_mianji")

    private Double chuzuMianji;


    /**
     * 价格/月
     */
    @TableField(value = "chuzu_money")

    private Double chuzuMoney;


    /**
     * 图片
     */
    @TableField(value = "chuzu_photo")

    private String chuzuPhoto;


    /**
     * 位置
     */
    @TableField(value = "chuzu_weizhi")

    private String chuzuWeizhi;


    /**
     * 发布房东
     */
    @TableField(value = "fangdong_id")

    private Integer fangdongId;


    /**
     * 详细信息
     */
    @TableField(value = "chuzu_content")

    private String chuzuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：房屋名称
	 */
    public String getChuzuName() {
        return chuzuName;
    }


    /**
	 * 获取：房屋名称
	 */

    public void setChuzuName(String chuzuName) {
        this.chuzuName = chuzuName;
    }
    /**
	 * 设置：户型
	 */
    public Integer getHuixingTypes() {
        return huixingTypes;
    }


    /**
	 * 获取：户型
	 */

    public void setHuixingTypes(Integer huixingTypes) {
        this.huixingTypes = huixingTypes;
    }
    /**
	 * 设置：面积
	 */
    public Double getChuzuMianji() {
        return chuzuMianji;
    }


    /**
	 * 获取：面积
	 */

    public void setChuzuMianji(Double chuzuMianji) {
        this.chuzuMianji = chuzuMianji;
    }
    /**
	 * 设置：价格/月
	 */
    public Double getChuzuMoney() {
        return chuzuMoney;
    }


    /**
	 * 获取：价格/月
	 */

    public void setChuzuMoney(Double chuzuMoney) {
        this.chuzuMoney = chuzuMoney;
    }
    /**
	 * 设置：图片
	 */
    public String getChuzuPhoto() {
        return chuzuPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setChuzuPhoto(String chuzuPhoto) {
        this.chuzuPhoto = chuzuPhoto;
    }
    /**
	 * 设置：位置
	 */
    public String getChuzuWeizhi() {
        return chuzuWeizhi;
    }


    /**
	 * 获取：位置
	 */

    public void setChuzuWeizhi(String chuzuWeizhi) {
        this.chuzuWeizhi = chuzuWeizhi;
    }
    /**
	 * 设置：发布房东
	 */
    public Integer getFangdongId() {
        return fangdongId;
    }


    /**
	 * 获取：发布房东
	 */

    public void setFangdongId(Integer fangdongId) {
        this.fangdongId = fangdongId;
    }
    /**
	 * 设置：详细信息
	 */
    public String getChuzuContent() {
        return chuzuContent;
    }


    /**
	 * 获取：详细信息
	 */

    public void setChuzuContent(String chuzuContent) {
        this.chuzuContent = chuzuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chuzu{" +
            "id=" + id +
            ", chuzuName=" + chuzuName +
            ", huixingTypes=" + huixingTypes +
            ", chuzuMianji=" + chuzuMianji +
            ", chuzuMoney=" + chuzuMoney +
            ", chuzuPhoto=" + chuzuPhoto +
            ", chuzuWeizhi=" + chuzuWeizhi +
            ", fangdongId=" + fangdongId +
            ", chuzuContent=" + chuzuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
