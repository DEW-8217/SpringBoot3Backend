package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @Sql("/insert-members.sql")
    @Test
    void update(){
        Member member = memberRepository.findById(2L).get();

        member.changeName("BC");

        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }
    void deleteAll() {
        memberRepository.deleteAll();
        assertThat(memberRepository.findAll().size()).isZero();
    }
    void deleteMemberById() {
        memberRepository.deleteById(2L);

        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }
    void saveMembers(){
        List<Member> members = List.of(new Member(2L, "B"),
                new Member(3L, "C"));
        memberRepository.saveAll(members);
        assertThat(memberRepository.findAll().size()).isEqualTo(3);
    }
    void saveMember(){
        Member member = new Member(1L, "A");

        memberRepository.save(member);

        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }
    void getMembersByName() {
        Member member = memberRepository.findByName("C").get();

        assertThat(member.getId()).isEqualTo(3);
    }
    void getMemberById() {
        Member member = memberRepository.findById(2L).get();

        assertThat(member.getName()).isEqualTo("B");
    }
    void getAllMembers(){
        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(3);
    }
}