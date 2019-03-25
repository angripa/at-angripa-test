/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author angripa.nadapdap
 * @version $Id: Match.java, v 0.1 2019‐03‐26 00:21 angripa.nadapdap Exp $$
 */
@Getter
@Setter
@Entity
@Table(name = "matches")
public class Match extends AuditableEntity<Long> {

    @JoinColumn(name = "opponent", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account opponent;

    @JoinColumn(name = "against", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account against;
}