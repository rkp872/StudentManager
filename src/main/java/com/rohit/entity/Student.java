package com.rohit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String email;
	private String phone;
	private String stream;
	private String roll;
	private String regNumber;
	private String pic;

	@PrePersist
	public void defaultImage() {
		if (this.pic.equals("undefined")) {
			this.pic = "https://res.cloudinary.com/rohit872cloud/image/upload/v1622091000/StudentManager/pmyq6uxp1f1ncyb3mtsm.png";
		}
	}

}
