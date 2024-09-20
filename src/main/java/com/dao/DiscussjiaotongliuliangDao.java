package com.dao;

import com.entity.DiscussjiaotongliuliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiaotongliuliangVO;
import com.entity.view.DiscussjiaotongliuliangView;


/**
 * 交通流量评论表
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface DiscussjiaotongliuliangDao extends BaseMapper<DiscussjiaotongliuliangEntity> {
	
	List<DiscussjiaotongliuliangVO> selectListVO(@Param("ew") Wrapper<DiscussjiaotongliuliangEntity> wrapper);
	
	DiscussjiaotongliuliangVO selectVO(@Param("ew") Wrapper<DiscussjiaotongliuliangEntity> wrapper);
	
	List<DiscussjiaotongliuliangView> selectListView(@Param("ew") Wrapper<DiscussjiaotongliuliangEntity> wrapper);

	List<DiscussjiaotongliuliangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiaotongliuliangEntity> wrapper);
	
	DiscussjiaotongliuliangView selectView(@Param("ew") Wrapper<DiscussjiaotongliuliangEntity> wrapper);
	

}
