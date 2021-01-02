package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @PersistenceContext 애너테이션이 있어야 하지만 Spring에서 자동으로 DI 해준다.
/*    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
*/

/*    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean //Spring Bean에 임의로 추가해줌
    public MemberService memberService() {
        return new MemberService(memberRepository); //spring Bean에 있는 memberRepository를 넣어준다.
    }

/*    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource); //인터페이스를 구현체를 만들어서 확장한 것으로 DB를 바꾸었다.
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }
*/

/*  TimeTraceAop에 @Component 애너테이션을 사용하지 않을 경우 이렇게 빈을 등록해주면 된다.
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
*/
}
