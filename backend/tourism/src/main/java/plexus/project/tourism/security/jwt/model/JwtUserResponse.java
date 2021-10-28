package plexus.project.tourism.security.jwt.model;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import plexus.project.tourism.users.dto.GetUserDto;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDto {

	private String token;

	@Builder(builderMethodName = "jwtUserResponseBuilder")
	public JwtUserResponse(String username, String surname, String email, Set<String> roles, String token) {
		super(username, surname, email, roles);
		this.token = token;
	}

}
