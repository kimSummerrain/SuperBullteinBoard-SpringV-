package com.example.superbullteinboard.domain.member;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository  extends CrudRepository<Member,String> {
    Optional<Member> findByAccountId(String accountId);
    boolean existsByAccountId(String accountId);
}
