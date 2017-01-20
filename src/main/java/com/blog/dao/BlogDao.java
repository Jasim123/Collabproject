package com.blog.dao;
import java.util.List;
import com.blog.model.Blog;

public interface BlogDao 
{
	
	void addBlog(Blog blog);
	List<Blog> viewBlogs();
	void updateBlog(Blog blog);
	void deleteBlog(int Bid);
	public String getBlogByBlogId(int id);

}
