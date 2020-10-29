package com.cfs.model;

public class QuestionAnswer {

	private int number;
	private String question;
	private String answer;
	public QuestionAnswer(int number, String question, String answer) {
		super();
		this.number = number;
		this.question = question;
		this.answer = answer;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
