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
@Table(name="t_logging")

@NamedQueries ( {
  @NamedQuery ( name="Logging.countAll", query="SELECT COUNT(x) FROM Logging x" )
} )

public class Logging implements Serializable{
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
    @Column(name="oper_id", nullable=false,length=10)
    Integer operId;
    
    @Column(name="datetime", nullable=false)
	Date datetime;
    
    @Column(name="level", nullable=false)
	Integer level = 0;
    
    //-----------------------------------------------
    // CONSTRUCTOR(S)
    //-----------------------------------------------
    
    public Logging(){ super(); }
    
    //-----------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //-----------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	//-----------------------------------------------
    // toString METHOD
    //-----------------------------------------------

	@Override
	public String toString() {
		return "LoggingInfo [id=" + id + ", operId=" + operId + ", datetime=" + datetime + ", level=" + level + "]";
	}
}