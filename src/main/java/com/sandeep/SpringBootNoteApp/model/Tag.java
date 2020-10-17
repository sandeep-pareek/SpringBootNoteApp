package com.sandeep.SpringBootNoteApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sandeep Pareek
 * @since 9th April, 2020
 */

@Entity
@Table(name = "T_TAG")
public class Tag implements Serializable {

	private static final long serialVersionUID = -2685158076345675196L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TAG_ID")
	private Integer tagId;

	@Column(name="TAG_NAME")
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

}
