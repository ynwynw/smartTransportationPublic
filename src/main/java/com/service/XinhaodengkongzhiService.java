package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinhaodengkongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinhaodengkongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinhaodengkongzhiView;


/**
 * 信号灯控制
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface XinhaodengkongzhiService extends IService<XinhaodengkongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinhaodengkongzhiVO> selectListVO(Wrapper<XinhaodengkongzhiEntity> wrapper);
   	
   	XinhaodengkongzhiVO selectVO(@Param("ew") Wrapper<XinhaodengkongzhiEntity> wrapper);
   	
   	List<XinhaodengkongzhiView> selectListView(Wrapper<XinhaodengkongzhiEntity> wrapper);
   	
   	XinhaodengkongzhiView selectView(@Param("ew") Wrapper<XinhaodengkongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinhaodengkongzhiEntity> wrapper);
   	

}

