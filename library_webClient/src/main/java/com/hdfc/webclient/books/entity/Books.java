package com.hdfc.webclient.books.entity;

import java.util.Date;


public class Books {
	private int id;
	private String title;
	private int price;
	private String author;
	private Date publishDate;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int id, String title, int price, String author, Date publishDate) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.publishDate = publishDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	

}
