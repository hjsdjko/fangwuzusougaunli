package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ChushouEntity;

import com.service.ChushouService;
import com.entity.view.ChushouView;
import com.service.FangdongService;
import com.entity.FangdongEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 房屋出售
 * 后端接口
 * @author
 * @email
 * @date 2021-04-29
*/
@RestController
@Controller
@RequestMapping("/chushou")
public class ChushouController {
    private static final Logger logger = LoggerFactory.getLogger(ChushouController.class);

    @Autowired
    private ChushouService chushouService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private FangdongService fangdongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "房东".equals(role)){
            params.put("fangdongId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = chushouService.queryPage(params);

        //字典表数据转换
        List<ChushouView> list =(List<ChushouView>)page.getList();
        for(ChushouView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChushouEntity chushou = chushouService.selectById(id);
        if(chushou !=null){
            //entity转view
            ChushouView view = new ChushouView();
            BeanUtils.copyProperties( chushou , view );//把实体数据重构到view中

            //级联表
            FangdongEntity fangdong = fangdongService.selectById(chushou.getFangdongId());
            if(fangdong != null){
                BeanUtils.copyProperties( fangdong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setFangdongId(fangdong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChushouEntity chushou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chushou:{}",this.getClass().getName(),chushou.toString());
        Wrapper<ChushouEntity> queryWrapper = new EntityWrapper<ChushouEntity>()
            .eq("chushou_name", chushou.getChushouName())
            .eq("huixing_types", chushou.getHuixingTypes())
            .eq("chushou_weizhi", chushou.getChushouWeizhi())
            .eq("fangdong_id", chushou.getFangdongId())
            ;
        chushou.setChushouTypes(1);
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushouEntity chushouEntity = chushouService.selectOne(queryWrapper);
        if(chushouEntity==null){
            chushou.setChushouSumMoney(chushou.getChushouMoney()*chushou.getChushouMianji());
            chushou.setInsertTime(new Date());
            chushou.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chushou.set
        //  }
            chushouService.insert(chushou);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChushouEntity chushou, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chushou:{}",this.getClass().getName(),chushou.toString());
        //根据字段查询是否有相同数据
        Wrapper<ChushouEntity> queryWrapper = new EntityWrapper<ChushouEntity>()
            .notIn("id",chushou.getId())
            .andNew()
            .eq("chushou_name", chushou.getChushouName())
            .eq("huixing_types", chushou.getHuixingTypes())
            .eq("chushou_weizhi", chushou.getChushouWeizhi())
            .eq("fangdong_id", chushou.getFangdongId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChushouEntity chushouEntity = chushouService.selectOne(queryWrapper);
        if("".equals(chushou.getChushouPhoto()) || "null".equals(chushou.getChushouPhoto())){
                chushou.setChushouPhoto(null);
        }
        if(chushouEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chushou.set
            //  }
            chushouService.updateById(chushou);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chushouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "房东".equals(role)){
            params.put("fangdongId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chushouService.queryPage(params);

        //字典表数据转换
        List<ChushouView> list =(List<ChushouView>)page.getList();
        for(ChushouView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChushouEntity chushou = chushouService.selectById(id);
            if(chushou !=null){
                //entity转view
        ChushouView view = new ChushouView();
                BeanUtils.copyProperties( chushou , view );//把实体数据重构到view中

                //级联表
                    FangdongEntity fangdong = fangdongService.selectById(chushou.getFangdongId());
                if(fangdong != null){
                    BeanUtils.copyProperties( fangdong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangdongId(fangdong.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChushouEntity chushou, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chushou:{}",this.getClass().getName(),chushou.toString());
        Wrapper<ChushouEntity> queryWrapper = new EntityWrapper<ChushouEntity>()
            .eq("chushou_name", chushou.getChushouName())
            .eq("huixing_types", chushou.getHuixingTypes())
            .eq("chushou_weizhi", chushou.getChushouWeizhi())
            .eq("fangdong_id", chushou.getFangdongId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    ChushouEntity chushouEntity = chushouService.selectOne(queryWrapper);
        if(chushouEntity==null){
            chushou.setInsertTime(new Date());
            chushou.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chushou.set
        //  }
        chushouService.insert(chushou);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

