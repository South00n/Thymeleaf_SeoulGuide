package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
NO int 
TITLE text 
POSTER text 
MSG text 
ADDRESS text 
HIT int
*/
@Entity
@Table(name="seoul_shop")
@Getter
@Setter
public class SeoulShopEntity {
	@Id
	private int no;
	private int hit;
	private String title;
	private String poster;
	private String msg;
	private String address;
}
