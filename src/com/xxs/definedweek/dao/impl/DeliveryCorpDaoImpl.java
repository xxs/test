package com.xxs.definedweek.dao.impl;

import java.util.Set;

import com.xxs.definedweek.dao.DeliveryCorpDao;
import com.xxs.definedweek.entity.DeliveryCorp;
import com.xxs.definedweek.entity.DeliveryType;

import org.springframework.stereotype.Repository;

/**
 * Dao实现类 - 物流公司

 * KEY: DEFINEDWEEKF0400687AD25DC4E2A5F07E2A159A507

 */

@Repository("deliveryCorpDaoImpl")
public class DeliveryCorpDaoImpl extends BaseDaoImpl<DeliveryCorp, String> implements DeliveryCorpDao {

	// 关联处理
	@Override
	public void delete(DeliveryCorp deliveryCorp) {
		Set<DeliveryType> deliveryTypeSet = deliveryCorp.getDeliveryTypeSet();
		if (deliveryTypeSet != null) {
			for (DeliveryType deliveryType : deliveryTypeSet) {
				deliveryType.setDefaultDeliveryCorp(null);
			}
		}
		super.delete(deliveryCorp);
	}

	// 关联处理
	@Override
	public void delete(String id) {
		DeliveryCorp deliveryCorp = load(id);
		this.delete(deliveryCorp);
	}

	// 关联处理
	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			DeliveryCorp deliveryCorp = load(id);
			this.delete(deliveryCorp);
		}
	}

}