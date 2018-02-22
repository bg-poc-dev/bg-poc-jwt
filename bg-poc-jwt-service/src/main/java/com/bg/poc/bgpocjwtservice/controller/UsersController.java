package com.bg.poc.bgpocjwtservice.controller;

import com.bg.poc.bgpocjwtservice.persist.GroupRepository;
import com.bg.poc.bgpocjwtservice.persist.entity.Group;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private GroupRepository groupRepository;

    public UsersController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> groups() {
        return ResponseEntity.ok(groupRepository.findAll());
    };
}
