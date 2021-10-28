package plexus.project.tourism.users.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import plexus.project.tourism.users.dto.CreateUserDto;
import plexus.project.tourism.users.dto.GetUserDto;
import plexus.project.tourism.users.dto.UserDtoConverter;
import plexus.project.tourism.users.services.UserEntityService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userEntityService;
	private final UserDtoConverter userDtoConverter;

	@PostMapping("/")
	public ResponseEntity<GetUserDto> nuevoUsuario(@RequestBody CreateUserDto newUser) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser)));
	}
}
