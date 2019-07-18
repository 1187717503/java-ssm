package com.sy.dao;

import java.util.List;

import com.sy.entity.RewardCash;

public interface RewardDao {
	void insertReward(RewardCash rc);

	List<RewardCash> selectReward(String phone);
}
