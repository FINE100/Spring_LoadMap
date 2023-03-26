package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByNames(String name);
    List<Member> findAll();
    
    /*Optional : 자바 8에서 추가된 기능. null을 반환할 경우 Optional로 감싸서 반환함*/

}
