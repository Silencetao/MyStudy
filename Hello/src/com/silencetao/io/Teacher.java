package com.silencetao.io;

import java.io.Serializable;

/**
 * 引用类型序列化，被引用的类必须序列化
 * @author Silence
 *
 */
public class Teacher implements Serializable {
	private static final long serialVersionUID = 895438698038705392L;
	private String name;
	private Person student;
	
	public Teacher(String name, Person student) {
		this.name = name;
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getStudent() {
		return student;
	}

	public void setStudent(Person student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", student=" + student + "]";
	}
}
