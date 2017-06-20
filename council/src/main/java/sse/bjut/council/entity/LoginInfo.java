package sse.bjut.council.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_login_info")

@NamedQueries ( {
  @NamedQuery ( name="LoginInfo.countAll", query="SELECT COUNT(x) FROM LoginInfo x" )
} )

public class LoginInfo implements Serializable{
	private static final long serialVersionUID = 1L;

    //-----------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------- 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Integer id;
    
    //-----------------------------------------------
    // ENTITY DATA FIELDS
    //-----------------------------------------------
    @Column(name="staff_id", nullable=false,length=10)
    Integer staffId;
    
    @Column(name="account", nullable=false,length=30)
	String account;
    
    @Column(name="password", nullable=false,length=30)
	String password;
    
    @Column(name="last_login_time", nullable=false)
	Date lastloginTime;
    
    @Column(name="privilege", nullable=false)
    Boolean privilege  = false;    
    
    @Column(name="del_flag", nullable=false)
	Boolean delFlag = false; 
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    
    public LoginInfo(){ super(); }
    
    //-----------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //-----------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastloginTime() {
		return lastloginTime;
	}

	public void setLastloginTime(Date lastloginTime) {
		this.lastloginTime = lastloginTime;
	}

	public Boolean getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Boolean privilege) {
		this.privilege = privilege;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	
	//-----------------------------------------------
    // toString METHOD
    //-----------------------------------------------
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", staffId=" + staffId + ", account=" + account + ", password=" + password
				+ ", lastloginTime=" + lastloginTime + ", privilege=" + privilege + ", delFlag=" + delFlag + "]";
	}
}