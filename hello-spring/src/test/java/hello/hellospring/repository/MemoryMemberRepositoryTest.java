package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest
{
/*테스트는 서로 의존 관계 없이 설계가 되어야 한다
* 그러기 위해서 하나의 테스트가 끝날 때마다
* 내용 꺠끗하게 지워줘야함*/
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        // 콜백함수.  테스트 실행된 후에 이어서 실행됨
        repository.clearStore();


    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("Kong");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result); // Alt + enter 해서 Assertions를 static으로 함

    }

    @Test
    public void findByNames(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member(); //shift + F6 => 변수명 리네임 되면서 관련 코드 자동 변경됨
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByNames("Spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
