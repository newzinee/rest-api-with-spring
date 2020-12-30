package com.study.demoinflearnrestapi.events;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yj
 * @version 0.1.0
 * @since 2020/12/30
 */
public interface EventRepository extends JpaRepository<Event, Integer> {

}
