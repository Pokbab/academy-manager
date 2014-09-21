package com.nhncorp.mgr.bo;

import java.util.List;

import com.nhncorp.mgr.vo.Academy;

public interface AcademyBO {

	List<Academy> readAcademyList();

	Academy readAcademy(String code);

	void addAcademy(Academy academy);

	void editAcademy(Academy academy);

	void removeAcademy(String code);

}
