package com.acttypeitem.model;

import com.act.model.ActVO;
import com.acttype.model.ActType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity_item")
public class ActTypeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_item_id")
    private Integer actItemId;

    @ManyToOne
    @JoinColumn(name = "act_id", referencedColumnName = "act_id", nullable = false)
    private ActVO actId;

    @ManyToOne
    @JoinColumn(name = "act_type_id", referencedColumnName = "act_type_id", nullable = false)
    private ActType actTypeId;

    // 省略其他欄位...
}