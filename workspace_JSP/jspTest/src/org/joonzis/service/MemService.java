package org.joonzis.service;

import org.joonzis.vo.MVO;

public interface MemService {
	public int getJoin(MVO mvo);
	public int ckMember(MVO mvo);
	public MVO getmidx(MVO mvo);
}
