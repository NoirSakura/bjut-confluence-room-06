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
@Table(name="t_council_cancel")

@NamedQueries ( {
  @NamedQuery ( name="CouncilCancel.countAll", query="SELECT COUNT(x) FROM CouncilCancel x" )
} )
public class CouncilCancel implements Serializable{
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
	    @Column(name="cancel_id", nullable=false,length=10)
	    Integer cancelId;
	    
	    @Column(name="cancel_time", nullable=false)
		Date cancelTime;
	    
	    @Column(name="cancel_reason", nullable=false,length=100)
		String cancelReason;
	    
	    //-----------------------------------------------
	    // CONSTRUCTOR(S)
	    //-----------------------------------------------
	    public CouncilCancel(){ super(); }
	    
	    //-----------------------------------------------
	    // GETTER & SETTER FOR THE KEY FIELD
	    //-----------------------------------------------
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getCancelId() {
			return cancelId;
		}

		public void setCancelId(Integer cancelId) {
			this.cancelId = cancelId;
		}

		public Date getCancelTime() {
			return cancelTime;
		}

		public void setCancelTime(Date cancelTime) {
			this.cancelTime = cancelTime;
		}

		public String getCancelReason() {
			return cancelReason;
		}

		public void setCancelReason(String cancelReason) {
			this.cancelReason = cancelReason;
		}
		//-----------------------------------------------
	    // toString METHOD
	    //-----------------------------------------------

		@Override
		public String toString() {
			return "CouncilCancel [id=" + id + ", cancelId=" + cancelId + ", cancelTime=" + cancelTime
					+ ", cancelReason=" + cancelReason + "]";
		}      
}