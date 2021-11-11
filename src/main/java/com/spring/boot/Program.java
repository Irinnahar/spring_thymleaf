package com.spring.boot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Program {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long programId;
	
	@Column(name="program_name" ,nullable = false, unique= true, length = 45)
	private String programName;
	
	@Column(nullable = false, length = 45)
	private String duration;
	
	@Column( nullable = false, length = 45)
	private String fee;

	@Column(name="start_date" ,nullable = false, length = 45)
	private String startDate;
	

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
	
}
