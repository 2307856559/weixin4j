package com.foxinmy.weixin4j.mp.payment.coupon;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.mp.payment.v3.ApiResult;
import com.foxinmy.weixin4j.mp.type.CouponStockStatus;
import com.foxinmy.weixin4j.mp.type.CouponType;
import com.foxinmy.weixin4j.util.DateUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 代金券信息
 * 
 * @className CouponStock
 * @author jy
 * @date 2015年3月27日
 * @since JDK 1.7
 * @see
 */
public class CouponStock extends ApiResult {

	private static final long serialVersionUID = -8627202879200080499L;

	/**
	 * 代金券批次ID
	 */
	@XStreamAlias("coupon_stock_id")
	@JSONField(name = "coupon_stock_id")
	private String couponStockId;
	/**
	 * 代金券名称
	 */
	@XStreamAlias("coupon_name")
	@JSONField(name = "coupon_name")
	private String couponName;
	/**
	 * 代金券面额
	 */
	@XStreamAlias("coupon_value")
	@JSONField(name = "coupon_value")
	private int couponValue;
	/**
	 * 代金券使用最低限额
	 */
	@XStreamAlias("coupon_mininumn")
	@JSONField(name = "coupon_mininumn")
	private Integer couponMininumn;
	/**
	 * 代金券类型：1-代金券无门槛，2-代金券有门槛互斥，3-代金券有门槛叠加
	 */
	@XStreamAlias("coupon_type")
	@JSONField(name = "coupon_type")
	private int couponType;
	/**
	 * 批次状态: 1-未激活；2-审批中；4-已激活；8-已作废；16-中止发放；
	 */
	@XStreamAlias("coupon_stock_status")
	@JSONField(name = "coupon_stock_status")
	private int couponStockStatus;
	/**
	 * 代金券数量
	 */
	@XStreamAlias("coupon_total")
	@JSONField(name = "coupon_total")
	private int couponTotal;
	/**
	 * 代金券每个人最多能领取的数量, 如果为0，则表示没有限制
	 */
	@XStreamAlias("max_quota")
	@JSONField(name = "max_quota")
	private Integer maxQuota;
	/**
	 * 代金券锁定数量
	 */
	@XStreamAlias("locked_num")
	@JSONField(name = "locked_num")
	private Integer lockedNum;
	/**
	 * 代金券已使用数量
	 */
	@XStreamAlias("used_num")
	@JSONField(name = "used_num")
	private Integer usedNum;
	/**
	 * 代金券已经发送的数量
	 */
	@XStreamAlias("is_send_num")
	@JSONField(name = "is_send_num")
	private Integer sendNum;
	/**
	 * 生效开始时间 格式为yyyyMMddhhmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 */
	@XStreamAlias("begin_time")
	@JSONField(name = "begin_time")
	private String beginTime;
	/**
	 * 生效结束时间 格式为yyyyMMddhhmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 */
	@XStreamAlias("end_time")
	@JSONField(name = "end_time")
	private String endTime;
	/**
	 * 创建时间 格式为yyyyMMddhhmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 */
	@XStreamAlias("create_time")
	@JSONField(name = "create_time")
	private String createTime;
	/**
	 * 代金券预算额度
	 */
	@XStreamAlias("coupon_budget")
	@JSONField(name = "coupon_budget")
	private Integer couponBudget;

	public String getCouponStockId() {
		return couponStockId;
	}

	public String getCouponName() {
		return couponName;
	}

	public int getCouponValue() {
		return couponValue;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatCouponValue() {
		return couponValue / 100d;
	}

	public Integer getCouponMininumn() {
		return couponMininumn;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatCouponMininumn() {
		return couponMininumn != null ? couponMininumn.intValue() / 100d : 0d;
	}

	public int getCouponType() {
		return couponType;
	}

	@JSONField(deserialize = false, serialize = false)
	public CouponType getFormatCouponType() {
		for (CouponType couponType : CouponType.values()) {
			if (couponType.getVal() == this.couponType) {
				return couponType;
			}
		}
		return null;
	}

	public int getCouponStockStatus() {
		return couponStockStatus;
	}

	@JSONField(deserialize = false, serialize = false)
	public CouponStockStatus getFormatCouponStockStatus() {
		for (CouponStockStatus couponStockStatus : CouponStockStatus.values()) {
			if (couponStockStatus.getVal() == this.couponStockStatus) {
				return couponStockStatus;
			}
		}
		return null;
	}

	public int getCouponTotal() {
		return couponTotal;
	}

	public Integer getMaxQuota() {
		return maxQuota;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatMaxQuota() {
		return maxQuota != null ? maxQuota.intValue() / 100d : 0d;
	}

	public Integer getLockedNum() {
		return lockedNum;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatLockedNum() {
		return lockedNum != null ? lockedNum.intValue() / 100d : 0d;
	}

	public Integer getUsedNum() {
		return usedNum;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatUsedNum() {
		return usedNum != null ? usedNum.intValue() / 100d : 0d;
	}

	public Integer getSendNum() {
		return sendNum;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatSendNum() {
		return sendNum != null ? sendNum.intValue() / 100d : 0d;
	}

	public String getBeginTime() {
		return beginTime;
	}

	@JSONField(deserialize = false, serialize = false)
	public Date getFormatBeginTime() {
		return DateUtil.parse2yyyyMMddHHmmss(beginTime);
	}

	public String getEndTime() {
		return endTime;
	}

	@JSONField(deserialize = false, serialize = false)
	public Date getFormatEndTime() {
		return DateUtil.parse2yyyyMMddHHmmss(endTime);
	}

	public String getCreateTime() {
		return createTime;
	}

	@JSONField(deserialize = false, serialize = false)
	public Date getFormatCreateTime() {
		return DateUtil.parse2yyyyMMddHHmmss(createTime);
	}

	public Integer getCouponBudget() {
		return couponBudget;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatCouponBudget() {
		return couponBudget != null ? couponBudget.intValue() / 100d : 0d;
	}

	@Override
	public String toString() {
		return "CouponDetail [couponStockId=" + couponStockId + ", couponName="
				+ couponName + ", couponValue=" + getFormatCouponValue()
				+ ", couponMininumn=" + getFormatCouponMininumn()
				+ ", couponType=" + getFormatCouponType()
				+ ", couponStockStatus=" + getFormatCouponStockStatus()
				+ ", couponTotal=" + couponTotal + ", maxQuota="
				+ getFormatMaxQuota() + ", lockedNum=" + getFormatLockedNum()
				+ ", usedNum=" + getFormatUsedNum() + ", sendNum="
				+ getFormatSendNum() + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", createTime=" + createTime
				+ ", couponBudget=" + getFormatCouponBudget() + ", "
				+ super.toString() + "]";
	}
}
