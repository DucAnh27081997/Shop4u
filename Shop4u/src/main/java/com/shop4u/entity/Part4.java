package com.shop4u.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the part4 database table.
 * 
 */
@Entity
@NamedQuery(name="Part4.findAll", query="SELECT p FROM Part4 p")
public class Part4 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String answer_A;

	private String answer_B;

	private String answer_C;

	private String answer_D;

	private String correctAnswer;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String linkImage;

	private String linkMP4;

	private String quesition;

	private String tag;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="id_Test")
	private Test test;

	public Part4() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer_A() {
		return this.answer_A;
	}

	public void setAnswer_A(String answer_A) {
		this.answer_A = answer_A;
	}

	public String getAnswer_B() {
		return this.answer_B;
	}

	public void setAnswer_B(String answer_B) {
		this.answer_B = answer_B;
	}

	public String getAnswer_C() {
		return this.answer_C;
	}

	public void setAnswer_C(String answer_C) {
		this.answer_C = answer_C;
	}

	public String getAnswer_D() {
		return this.answer_D;
	}

	public void setAnswer_D(String answer_D) {
		this.answer_D = answer_D;
	}

	public String getCorrectAnswer() {
		return this.correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getLinkImage() {
		return this.linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public String getLinkMP4() {
		return this.linkMP4;
	}

	public void setLinkMP4(String linkMP4) {
		this.linkMP4 = linkMP4;
	}

	public String getQuesition() {
		return this.quesition;
	}

	public void setQuesition(String quesition) {
		this.quesition = quesition;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}