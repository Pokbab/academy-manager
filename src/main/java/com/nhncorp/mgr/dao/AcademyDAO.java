package com.nhncorp.mgr.dao;

import java.util.List;

import com.nhncorp.mgr.vo.Academy;

public interface AcademyDAO {

	List<Academy> selectAcademyList();

	Academy selectAcademyByCode(String code);

	void insertAcademy(Academy academy);

	void updateAcademy(Academy academy);

	void deleteAcademy(String code);

}
