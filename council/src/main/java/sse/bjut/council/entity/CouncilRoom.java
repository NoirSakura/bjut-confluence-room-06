package sse.bjut.council.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_council_room_info")

@NamedQueries ( {
  @NamedQuery ( name="CouncilRoom.countAll", query="SELECT COUNT(x) FROM CouncilRoom x" )
} )

public class CouncilRoom implements Serializable{
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
    @Column(name="room_no", nullable=false,length=4)
    Integer roomNo;
    
    @Column(name="room_name", nullable=false,length=10)
	String roomName;
    
    @Column(name="max_number", nullable=false,length=5)
    Integer maxNumber;
    
    @Column(name="note", nullable=false,length=200)
	String note;
    
    @Column(name="del_flag", nullable=false)
	Boolean delFlag = false;    
    
    @Column(name="stop_flag", nullable=false)
	Short stopFlag = 0;   
    
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    public CouncilRoom(){ super(); }
    
    //-----------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //-----------------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Short getStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(Short stopFlag) {
		this.stopFlag = stopFlag;
	}

	//-----------------------------------------------
    // toString METHOD
    //-----------------------------------------------
	@Override
	public String toString() {
		return "CouncilRoom [id=" + id + ", roomNo=" + roomNo + ", roomName=" + roomName + ", maxNumber="
				+ maxNumber + ", note=" + note + ", delFlag=" + delFlag + ", stopFlag=" + stopFlag + "]";
	}
	
}