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
@Table(name="enrollment")
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrolledId;
	
	@Column(nullable = false, length = 45)
	private String startDate;
	
	@Column(nullable = false, length = 45)
	private String amountPaid;
	
	@Column(nullable = false, length = 45)
	private String status;
	
	@Column(name="card_first_name" ,nullable = false, length = 45)
	private String cardFirstName;
	
	@Column(name="card_last_name" ,nullable = false, length = 45)
	private String cardLastName;
	
	@Column(name="card_number" ,nullable = false, length = 45)
	private String cardNumber;
	
	@Column(name="card_cvv" ,nullable = false, length = 45)
	private String cardCvv;
	
	@Column(name="card_expiry" ,nullable = false, length = 45)
	private String cardExpireDate;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student students;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId")
    private Program program;

	public String getCardFirstName() {
		return cardFirstName;
	}

	public void setCardFirstName(String cardFirstName) {
		this.cardFirstName = cardFirstName;
	}

	public String getCardLastName() {
		return cardLastName;
	}

	public void setCardLastName(String cardLastName) {
		this.cardLastName = cardLastName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(String cardCvv) {
		this.cardCvv = cardCvv;
	}

	public String getCardExpireDate() {
		return cardExpireDate;
	}

	public void setCardExpireDate(String cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Long getEnrolledId() {
		return enrolledId;
	}

	public void setEnrolledId(Long enrolledId) {
		this.enrolledId = enrolledId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
