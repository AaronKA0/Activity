package com.venuetype.model;

import java.util.*;

public interface VenueTypeDAO_interface {
          public void insert(VenueTypeVO venueTypeVO);
          public void update(VenueTypeVO venueTypeVO);
          public void delete(Integer venueTypeId);
          public VenueTypeVO findByPrimaryKey(Integer venueTypeId);
          public List<VenueTypeVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<VenueTypeVO> getAll(Map<String, String[]> map); 
}
