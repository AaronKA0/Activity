package com.act.model;

import java.util.List;

public class EmpService {

	private ActDAO_interface dao;

	public EmpService() {
		dao = new ActDAO();
	}

	public ActVO addEmp(String ename, String job, java.sql.Date hiredate,
			Double sal, Double comm, Integer deptno) {

		ActVO empVO = new ActVO();

		empVO.setEname(ename);
		empVO.setJob(job);
		empVO.setHiredate(hiredate);
		empVO.setSal(sal);
		empVO.setComm(comm);
		empVO.setDeptno(deptno);
		dao.insert(empVO);

		return empVO;
	}

	public ActVO updateEmp(Integer empno, String ename, String job,
			java.sql.Date hiredate, Double sal, Double comm, Integer deptno) {

		ActVO empVO = new ActVO();

		empVO.setEmpno(empno);
		empVO.setEname(ename);
		empVO.setJob(job);
		empVO.setHiredate(hiredate);
		empVO.setSal(sal);
		empVO.setComm(comm);
		empVO.setDeptno(deptno);
		dao.update(empVO);

		return empVO;
	}

	public void deleteEmp(Integer empno) {
		dao.delete(empno);
	}

	public ActVO getOneEmp(Integer empno) {
		return dao.findByPrimaryKey(empno);
	}

	public List<ActVO> getAll() {
		return dao.getAll();
	}
}
