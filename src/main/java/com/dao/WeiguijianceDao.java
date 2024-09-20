package com.dao;

import com.entity.WeiguijianceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeiguijianceVO;
import com.entity.view.WeiguijianceView;


/**
 * 违规监测
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface WeiguijianceDao extends BaseMapper<WeiguijianceEntity> {
	
	List<WeiguijianceVO> selectListVO(@Param("ew") Wrapper<WeiguijianceEntity> wrapper);
	
	WeiguijianceVO selectVO(@Param("ew") Wrapper<WeiguijianceEntity> wrapper);
	
	List<WeiguijianceView> selectListView(@Param("ew") Wrapper<WeiguijianceEntity> wrapper);

	List<WeiguijianceView> selectListView(Pagination page,@Param("ew") Wrapper<WeiguijianceEntity> wrapper);
	
	WeiguijianceView selectView(@Param("ew") Wrapper<WeiguijianceEntity> wrapper);
	

}
