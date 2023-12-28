package com.faq.dao;

import java.util.List;

import com.faq.model.FaqVO;

public interface IFaqDAO {

	int insert(FaqVO entity);

	int update(FaqVO entity);

//	int delete(Integer faqId);

	FaqVO getById(Integer faqId);

	List<FaqVO> getAll();

}
