package plexus.project.tourism.security.jwt;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import plexus.project.tourism.security.jwt.model.JwtUserResponse;
import plexus.project.tourism.security.jwt.model.LoginRequest;
import plexus.project.tourism.users.dto.GetUserDto;
import plexus.project.tourism.users.dto.UserDtoConverter;
import plexus.project.tourism.users.model.UserEntity;
import plexus.project.tourism.users.model.UserRole;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	private final UserDtoConverter converter;

	@PostMapping("/auth/login")
	public JwtUserResponse login(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()

				));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserEntity user = (UserEntity) authentication.getPrincipal();
		String jwtToken = tokenProvider.generateToken(authentication);

		return convertUserEntityAndTokenToJwtUserResponse(user, jwtToken);

	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/user/me")
	public GetUserDto me(@AuthenticationPrincipal UserEntity user) {
		return converter.convertUserEntityToGetUserDto(user);
	}

	private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(UserEntity user, String jwtToken) {
		return JwtUserResponse.jwtUserResponseBuilder().username(user.getUsername()).surname(user.getSurname())
				.email(user.getEmail()).roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
				.token(jwtToken).build();

	}

}