package bjut.sse.council.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="t_depart_info")

@NamedQueries ( {
  @NamedQuery ( name="DepartInfo.countAll", query="SELECT COUNT(x) FROM DepartInfo x" )
} )

public class DepartInfo implements Serializable{

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
	String managerID;
    
    @Column(name="depart_name", nullable=false,length=10)
	String departName;
    
    @Column(name="del_flag", nullable=false)
	Boolean del_flag;    
    
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    public DepartInfo(){ super(); }
    
    //-----------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //-----------------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Boolean getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(Boolean del_flag) {
		this.del_flag = del_flag;
	}

	//-----------------------------------------------
    // toString METHOD
    //-----------------------------------------------
	@Override
	public String toString() {
		return "DepartInfo [id=" + id + ", managerID=" + managerID + ", departName=" + departName + ", del_flag="
				+ del_flag + "]";
	}

}

