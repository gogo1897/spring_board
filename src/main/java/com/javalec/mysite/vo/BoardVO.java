package com.javalec.mysite.vo;

public class BoardVO {
	
	int seq;
	String title;
	String writer;
	String content;
	String reg_date;
	int cnt;
	String id;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int no) {
		this.seq = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
		
	}
	public void setReg_date(String regdate) {
		this.reg_date = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", reg_date="
				+ reg_date + ", cnt=" + cnt + ", id=" + id + "]";
	}
	
	
}
