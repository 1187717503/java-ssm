package com.sy.service;

import java.util.List;

import com.sy.entity.RewardCash;

public interface RewardService {
	boolean insertReward(RewardCash rc);

	List<RewardCash> selectReward(String phone);
}
