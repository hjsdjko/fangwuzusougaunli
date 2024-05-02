package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChushouOrderEntity;
import java.util.Map;

/**
 * 房屋出售订单 服务类
 * @author 
 * @since 2021-04-29
 */
public interface ChushouOrderService extends IService<ChushouOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}