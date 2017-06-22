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
@Table(name="t_council_att_info")

@NamedQueries ( {
  @NamedQuery ( name="CouncilAttendance.countAll", query="SELECT COUNT(x) FROM CouncilAttendance x" )
} )

public class CouncilAttendance implements Serializable{
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
	    @Column(name="att_id", nullable=false,length=10)
	    Integer attId;
	    
	    @Column(name="council_id", nullable=false,length=10)
	    Integer councilId;

	    @Column(name="del_flag", nullable=false)
		Boolean delFlag = false;
	    //-----------------------------------------------
	    // CONSTRUCTOR(S)
	    //-----------------------------------------------
	    public CouncilAttendance(){ super(); }
	    //-----------------------------------------------
	    // GETTER & SETTER FOR THE KEY FIELD
	    //-----------------------------------------------
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getAttId() {
			return attId;
		}
		public void setAttId(Integer attId) {
			this.attId = attId;
		}
		public Integer getCouncilId() {
			return councilId;
		}
		public void setCouncilId(Integer councilId) {
			this.councilId = councilId;
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
			return "CouncilAttendance [id=" + id + ", attId=" + attId + ", councilId=" + councilId + ", delFlag="
					+ delFlag + "]";
		}
		
}