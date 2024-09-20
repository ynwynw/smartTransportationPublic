package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaotonggonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaotonggonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaotonggonggaoView;


/**
 * 交通公告
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface JiaotonggonggaoService extends IService<JiaotonggonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaotonggonggaoVO> selectListVO(Wrapper<JiaotonggonggaoEntity> wrapper);
   	
   	JiaotonggonggaoVO selectVO(@Param("ew") Wrapper<JiaotonggonggaoEntity> wrapper);
   	
   	List<JiaotonggonggaoView> selectListView(Wrapper<JiaotonggonggaoEntity> wrapper);
   	
   	JiaotonggonggaoView selectView(@Param("ew") Wrapper<JiaotonggonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaotonggonggaoEntity> wrapper);
   	

}

