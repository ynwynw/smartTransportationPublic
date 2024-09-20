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


import com.dao.XinhaodengkongzhiDao;
import com.entity.XinhaodengkongzhiEntity;
import com.service.XinhaodengkongzhiService;
import com.entity.vo.XinhaodengkongzhiVO;
import com.entity.view.XinhaodengkongzhiView;

@Service("xinhaodengkongzhiService")
public class XinhaodengkongzhiServiceImpl extends ServiceImpl<XinhaodengkongzhiDao, XinhaodengkongzhiEntity> implements XinhaodengkongzhiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinhaodengkongzhiEntity> page = this.selectPage(
                new Query<XinhaodengkongzhiEntity>(params).getPage(),
                new EntityWrapper<XinhaodengkongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinhaodengkongzhiEntity> wrapper) {
		  Page<XinhaodengkongzhiView> page =new Query<XinhaodengkongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinhaodengkongzhiVO> selectListVO(Wrapper<XinhaodengkongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinhaodengkongzhiVO selectVO(Wrapper<XinhaodengkongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinhaodengkongzhiView> selectListView(Wrapper<XinhaodengkongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinhaodengkongzhiView selectView(Wrapper<XinhaodengkongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
