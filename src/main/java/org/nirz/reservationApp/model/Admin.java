package org.nirz.reservationApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
@Column(nullable=false)
	private String name;
@Column(nullable=false , unique = true)
	private long phone;
@Column(nullable=false , unique = true)
	private String gst;
@Column(nullable=false )
	private String travels;
@Column(nullable=false , unique = true)
	private String email;
@Column(nullable=false )
	private String password;
	
	
}
