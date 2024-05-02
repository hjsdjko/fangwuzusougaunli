package com.entity.vo;

import com.entity.ChushouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房屋出售
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-29
 */
@TableName("chushou")
public class ChushouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房屋名称
     */

    @TableField(value = "chushou_name")
    private String chushouName;


    /**
     * 户型
     */

    @TableField(value = "huixing_types")
    private Integer huixingTypes;


    /**
     * 面积
     */

    @TableField(value = "chushou_mianji")
    private Double chushouMianji;


    /**
     * 价格
     */

    @TableField(value = "chushou_money")
    private Double chushouMoney;


    /**
     * 总价
     */

    @TableField(value = "chushou_sum_money")
    private Double chushouSumMoney;


    /**
     * 图片
     */

    @TableField(value = "chushou_photo")
    private String chushouPhoto;


    /**
     * 位置
     */

    @TableField(value = "chushou_weizhi")
    private String chushouWeizhi;


    /**
     * 发布房东
     */

    @TableField(value = "fangdong_id")
    private Integer fangdongId;


    /**
     * 详细信息
     */

    @TableField(value = "chushou_content")
    private String chushouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
    public String getChushouName() {
        return chushouName;
    }


    /**
	 * 获取：房屋名称
	 */

    public void setChushouName(String chushouName) {
        this.chushouName = chushouName;
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
    public Double getChushouMianji() {
        return chushouMianji;
    }


    /**
	 * 获取：面积
	 */

    public void setChushouMianji(Double chushouMianji) {
        this.chushouMianji = chushouMianji;
    }
    /**
	 * 设置：价格
	 */
    public Double getChushouMoney() {
        return chushouMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setChushouMoney(Double chushouMoney) {
        this.chushouMoney = chushouMoney;
    }
    /**
	 * 设置：总价
	 */
    public Double getChushouSumMoney() {
        return chushouSumMoney;
    }


    /**
	 * 获取：总价
	 */

    public void setChushouSumMoney(Double chushouSumMoney) {
        this.chushouSumMoney = chushouSumMoney;
    }
    /**
	 * 设置：图片
	 */
    public String getChushouPhoto() {
        return chushouPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setChushouPhoto(String chushouPhoto) {
        this.chushouPhoto = chushouPhoto;
    }
    /**
	 * 设置：位置
	 */
    public String getChushouWeizhi() {
        return chushouWeizhi;
    }


    /**
	 * 获取：位置
	 */

    public void setChushouWeizhi(String chushouWeizhi) {
        this.chushouWeizhi = chushouWeizhi;
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
    public String getChushouContent() {
        return chushouContent;
    }


    /**
	 * 获取：详细信息
	 */

    public void setChushouContent(String chushouContent) {
        this.chushouContent = chushouContent;
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
