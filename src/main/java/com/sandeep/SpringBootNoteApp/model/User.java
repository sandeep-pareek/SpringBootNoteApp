package com.sandeep.SpringBootNoteApp.model;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private boolean active;
	private String role;


}