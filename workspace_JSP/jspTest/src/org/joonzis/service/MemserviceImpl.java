package org.joonzis.service;

import org.joonzis.dao.MDao;
import org.joonzis.dao.MDaoImpl;
import org.joonzis.vo.MVO;

public class MemserviceImpl implements MemService{
	private MDao dao = MDaoImpl.getInstance();
	
	@Override
	public int getJoin(MVO mvo) {
		return dao.getJoin(mvo);
	}
	@Override
	public int ckMember(MVO mvo) {
		return dao.ckMember(mvo);
	}
	@Override
	public MVO getmidx(MVO mvo) {
		return dao.getmidx(mvo);
	}
}
