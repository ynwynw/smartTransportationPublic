package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaotongliuliangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaotongliuliangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaotongliuliangView;


/**
 * 交通流量
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface JiaotongliuliangService extends IService<JiaotongliuliangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaotongliuliangVO> selectListVO(Wrapper<JiaotongliuliangEntity> wrapper);
   	
   	JiaotongliuliangVO selectVO(@Param("ew") Wrapper<JiaotongliuliangEntity> wrapper);
   	
   	List<JiaotongliuliangView> selectListView(Wrapper<JiaotongliuliangEntity> wrapper);
   	
   	JiaotongliuliangView selectView(@Param("ew") Wrapper<JiaotongliuliangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaotongliuliangEntity> wrapper);
   	

}

