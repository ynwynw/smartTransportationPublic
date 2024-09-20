package com.dao;

import com.entity.CheliangjiankongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangjiankongVO;
import com.entity.view.CheliangjiankongView;


/**
 * 车辆监控
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface CheliangjiankongDao extends BaseMapper<CheliangjiankongEntity> {
	
	List<CheliangjiankongVO> selectListVO(@Param("ew") Wrapper<CheliangjiankongEntity> wrapper);
	
	CheliangjiankongVO selectVO(@Param("ew") Wrapper<CheliangjiankongEntity> wrapper);
	
	List<CheliangjiankongView> selectListView(@Param("ew") Wrapper<CheliangjiankongEntity> wrapper);

	List<CheliangjiankongView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangjiankongEntity> wrapper);
	
	CheliangjiankongView selectView(@Param("ew") Wrapper<CheliangjiankongEntity> wrapper);
	

}
