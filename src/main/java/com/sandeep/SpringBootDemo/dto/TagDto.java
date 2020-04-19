package com.sandeep.SpringBootDemo.dto;

/**
 * 
 * @author Sandeep Pareek
 * @since 9th April, 2020
 */

public class TagDto {

	private Integer tagId;
	private String tagName;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return this.getTagName();
	}
}
