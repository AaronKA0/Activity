package com.venue.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class VenueService {

	private VenueDAO_interface dao;

	public VenueService() {
		dao = new VenueDAO();
	}

	public VenueVO addVenue(String venName, Integer venTypeId, String venDescr, String venLoc, BigDecimal venPrice,
			Byte venStatus, Timestamp venModTime, Double venTotRating, Integer venRateCount, byte[] venPic) {

		VenueVO venueVO = new VenueVO();

		venueVO.setVenName(venName);
		venueVO.setVenTypeId(venTypeId);
		venueVO.setVenDescr(venDescr);
		venueVO.setVenLoc(venLoc);
		venueVO.setVenPrice(venPrice);
		venueVO.setVenStatus(venStatus);
		venueVO.setVenModTime(venModTime);
		venueVO.setVenTotRating(venTotRating);
		venueVO.setVenRateCount(venRateCount);
		venueVO.setVenPic(venPic);

		int key = dao.insert(venueVO);
		venueVO.setVenId(key);

		return venueVO;
	}

	public VenueVO updateVenue(Integer venId, String venName, byte[] venPic, Integer venTypeId, String venDescr, String venLoc, BigDecimal ven_Price, Byte venStatus) {

		VenueVO venueVO = new VenueVO();
		venueVO.setVenId(venId);
		venueVO.setVenName(venName);
		venueVO.setVenPic(venPic);
		venueVO.setVenTypeId(venTypeId);
		venueVO.setVenDescr(venDescr);
		venueVO.setVenLoc(venLoc);
		venueVO.setVenPrice(ven_Price);
		venueVO.setVenStatus(venStatus);
		
		dao.update(venueVO);

		return venueVO;
	}

//	public void deleteVenue(Integer venueId) {
//		dao.delete(venueId);
//	}

	public VenueVO getOneVenue(Integer venueId) {
		return dao.findByPrimaryKey(venueId);
	}
	
	public boolean isVenueUsed(String venueName) {
		return dao.isVenueUsed(venueName);
	}

	public List<VenueVO> getAll() {
		return dao.getAll();
	}

}
