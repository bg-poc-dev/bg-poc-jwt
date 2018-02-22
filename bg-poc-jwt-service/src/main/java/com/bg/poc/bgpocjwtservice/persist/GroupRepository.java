package com.bg.poc.bgpocjwtservice.persist;

import com.bg.poc.bgpocjwtservice.persist.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
}
