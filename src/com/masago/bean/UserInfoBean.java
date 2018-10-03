/**
 *
 */
/**
 * @author user
 *
 */
package com.masago.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoBean {

	private String userId;
    private String userName;
    private String password;
    private String telNumber;
    private String mailAddress;
    private String authorityCd;
    private String memo;
    private String delFlg;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;
    private String authorityName;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getAuthorityCd() {
		return authorityCd;
	}
	public void setAuthorityCd(String authorityCd) {
		this.authorityCd = authorityCd;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDate() {
		String dateString = sdf.format(createDate);
		return dateString;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateDate() {
		String dateString = sdf.format(updateDate);
		return dateString;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
}