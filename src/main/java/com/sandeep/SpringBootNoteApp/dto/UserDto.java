package com.sandeep.SpringBootNoteApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author Sandeep
 * @since March 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String username;
	private String password;
}
