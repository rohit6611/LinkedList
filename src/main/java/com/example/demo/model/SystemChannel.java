package com.example.demo.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_channel")
public class SystemChannel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "channel")
	private String channel;

	@Column(name = "status")
	private Integer status;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "icon")
	private String icon;

	@Column(name = "ui_active")
	private String uiActive;

	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "systemChannel",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference(value="channel")
	private List<ChannelTraffic> channelTraffic;
}
