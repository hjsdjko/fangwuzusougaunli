package com.entity.model;

import com.entity.ChushouLiuyanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋出售留言
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-29
 */
public class ChushouLiuyanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房屋出售id
     */
    private Integer chushouId;


    /**
     * 用户id
     */
    private Integer yonghuId;


    /**
     * 留言内容
     */
    private String chushouLiuyanContent;


    /**
     * 回复内容
     */
    private String replyContent;


    /**
     * 讨论时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：房屋出售id
	 */
    public Integer getChushouId() {
        return chushouId;
    }


    /**
	 * 设置：房屋出售id
	 */
    public void setChushouId(Integer chushouId) {
        this.chushouId = chushouId;
    }
    /**
	 * 获取：用户id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户id
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：留言内容
	 */
    public String getChushouLiuyanContent() {
        return chushouLiuyanContent;
    }


    /**
	 * 设置：留言内容
	 */
    public void setChushouLiuyanContent(String chushouLiuyanContent) {
        this.chushouLiuyanContent = chushouLiuyanContent;
    }
    /**
	 * 获取：回复内容
	 */
    public String getReplyContent() {
        return replyContent;
    }


    /**
	 * 设置：回复内容
	 */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
    /**
	 * 获取：讨论时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：讨论时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
