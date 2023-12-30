package com.acttype.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity_type")
public class ActType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_type_id")
    private Integer actTypeId;

    @Column(name = "act_type_name", nullable = false, length = 50)
    private String actTypeName;

    // 省略其他欄位...
}
