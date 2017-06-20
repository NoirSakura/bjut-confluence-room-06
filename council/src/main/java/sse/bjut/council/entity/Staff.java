package sse.bjut.council.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="t_staff_info")

@NamedQueries ( {
  @NamedQuery ( name="Staff.countAll", query="SELECT COUNT(x) FROM Staff x" )
} )

public class Staff implements Serializable{

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
    @Column(name="depart_id", nullable=false,length=4)
	String departID;

    @Column(name="email", nullable=false, length=30)
	String email;
    
    @Column(name="name", nullable=false, length=10)
	String name;
    
    @Column(name="phone", nullable=false, length=13)
	Integer phone;
    
    @Column(name="state", nullable=false)
	Boolean state = false;
    
    @Column(name="del_flag", nullable=false)
	Boolean delFlag = false;    
    
    @Column(name="stop_flag", nullable=false)
	Boolean stopFlag = false;
    
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    public Staff(){ super(); }
    
    //-----------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //-----------------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartID() {
		return departID;
	}

	public void setDepartID(String departID) {
		this.departID = departID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Boolean getStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(Boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	//-----------------------------------------------
    // toString METHOD
    //-----------------------------------------------
	@Override
	public String toString() {
		return "Staff [id=" + id + ", departID=" + departID + ", email=" + email + ", name=" + name + ", phone="
				+ phone + ", state=" + state + ", delFlag=" + delFlag + ", stopFlag=" + stopFlag + "]";
	}
}