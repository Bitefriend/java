package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.MDao;
import org.joonzis.dao.MDaoImpl;
import org.joonzis.dto.MemberDTO;


public class MemserviceImpl implements MemService{
	private MDao dao = MDaoImpl.getInstance();
	
	@Override
	public List<MemberDTO> getMemberList() {
		return dao.getList();
	}

}
