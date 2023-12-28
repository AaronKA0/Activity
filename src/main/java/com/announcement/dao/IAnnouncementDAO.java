package com.announcement.dao;

import java.util.List;

import com.announcement.model.AnnouncementVO;

public interface IAnnouncementDAO {
	int insert(AnnouncementVO entity);

	int update(AnnouncementVO entity);

//	int delete(Integer annId);

	AnnouncementVO getById(Integer annId);

	List<AnnouncementVO> getAll();

}
