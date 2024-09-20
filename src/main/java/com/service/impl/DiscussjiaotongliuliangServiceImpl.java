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


import com.dao.DiscussjiaotongliuliangDao;
import com.entity.DiscussjiaotongliuliangEntity;
import com.service.DiscussjiaotongliuliangService;
import com.entity.vo.DiscussjiaotongliuliangVO;
import com.entity.view.DiscussjiaotongliuliangView;

@Service("discussjiaotongliuliangService")
public class DiscussjiaotongliuliangServiceImpl extends ServiceImpl<DiscussjiaotongliuliangDao, DiscussjiaotongliuliangEntity> implements DiscussjiaotongliuliangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiaotongliuliangEntity> page = this.selectPage(
                new Query<DiscussjiaotongliuliangEntity>(params).getPage(),
                new EntityWrapper<DiscussjiaotongliuliangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiaotongliuliangEntity> wrapper) {
		  Page<DiscussjiaotongliuliangView> page =new Query<DiscussjiaotongliuliangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjiaotongliuliangVO> selectListVO(Wrapper<DiscussjiaotongliuliangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiaotongliuliangVO selectVO(Wrapper<DiscussjiaotongliuliangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiaotongliuliangView> selectListView(Wrapper<DiscussjiaotongliuliangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiaotongliuliangView selectView(Wrapper<DiscussjiaotongliuliangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
