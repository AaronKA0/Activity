package com.venue.model;

import java.util.List;

public interface VenueDAO_interface {
    public Integer insert(VenueVO venueTypeVO);
    public void update(VenueVO venueTypeVO);
    public void delete(Integer venueTypeId);
    public VenueVO findByPrimaryKey(Integer venueTypeId);
    public List<VenueVO> getAll();
    public boolean isVenueUsed(String venueName);
    
    
//  public List<VenueTypeVO> getAll(Map<String, String[]> map); 
}
