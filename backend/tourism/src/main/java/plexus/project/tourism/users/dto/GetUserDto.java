package plexus.project.tourism.users.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetUserDto {

	private String username;
	private String surname;
	private String email;
	private Set<String> roles;
}
