package com.membership.dao;

import java.util.List;

import com.membership.model.MembershipVO;

public interface IMembershipDAO {

	public void insert(MembershipVO membershipVO);

	public void update(MembershipVO membershipVO);

	public void delete(Integer mimId);

	public MembershipVO findByPrimaryKey(Integer memId);

	public List<MembershipVO> getAll();

}
