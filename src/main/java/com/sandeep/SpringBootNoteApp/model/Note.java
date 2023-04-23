package com.sandeep.SpringBootNoteApp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
