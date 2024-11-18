package itsyuryupa.userinfo.repository;

import itsyuryupa.userinfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

