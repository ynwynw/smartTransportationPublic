package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiaotongliuliangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiaotongliuliangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiaotongliuliangView;


/**
 * 交通流量评论表
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface DiscussjiaotongliuliangService extends IService<DiscussjiaotongliuliangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiaotongliuliangVO> selectListVO(Wrapper<DiscussjiaotongliuliangEntity> wrapper);
   	
   	DiscussjiaotongliuliangVO selectVO(@Param("ew") Wrapper<DiscussjiaotongliuliangEntity> wrapper);
   	
   	List<DiscussjiaotongliuliangView> selectListView(Wrapper<DiscussjiaotongliuliangEntity> wrapper);
   	
   	DiscussjiaotongliuliangView selectView(@Param("ew") Wrapper<DiscussjiaotongliuliangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiaotongliuliangEntity> wrapper);
   	

}

