package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequentce = 0L; // Key AI해줄 값.

    @Override
    public Member save(Member member) {
        member.setId(++sequentce);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 해당 Map의 value들로 반복하겠다.
                .filter(member -> member.getName().equals(name)) // 해당 조건에 맞는 애들만 반복
                .findAny(); // Optional씌우는 것.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
