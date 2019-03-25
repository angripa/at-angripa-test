/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.repository;

import hita.rokkap.com.domain.Match;
import hita.rokkap.com.domain.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author angripa.nadapdap
 * @version $Id: MatchRepository.java, v 0.1 2019‐03‐26 00:33 angripa.nadapdap Exp $$
 */
public interface MatchRepository extends JpaRepository<Match, Long> {

}