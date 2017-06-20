package bjut.sse.council.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="t_staff_info")

@NamedQueries ( {
  @NamedQuery ( name="StaffInfo.countAll", query="SELECT COUNT(x) FROM StaffInfo x" )
} )

public class StaffInfo implements Serializable{

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

    @Column(name="email", nullable=false,length=30)
	String email;
    
    @Column(name="name", nullable=false,length=10)
	String name;
    
    @Column(name="phone", nullable=false,length=13)
	Integer phone;
    
    @Column(name="state", nullable=false)
	Boolean state;
    
    @Column(name="del_flag", nullable=false)
	Boolean del_flag;    
    
    @Column(name="stop_flag", nullable=false)
	Boolean stop_flag;
    
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    public StaffInfo(){ super(); }
    
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

	public Boolean getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(Boolean del_flag) {
		this.del_flag = del_flag;
	}

	public Boolean getStop_flag() {
		return stop_flag;
	}

	public void setStop_flag(Boolean stop_flag) {
		this.stop_flag = stop_flag;
	}

	//-----------------------------------------------
    // toString METHOD
    //-----------------------------------------------
	@Override
	public String toString() {
		return "StaffInfo [id=" + id + ", departID=" + departID + ", email=" + email + ", name=" + name + ", phone="
				+ phone + ", state=" + state + ", del_flag=" + del_flag + ", stop_flag=" + stop_flag + "]";
	}
}

