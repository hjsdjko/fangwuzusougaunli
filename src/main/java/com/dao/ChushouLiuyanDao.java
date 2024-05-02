package com.dao;

import com.entity.ChushouLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushouLiuyanView;

/**
 * 房屋出售留言 Dao 接口
 *
 * @author 
 * @since 2021-04-29
 */
public interface ChushouLiuyanDao extends BaseMapper<ChushouLiuyanEntity> {

   List<ChushouLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
