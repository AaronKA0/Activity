package com.venuetype.model;

import java.util.List;

public class VenueTypeService {

	private VenueTypeDAO_interface dao;

	public VenueTypeService() {
		dao = new VenueTypeDAO();
	}

	public VenueTypeVO addVenueType(String venTypeName) {

		VenueTypeVO venueTypeVO = new VenueTypeVO();

		venueTypeVO.setVenTypeName(venTypeName);

		dao.insert(venueTypeVO);

		return venueTypeVO;
	}

	public VenueTypeVO updateVenueType(String venTypeName) {

		VenueTypeVO venueTypeVO = new VenueTypeVO();

		venueTypeVO.setVenTypeName(venTypeName);
		
		dao.update(venueTypeVO);

		return venueTypeVO;
	}

	public void deleteVenueType(Integer venueTypeId) {
		dao.delete(venueTypeId);
	}

	public VenueTypeVO getOneVenueType(Integer venueTypeId) {
		return dao.findByPrimaryKey(venueTypeId);
	}

	public List<VenueTypeVO> getAll() {
		return dao.getAll();
	}

}
