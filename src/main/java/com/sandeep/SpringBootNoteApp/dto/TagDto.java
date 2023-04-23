package com.sandeep.SpringBootNoteApp.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Sandeep Pareek
 * @since 9th April 2020
 */

@Getter
@Setter
public class TagDto {

	private Integer tagId;
	private String tagName;


	@Override
	public String toString() {
		return this.tagName;
	}
}
