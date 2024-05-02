package com.dao;

import com.entity.ChushouOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushouOrderView;

/**
 * 房屋出售订单 Dao 接口
 *
 * @author 
 * @since 2021-04-29
 */
public interface ChushouOrderDao extends BaseMapper<ChushouOrderEntity> {

   List<ChushouOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
