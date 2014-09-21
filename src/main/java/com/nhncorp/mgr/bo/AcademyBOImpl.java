package com.nhncorp.mgr.bo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nhncorp.mgr.dao.AcademyDAO;
import com.nhncorp.mgr.vo.Academy;

@Service("academyBO")
public class AcademyBOImpl implements AcademyBO{

	@Resource(name = "academyDAO")
    private AcademyDAO academyDAO;
	
	@Override
	public List<Academy> readAcademyList(){
		
		return academyDAO.selectAcademyList();
	}

	@Override
	public Academy readAcademy(String code){
		
		return academyDAO.selectAcademyByCode(code);
	}
	
	@Override
	public void addAcademy(Academy academy){
		
		academyDAO.insertAcademy(academy);
	}
	
	@Override
	public void editAcademy(Academy academy){
		
		academyDAO.updateAcademy(academy);
	}
	
	@Override
	public void removeAcademy(String code){
		
		academyDAO.deleteAcademy(code);
	}

}
