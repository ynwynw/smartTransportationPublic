package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiaotonggonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiaotonggonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiaotonggonggaoView;


/**
 * 交通公告评论表
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface DiscussjiaotonggonggaoService extends IService<DiscussjiaotonggonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiaotonggonggaoVO> selectListVO(Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
   	
   	DiscussjiaotonggonggaoVO selectVO(@Param("ew") Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
   	
   	List<DiscussjiaotonggonggaoView> selectListView(Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
   	
   	DiscussjiaotonggonggaoView selectView(@Param("ew") Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiaotonggonggaoEntity> wrapper);
   	

}

