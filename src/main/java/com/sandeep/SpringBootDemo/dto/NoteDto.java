package com.sandeep.SpringBootDemo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Sandeep Pareek
 * @since 29th March, 2020
 */
public class NoteDto {

	private Integer id;
	private String title;
	private String description;
	private List<TagDto> tags = new ArrayList<TagDto>();
	private Date lastUpdatedDate;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TagDto> getTags() {
		return tags;
	}

	public void setTags(List<TagDto> tags) {
		this.tags = tags;
	}
}
