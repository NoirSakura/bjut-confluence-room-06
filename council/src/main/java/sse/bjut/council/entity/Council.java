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
@Table(name="t_council_info")

@NamedQueries ( {
  @NamedQuery ( name="Council.countAll", query="SELECT COUNT(x) FROM Council x" )
} )

public class Council implements Serializable{
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
    @Column(name="council_room_id", nullable=false, length=4)
    Integer councilRoomID;
    
    @Column(name="reserve_id", nullable=false, length=10)
    Integer reserveID;

    @Column(name="reserve_name", nullable=false, length=10)
	String reserveName;  
    
    @Column(name="name", nullable=false, length=45)
	String name;
    
    @Column(name="attendance", nullable=false, length=5)
	String attendance;
    
    @Column(name="start_time", nullable=false)
	Date startTime;
    
    @Column(name="end_time", nullable=false)
	Date endTime;    

    @Column(name="reserve_time", nullable=false)
	Date reserveTime;  
    
    @Column(name="info", length=200)
	String info;   
    
    @Column(name="state", nullable=false)
	Integer state = 0;
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    
    public Council(){ super(); }
    
    //-----------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //-----------------------------------------------
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCouncilRoomID() {
		return councilRoomID;
	}
	public void setCouncilRoomID(Integer councilRoomID) {
		this.councilRoomID = councilRoomID;
	}
	public Integer getReserveID() {
		return reserveID;
	}
	public void setReserveID(Integer reserveID) {
		this.reserveID = reserveID;
	}
	public String getReserveName() {
		return reserveName;
	}
	public void setReserveName(String reserveName) {
		this.reserveName = reserveName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	//-----------------------------------------------
    // toString METHOD
    //-----------------------------------------------
	@Override
	public String toString() {
		return "Council [id=" + id + ", councilRoomID=" + councilRoomID + ", reserveID=" + reserveID + ", reserveName="
				+ reserveName + ", name=" + name + ", attendance=" + attendance + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", reserveTime=" + reserveTime + ", info=" + info + ", state=" + state + "]";
	}
	
}