package io.github.lsj8367.repository;

import io.github.lsj8367.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
