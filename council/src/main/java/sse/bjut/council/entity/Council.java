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
    @Column(name="reserve_id", nullable=false, length=10)
    Integer reserveId;
    
    @Column(name="name", nullable=false, length=45)
	String name;
    
    @Column(name="attendance", nullable=false, length=5)
	String attendance;
    
    @Column(name="start_time", nullable=false)
	Date startTime;
    
    @Column(name="end_time", nullable=false)
	Date endTime;    
    
    @Column(name="info", nullable=false, length=200)
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
	public Integer getReserveId() {
		return reserveId;
	}
	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
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
		return "Council [id=" + id + ", reserveId=" + reserveId + ", name=" + name + ", attendance=" + attendance
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", info=" + info + ", state=" + state + "]";
	}
}