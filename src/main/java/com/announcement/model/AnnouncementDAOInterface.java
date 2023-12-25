package com.announcement.model;

import java.util.List;

public interface AnnouncementDAOInterface {
	public void insert(AnnouncementVO announcementVO);

	public void update(AnnouncementVO announcementVO);

	public void delete(Integer annId);

	public AnnouncementVO findByPrimaryKey(Integer annId);

	public List<AnnouncementVO> getAll();

}
