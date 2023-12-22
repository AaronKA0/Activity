package com.actreg.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activity_registration")
public class ActReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_reg_id")
    private Integer actRegId;
    @Column(name = "mem_id")
    private Integer memId;
    @Column(name = "act_id")
    private Integer actId;
    @Column(name = "reg_total")
    private Integer regTotal;
    @Column(name = "reg_time")
    private Timestamp regTime;
    @Column(name = "reg_status")
    private byte regStatus;
    @Column(name = "is_act_part")
    private byte isActPart;
    @Column(name = "act_rating")
    private Double actRating;

}
