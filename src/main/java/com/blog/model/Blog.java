package com.blog.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table( name = "BlogDetails",schema = "bloguser")


public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int bid;
	private String blogTitle;
	private String blogDescription;
	private String cdate;
	private String postedBy;
	private String category;
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ" ,allocationSize=1)
	
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	//@Column(name = "ID")
	
}
