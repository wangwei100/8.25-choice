package com.demohot.choose.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demohot.choose.mapper.LessionMapper;
import com.demohot.choose.mapper.UserLessionMapper;
import com.demohot.choose.model.UserLession;
import com.demohot.choose.service.LessionService;
import com.demohot.choose.utils.MyException;

@Service
public class LessionServiceImpl implements LessionService {
	@Autowired
	private UserLessionMapper userLessionMapper;

	@Autowired
	private LessionMapper lessionMapper;

	@Override
	@Transactional
	public void choiceLession(Integer user_id, Integer lession_id) {
		int reduceRemainNumber = lessionMapper.reduceRemain(lession_id);
		if (reduceRemainNumber == 0) {
			throw new MyException("课不足");
		}
		UserLession ul = new UserLession();
		ul.setUser_id(user_id);
		ul.setLession_id(lession_id);
		UserLession byUserIdLessionId = userLessionMapper.getByUserIdLessionId(user_id, lession_id);
		if (null != byUserIdLessionId) {
			throw new MyException("此课已选");
		}
		userLessionMapper.insert(ul);
	}

	public void allCount(Integer user_id) {
		int allCountNumber = userLessionMapper.countByUserId(user_id);
		if (allCountNumber >= 3) {
			throw new MyException("已选课程不能超过三门");
		}
	}
}
