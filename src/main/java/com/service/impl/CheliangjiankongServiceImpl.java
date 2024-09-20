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


import com.dao.CheliangjiankongDao;
import com.entity.CheliangjiankongEntity;
import com.service.CheliangjiankongService;
import com.entity.vo.CheliangjiankongVO;
import com.entity.view.CheliangjiankongView;

@Service("cheliangjiankongService")
public class CheliangjiankongServiceImpl extends ServiceImpl<CheliangjiankongDao, CheliangjiankongEntity> implements CheliangjiankongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangjiankongEntity> page = this.selectPage(
                new Query<CheliangjiankongEntity>(params).getPage(),
                new EntityWrapper<CheliangjiankongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangjiankongEntity> wrapper) {
		  Page<CheliangjiankongView> page =new Query<CheliangjiankongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CheliangjiankongVO> selectListVO(Wrapper<CheliangjiankongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheliangjiankongVO selectVO(Wrapper<CheliangjiankongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheliangjiankongView> selectListView(Wrapper<CheliangjiankongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangjiankongView selectView(Wrapper<CheliangjiankongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
