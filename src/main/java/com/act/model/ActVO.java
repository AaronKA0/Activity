package com.act.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity")
public class ActVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id")
	private Integer actId;

	@Column(name = "mem_id", nullable = false)
	private Integer memId;

	@Column(name = "act_name", nullable = false, length = 50)
	private String actName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "act_start_time", nullable = false)
	private Date actStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "act_end_time", nullable = false)
	private Date actEndTime;

	@Column(name = "act_desc", length = 2000)
	private String actDesc;

	@Column(name = "act_upper")
	private Integer actUpper;

	@Column(name = "act_status")
	private Byte actStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_start_time")
	private Date regStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_end_time")
	private Date regEndTime;

	@Lob
	@Column(name = "act_pic")
	private byte[] actPic;

	@Column(name = "act_hot_rating")
	private Double actHotRating;

	@Column(name = "act_follower_count")
	private Integer actFollowerCount;

	@Column(name = "act_lat", precision = 8, scale = 6)
	private BigDecimal actLat;

	@Column(name = "act_lon", precision = 9, scale = 6)
	private BigDecimal actLon;
	
	
	
	

	
}
