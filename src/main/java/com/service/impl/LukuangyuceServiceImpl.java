package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.LukuangyuceDao;
import com.entity.LukuangyuceEntity;
import com.service.LukuangyuceService;
import com.entity.vo.LukuangyuceVO;
import com.entity.view.LukuangyuceView;

@Service("lukuangyuceService")
public class LukuangyuceServiceImpl extends ServiceImpl<LukuangyuceDao, LukuangyuceEntity> implements LukuangyuceService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LukuangyuceEntity> page = this.selectPage(
                new Query<LukuangyuceEntity>(params).getPage(),
                new EntityWrapper<LukuangyuceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LukuangyuceEntity> wrapper) {
		  Page<LukuangyuceView> page =new Query<LukuangyuceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LukuangyuceVO> selectListVO(Wrapper<LukuangyuceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LukuangyuceVO selectVO(Wrapper<LukuangyuceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LukuangyuceView> selectListView(Wrapper<LukuangyuceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LukuangyuceView selectView(Wrapper<LukuangyuceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
