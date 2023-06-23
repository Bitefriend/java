package org.joonzis.dao;

import org.joonzis.vo.MVO;

public interface MDao {
	public int getJoin(MVO mvo);
	public int ckMember(MVO mvo);
	public MVO getmidx(MVO mvo);

}
