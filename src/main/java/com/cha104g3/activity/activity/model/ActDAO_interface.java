package com.act.model;

import java.util.*;

public interface ActDAO_interface {
          public void insert(ActVO actVO);
          public void update(ActVO actVO);
          public void delete(Integer act_id);
          public ActVO findByPrimaryKey(Integer act_id);
          public List<ActVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
