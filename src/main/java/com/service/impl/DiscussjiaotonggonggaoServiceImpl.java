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


import com.dao.DiscussjiaotonggonggaoDao;
import com.entity.DiscussjiaotonggonggaoEntity;
import com.service.DiscussjiaotonggonggaoService;
import com.entity.vo.DiscussjiaotonggonggaoVO;
import com.entity.view.DiscussjiaotonggonggaoView;

@Service("discussjiaotonggonggaoService")
public class DiscussjiaotonggonggaoServiceImpl extends ServiceImpl<DiscussjiaotonggonggaoDao, DiscussjiaotonggonggaoEntity> implements DiscussjiaotonggonggaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiaotonggonggaoEntity> page = this.selectPage(
                new Query<DiscussjiaotonggonggaoEntity>(params).getPage(),
                new EntityWrapper<DiscussjiaotonggonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiaotonggonggaoEntity> wrapper) {
		  Page<DiscussjiaotonggonggaoView> page =new Query<DiscussjiaotonggonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjiaotonggonggaoVO> selectListVO(Wrapper<DiscussjiaotonggonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiaotonggonggaoVO selectVO(Wrapper<DiscussjiaotonggonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiaotonggonggaoView> selectListView(Wrapper<DiscussjiaotonggonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiaotonggonggaoView selectView(Wrapper<DiscussjiaotonggonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
