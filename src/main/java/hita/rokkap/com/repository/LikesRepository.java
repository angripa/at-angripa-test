/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.repository;

import hita.rokkap.com.domain.Likes;
import hita.rokkap.com.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author angripa.nadapdap
 * @version $Id: LikesRepository.java, v 0.1 2019‐03‐26 00:47 angripa.nadapdap Exp $$
 */
public interface LikesRepository extends JpaRepository<Likes, Long> {
}