package net.shopxx.dao;

import net.shopxx.bean.Pager;
import net.shopxx.entity.LeaveMessage;

/**
 * Dao接口 - 在线留言
 * ============================================================================
 * 版权所有 2008-2010 长沙鼎诚软件有限公司,并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得SHOP++商业授权之前,您不能将本软件应用于商业用途,否则SHOP++将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.shopxx.net
 * ----------------------------------------------------------------------------
 * KEY: SHOPXX3A0B882ABE9AC561AB89D38D5F32E2BA
 * ============================================================================
 */

public interface LeaveMessageDao extends BaseDao<LeaveMessage, String> {
	
	/**
	 * 根据Pager获取在线留言分页对象（不包含回复）
	 *            
	 * @param pager
	 *            Pager对象
	 * 
	 * @param isContainUnReply
	 *            是否包含未回复在线留言
	 *            
	 * @return 在线留言分页对象
	 */
	public Pager getLeaveMessagePager(Pager pager, boolean isContainUnReply);
	
}