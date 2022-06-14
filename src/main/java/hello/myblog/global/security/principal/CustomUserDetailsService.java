package hello.myblog.global.security.principal;

import hello.myblog.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    public static final MemberNotFoundException NOT_FOUND_EXCEPTION =
            new MemberNotFoundException(ErrorCode.USER_NOT_FOUND);

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return memberRepository.findById(Long.valueOf(id))
                .map(CustomUserDetails::of)
                .orElseThrow(() -> NOT_FOUND_EXCEPTION);
    }
}
