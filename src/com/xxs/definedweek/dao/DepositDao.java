package com.xxs.definedweek.dao;

import com.xxs.definedweek.bean.Pager;
import com.xxs.definedweek.entity.Deposit;
import com.xxs.definedweek.entity.Member;

/**
 * Dao接口 - 预存款记录

 * KEY: DEFINEDWEEKC86D24D8CE4761CA10DA3E75C9E4A605

 */

public interface DepositDao extends BaseDao<Deposit, String> {
	
	/**
	 * 根据Member、Pager获取充值记录分页对象
	 * 
	 * @param member
	 *            Member对象
	 *            
	 * @param pager
	 *            Pager对象
	 *            
	 * @return 充值记录分页对象
	 */
	public Pager getDepositPager(Member member, Pager pager);

}