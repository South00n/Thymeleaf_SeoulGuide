package com.sist.web.entity;
/*
	NO int 
	TITLE text 
	POSTER text 
	MSG text 
	ADDRESS text 
	HIT int
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="seoul_location")
@Getter
@Setter
public class SeoulLocationEntity {
	@Id
	private int no;
	private int hit;
	private String title;
	private String poster;
	private String msg;
	private String address;
}
