package com.dao;

import com.entity.DiscussjiaotonggonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiaotonggonggaoVO;
import com.entity.view.DiscussjiaotonggonggaoView;


/**
 * 交通公告评论表
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface DiscussjiaotonggonggaoDao extends BaseMapper<DiscussjiaotonggonggaoEntity> {
	
	List<DiscussjiaotonggonggaoVO> selectListVO(@Param("ew") Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
	
	DiscussjiaotonggonggaoVO selectVO(@Param("ew") Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
	
	List<DiscussjiaotonggonggaoView> selectListView(@Param("ew") Wrapper<DiscussjiaotonggonggaoEntity> wrapper);

	List<DiscussjiaotonggonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
	
	DiscussjiaotonggonggaoView selectView(@Param("ew") Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
	

}
