package com.membership.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.membership.dao.MembershipDAO;
import com.membership.dao.IMembershipDAO;
import com.membership.model.MembershipVO;

public class MembershipService {

	private IMembershipDAO dao;

	public MembershipService() {
		dao = new MembershipDAO();
	}

	public MembershipVO addMembership(String memAcc, String memEmail, String memPwd, String memName, Byte memGender,
			Date memBirthdate, String memUsername, byte[] memPic, Byte isAccEna, Byte isPartEna, Byte isHostEna,
			Byte isRentEna, Byte isMsgEna) {

		MembershipVO membershipVO = new MembershipVO();

		membershipVO.setMemAcc(memAcc);
		membershipVO.setMemEmail(memEmail);
		membershipVO.setMemPwd(memPwd);
		membershipVO.setMemName(memName);
		membershipVO.setMemGender(memGender);
		membershipVO.setMemBirthdate(memBirthdate);
		membershipVO.setMemUsername(memUsername);
		membershipVO.setMemPic(memPic);
		membershipVO.setIsAccEna(isAccEna);
		membershipVO.setIsPartEna(isPartEna);
		membershipVO.setIsHostEna(isHostEna);
		membershipVO.setIsRentEna(isRentEna);
		membershipVO.setIsMsgEna(isMsgEna);

		dao.insert(membershipVO);

		return membershipVO;
	}

	public MembershipVO updateMembership(Integer memId, String memAcc, String memEmail, String memPwd, String memName,
			Byte memGender, Date memBirthdate, String memUsername, byte[] memPic, Byte isAccEna, Byte isPartEna,
			Byte isHostEna, Byte isRentEna, Byte isMsgEna) {

		MembershipVO membershipVO = new MembershipVO();

		membershipVO.setMemId(memId);
		membershipVO.setMemAcc(memAcc);
		membershipVO.setMemEmail(memEmail);
		membershipVO.setMemPwd(memPwd);
		membershipVO.setMemName(memName);
		membershipVO.setMemGender(memGender);
		membershipVO.setMemBirthdate(memBirthdate);
		membershipVO.setMemUsername(memUsername);
		membershipVO.setMemPic(memPic);
		membershipVO.setIsAccEna(isAccEna);
		membershipVO.setIsPartEna(isPartEna);
		membershipVO.setIsHostEna(isHostEna);
		membershipVO.setIsRentEna(isRentEna);
		membershipVO.setIsMsgEna(isMsgEna);
		dao.update(membershipVO);

		return membershipVO;
	}

	public void deleteMembership(Integer memId) {
		dao.delete(memId);
	}

	public MembershipVO getOneMembership(Integer memId) {
		return dao.findByPrimaryKey(memId);
	}

	public List<MembershipVO> getAll() {
		return dao.getAll();
	}

}
