package io.javabrains.resumeportal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.resumeportal.models.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
    
    Optional<UserProfile> findByUserName(String userName);
}
