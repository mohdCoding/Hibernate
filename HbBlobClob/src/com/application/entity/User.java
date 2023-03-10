package com.application.entity;

import java.util.Arrays;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Lob
	private byte[] photo;

	@Lob
	private char[] resume;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public char[] getResume() {
		return resume;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", photo=" + Arrays.toString(photo) + ", resume="
				+ Arrays.toString(resume) + "]";
	}

}
