package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ChepiaogoumaiEntity;
import com.entity.view.ChepiaogoumaiView;

import com.service.ChepiaogoumaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 车票购买
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
@RestController
@RequestMapping("/chepiaogoumai")
public class ChepiaogoumaiController {
    @Autowired
    private ChepiaogoumaiService chepiaogoumaiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChepiaogoumaiEntity chepiaogoumai, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			chepiaogoumai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChepiaogoumaiEntity> ew = new EntityWrapper<ChepiaogoumaiEntity>();


		PageUtils page = chepiaogoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chepiaogoumai), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChepiaogoumaiEntity chepiaogoumai, 
		HttpServletRequest request){
        EntityWrapper<ChepiaogoumaiEntity> ew = new EntityWrapper<ChepiaogoumaiEntity>();

		PageUtils page = chepiaogoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chepiaogoumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChepiaogoumaiEntity chepiaogoumai){
       	EntityWrapper<ChepiaogoumaiEntity> ew = new EntityWrapper<ChepiaogoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chepiaogoumai, "chepiaogoumai")); 
        return R.ok().put("data", chepiaogoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChepiaogoumaiEntity chepiaogoumai){
        EntityWrapper< ChepiaogoumaiEntity> ew = new EntityWrapper< ChepiaogoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chepiaogoumai, "chepiaogoumai")); 
		ChepiaogoumaiView chepiaogoumaiView =  chepiaogoumaiService.selectView(ew);
		return R.ok("查询车票购买成功").put("data", chepiaogoumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChepiaogoumaiEntity chepiaogoumai = chepiaogoumaiService.selectById(id);
        return R.ok().put("data", chepiaogoumai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChepiaogoumaiEntity chepiaogoumai = chepiaogoumaiService.selectById(id);
        return R.ok().put("data", chepiaogoumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChepiaogoumaiEntity chepiaogoumai, HttpServletRequest request){
    	chepiaogoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chepiaogoumai);

        chepiaogoumaiService.insert(chepiaogoumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChepiaogoumaiEntity chepiaogoumai, HttpServletRequest request){
    	chepiaogoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chepiaogoumai);

        chepiaogoumaiService.insert(chepiaogoumai);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChepiaogoumaiEntity chepiaogoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chepiaogoumai);
        chepiaogoumaiService.updateById(chepiaogoumai);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ChepiaogoumaiEntity> list = new ArrayList<ChepiaogoumaiEntity>();
        for(Long id : ids) {
            ChepiaogoumaiEntity chepiaogoumai = chepiaogoumaiService.selectById(id);
            chepiaogoumai.setSfsh(sfsh);
            chepiaogoumai.setShhf(shhf);
            list.add(chepiaogoumai);
        }
        chepiaogoumaiService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chepiaogoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
