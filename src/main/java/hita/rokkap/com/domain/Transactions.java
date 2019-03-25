package hita.rokkap.com.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@Getter
@Setter
@Entity
@Table(name="transactions")
public class Transactions extends AuditableEntity<Long>{
	@Basic(optional = false)
    @JoinColumn(name = "account", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Account account;
	@Column(name="type",nullable=false)
	private String type;
	@Column(name="amount",nullable=false)
	private BigDecimal amount;
}


