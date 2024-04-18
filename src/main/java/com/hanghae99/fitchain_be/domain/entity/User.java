package com.hanghae99.fitchain_be.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String userName;
    @Column(length = 100, nullable = false)
    private String userId;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 100, nullable = false)
    private String nickName;
    @Column(length = 100, nullable = false)
    private String phoneNumber;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private Date birth;
}
