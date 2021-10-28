package plexus.project.tourism.users.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import plexus.project.tourism.users.model.UserEntity;
import plexus.project.tourism.users.model.UserRole;

@Component
public class UserDtoConverter {

	public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
		return GetUserDto.builder().username(user.getUsername()).surname(user.getSurname()).email(user.getEmail())
				.roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet())).build();
	}
}
