package com.xxs.definedweek.service;

import com.xxs.definedweek.entity.Payment;

/**
 * Service接口 - 支付

 * KEY: DEFINEDWEEKB7C9CABB5231718C0C92BE618D9B5D15

 */

public interface PaymentService extends BaseService<Payment, String> {

	/**
	 * 获取最后生成的支付编号
	 * 
	 * @return 支付编号
	 */
	public String getLastPaymentSn();
	
	/**
	 * 根据支付编号获取对象（若对象不存在,则返回null）
	 * 
	 * @return 支付对象
	 */
	public Payment getPaymentByPaymentSn(String paymentSn);

}