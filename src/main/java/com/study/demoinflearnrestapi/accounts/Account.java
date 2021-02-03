package com.study.demoinflearnrestapi.accounts;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/04
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder @NoArgsConstructor @AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<AccountRole> roles;

}
