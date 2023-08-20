package kookmin.springbootdeveloper.service;

import kookmin.springbootdeveloper.domain.User;
import kookmin.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService { // 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(final String email) { // 사용자 이름(email)으로 사용자의 정보를 가져오는 메서드
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(email));
    }
}