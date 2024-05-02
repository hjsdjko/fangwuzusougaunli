package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ChushouOrderDao;
import com.entity.ChushouOrderEntity;
import com.service.ChushouOrderService;
import com.entity.view.ChushouOrderView;

/**
 * 房屋出售订单 服务实现类
 * @author 
 * @since 2021-04-29
 */
@Service("chushouOrderService")
@Transactional
public class ChushouOrderServiceImpl extends ServiceImpl<ChushouOrderDao, ChushouOrderEntity> implements ChushouOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChushouOrderView> page =new Query<ChushouOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
