package com.example.demo.domain;

public class Wrapper {
	public String title="这是读取另一个web的restful消息";
	Person[] ps;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Person[] getPs() {
		return ps;
	}
	public void setPs(Person[] ps) {
		this.ps = ps;
	}
	public Wrapper(Person[] ps) {
		super();
		this.ps = ps;
	}
}
