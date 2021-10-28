package plexus.project.tourism.users.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import plexus.project.tourism.users.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);
}
