package com.sandeep.SpringBootDemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sandeep
 * @since 22nd March 2020
 */

@Entity
@Table(name = "T_NOTE")
public class Note implements Serializable {

	private static final long serialVersionUID = -9196483832589749249L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	@Column(name="TITLE")
	private String title;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="STATUS")
	private String status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_NOTE_TAG", joinColumns = { @JoinColumn(name="NOTE_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
			@JoinColumn(name = "TAG_ID", referencedColumnName = "TAG_ID") })
	private List<Tag> tags = new ArrayList<Tag>();

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	@Override
	public String toString() {
		return "id: " + id.toString() + "title: " + title.toString() + "descrition: " + description.toString();
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
}
