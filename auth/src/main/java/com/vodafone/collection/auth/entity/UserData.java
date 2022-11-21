package com.vodafone.collection.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "APP_USER_DATA")
public class UserData implements Serializable {


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_CODE")
	private Long userCode;

	@Column(name = "LEVEL_CODE")
	private Long levelCode;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "ACCT_EXPIRY_DATE")
	private Date accountExpiryDate;

	@Column(name = "ACTIVE_DATE")
	private Date activeDate;

	@Column(name = "STAFF_ID")
	private String staffId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CUSTOMER_STATUS")
	private Integer customerStatus;

	@Column(name = "CONTACT_REASON")
	private Long contactReason;

	@Column(name = "AMOUNT_TYPE")
	private Long amountType;

	@Column(name = "USER_PRICE_GROUP_KEY")
	private Long userPriceGroupKey;

	@Column(name = "SEGMENT_CODE")
	private Long segmentCode;

	@Column(name = "PAYMENT_LEVEL")
	private String paymentLevel;

	@Column(name = "BILL_CYCLE")
	private Long billCycle;

	@Column(name = "SCORE")
	private Integer score;

	@Column(name = "SEGMENT_MOVEMENT_ID")
	private Integer segmentMovementId;

	@Column(name = "SUSPENSION_DATE")
	private Date suspendedDate;

	@Column(name = "SUSPENSION_TO")
	private Date suspensionTo;

	@Column(name = "ACTIVE_FLAG")
	private Integer activeFlag;

	@Column(name = "LOCKED_FLAG")
	private Integer lockedFlag;

	@Column(name = "LOCK_EXPIRE")
	private Date lockExpire;

	@Column(name = "BSCS_USR_NAME")
	private String  bscsUserName;

	@Column(name = "BSCS_PASSWORD")
	private String  bscsPassword;

	@Column(name = "PASS_LAST_MODIFIED")
	private Date  passLastModified;

	@Column(name = "LAST_LOGIN")
	private Date  lastLogin;

	@Column(name = "IMPACT_ORDER")
	private Integer  impactOrder;

	@Column(name = "CURRENTLY_LOGGED_IN")
	private Integer  currentlyLoggedIn;

	public Long getUserCode() {
		return userCode;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public Long getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(Long levelCode) {
		this.levelCode = levelCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getAccountExpiryDate() {
		return accountExpiryDate;
	}

	public void setAccountExpiryDate(Date accountExpiryDate) {
		this.accountExpiryDate = accountExpiryDate;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Long getContactReason() {
		return contactReason;
	}

	public void setContactReason(Long contactReason) {
		this.contactReason = contactReason;
	}

	public Long getAmountType() {
		return amountType;
	}

	public void setAmountType(Long amountType) {
		this.amountType = amountType;
	}

	public Long getUserPriceGroupKey() {
		return userPriceGroupKey;
	}

	public void setUserPriceGroupKey(Long userPriceGroupKey) {
		this.userPriceGroupKey = userPriceGroupKey;
	}

	public Long getSegmentCode() {
		return segmentCode;
	}

	public void setSegmentCode(Long segmentCode) {
		this.segmentCode = segmentCode;
	}

	public String getPaymentLevel() {
		return paymentLevel;
	}

	public void setPaymentLevel(String paymentLevel) {
		this.paymentLevel = paymentLevel;
	}

	public Long getBillCycle() {
		return billCycle;
	}

	public void setBillCycle(Long billCycle) {
		this.billCycle = billCycle;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getSegmentMovementId() {
		return segmentMovementId;
	}

	public void setSegmentMovementId(Integer segmentMovementId) {
		this.segmentMovementId = segmentMovementId;
	}

	public Date getSuspendedDate() {
		return suspendedDate;
	}

	public void setSuspendedDate(Date suspendedDate) {
		this.suspendedDate = suspendedDate;
	}

	public Date getSuspensionTo() {
		return suspensionTo;
	}

	public void setSuspensionTo(Date suspensionTo) {
		this.suspensionTo = suspensionTo;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Integer getLockedFlag() {
		return lockedFlag;
	}

	public void setLockedFlag(Integer lockedFlag) {
		this.lockedFlag = lockedFlag;
	}

	public Date getLockExpire() {
		return lockExpire;
	}

	public void setLockExpire(Date lockExpire) {
		this.lockExpire = lockExpire;
	}

	public String getBscsUserName() {
		return bscsUserName;
	}

	public void setBscsUserName(String bscsUserName) {
		this.bscsUserName = bscsUserName;
	}

	public String getBscsPassword() {
		return bscsPassword;
	}

	public void setBscsPassword(String bscsPassword) {
		this.bscsPassword = bscsPassword;
	}

	public Date getPassLastModified() {
		return passLastModified;
	}

	public void setPassLastModified(Date passLastModified) {
		this.passLastModified = passLastModified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getImpactOrder() {
		return impactOrder;
	}

	public void setImpactOrder(Integer impactOrder) {
		this.impactOrder = impactOrder;
	}

	public Integer getCurrentlyLoggedIn() {
		return currentlyLoggedIn;
	}

	public void setCurrentlyLoggedIn(Integer currentlyLoggedIn) {
		this.currentlyLoggedIn = currentlyLoggedIn;
	}
}
