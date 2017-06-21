package sse.bjut.council.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="t_depart_info")

@NamedQueries ( {
  @NamedQuery ( name="Depart.countAll", query="SELECT COUNT(x) FROM Depart x" )
} )

public class Depart implements Serializable{

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
    @Column(name="manager_id", nullable=false,length=10)
    Integer managerID = 0;
    
    @Column(name="depart_name", nullable=false,length=10)
	String departName;
    
    @Column(name="del_flag", nullable=false)
	Boolean delFlag  = false;    
    
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    public Depart(){ super(); }
    
    //-----------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //-----------------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getManagerID() {
		return managerID;
	}

	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
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
		return "Depart [id=" + id + ", managerID=" + managerID + ", departName=" + departName + ", delFlag="
				+ delFlag + "]";
	}

}
