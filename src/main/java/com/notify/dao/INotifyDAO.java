package com.notify.dao;

import java.util.List;

import com.notify.model.NotifyVO;

public interface INotifyDAO {

	int insert(NotifyVO entity);

	int update(NotifyVO entity);
	
//	int delete(Integer notifyId);
	 
	NotifyVO getById(Integer notifyId);
	
	List<NotifyVO> getAll();
	
//	List<NotifyVO> getByCompositeQuery(Map<String, String> map);
	
//	List<NotifyVO> getAll(int currentPage);
	
//	long getTotal();
}
