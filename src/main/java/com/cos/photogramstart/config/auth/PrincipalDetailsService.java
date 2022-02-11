package com.cos.photogramstart.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // 어노테이션 붙이는 순간 IOC가 된다. 
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	// 1. 패스워드는 알아서 체킹하니까 신경쓸 필요 없다.
	// 2.리턴이 잘되면 자동으로 UserDetails 타입을 세션으로 만든다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userEntity = userRepository.findByUsername(username);
		
		if(userEntity == null) {			//null이면 찾지 못했다는것
			return null;
		}else {
			return new PrincipalDetails(userEntity);
		}
		
		
	}

}
