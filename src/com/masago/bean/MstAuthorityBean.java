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

public class MstAuthorityBean {

	private String authorityCd;
    private String authorityName;
    private String memo;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
	public String getAuthorityCd() {
		return authorityCd;
	}
	public void setAuthorityCd(String authorityCd) {
		this.authorityCd = authorityCd;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
}