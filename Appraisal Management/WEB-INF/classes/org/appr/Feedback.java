package org.appr;

public class Feedback {
	private String qid, qtype, qtext, flag;
	private int self_f;
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getQtext() {
		return qtext;
	}
	public void setQtext(String qtext) {
		this.qtext = qtext;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getSelf_f() {
		return self_f;
	}
	public void setSelf_f(int self_f) {
		this.self_f = self_f;
	}
	public Feedback(String qid, String qtype, String qtext, String flag, int self_f) {
		super();
		this.qid = qid;
		this.qtype = qtype;
		this.qtext = qtext;
		this.flag = flag;
		this.self_f = self_f;
	}
	public Feedback() {
		super();
	}
	
}
