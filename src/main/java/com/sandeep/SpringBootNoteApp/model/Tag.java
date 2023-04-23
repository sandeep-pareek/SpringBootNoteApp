package com.sandeep.SpringBootNoteApp.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * @author Sandeep Pareek
 * @since 9th April, 2020
 */

@Entity
@Table(name = "T_TAG")
@Data
public class Tag implements Serializable {

	private static final long serialVersionUID = -2685158076345675196L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TAG_ID")
	private Integer tagId;

	@Column(name="TAG_NAME")
	private String tagName;


}
