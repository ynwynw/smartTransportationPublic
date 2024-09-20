package com.dao;

import com.entity.JiaotongliuliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaotongliuliangVO;
import com.entity.view.JiaotongliuliangView;


/**
 * 交通流量
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface JiaotongliuliangDao extends BaseMapper<JiaotongliuliangEntity> {
	
	List<JiaotongliuliangVO> selectListVO(@Param("ew") Wrapper<JiaotongliuliangEntity> wrapper);
	
	JiaotongliuliangVO selectVO(@Param("ew") Wrapper<JiaotongliuliangEntity> wrapper);
	
	List<JiaotongliuliangView> selectListView(@Param("ew") Wrapper<JiaotongliuliangEntity> wrapper);

	List<JiaotongliuliangView> selectListView(Pagination page,@Param("ew") Wrapper<JiaotongliuliangEntity> wrapper);
	
	JiaotongliuliangView selectView(@Param("ew") Wrapper<JiaotongliuliangEntity> wrapper);
	

}
