package plexus.project.tourism.users.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import plexus.project.tourism.error.exceptions.NewUserWithDifferentPasswordsException;
import plexus.project.tourism.services.base.BaseService;
import plexus.project.tourism.users.dto.CreateUserDto;
import plexus.project.tourism.users.model.UserEntity;
import plexus.project.tourism.users.model.UserRole;
import plexus.project.tourism.users.repos.UserEntityRepository;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

	private final PasswordEncoder passwordEncoder;

	public Optional<UserEntity> findUserByUsername(String username) {
		return this.repositorio.findByUsername(username);
	}

	public UserEntity nuevoUsuario(CreateUserDto newUser) {

		// userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		// userEntity.setRoles(Stream.of(UserRole.USER).collect(Collectors.toSet()));
		// return save(userEntity);

		if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
			UserEntity userEntity = UserEntity.builder().username(newUser.getUsername())
					.password(passwordEncoder.encode(newUser.getPassword())).surname(newUser.getSurname())
					.email(newUser.getEmail()).roles(Stream.of(UserRole.USER).collect(Collectors.toSet())).build();
			try {
				return save(userEntity);
			} catch (DataIntegrityViolationException ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
			}
		} else {
			throw new NewUserWithDifferentPasswordsException();
		}

	}

}
