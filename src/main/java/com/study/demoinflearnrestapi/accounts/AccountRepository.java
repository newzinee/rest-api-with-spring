package com.study.demoinflearnrestapi.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/04
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

}
