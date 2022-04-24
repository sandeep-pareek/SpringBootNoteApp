package com.sandeep.SpringBootNoteApp.model;

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

import lombok.Data;

/**
 * @author sandeep
 * @since 22nd March 2020
 */

@Entity
@Table(name = "T_NOTE")
@Data
public class Note implements Serializable {

	private static final long serialVersionUID = -9196483832589749249L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
