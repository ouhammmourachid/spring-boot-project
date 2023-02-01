package com.web.springbootproject.controller.employee;

import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.service.employee.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/profile")
public class ProfileController {
    @Autowired
    private final ProfileService profileService;

    @GetMapping
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }
    @GetMapping(path = "{id}")
    public Optional<Profile> getProfile(@PathVariable Long id){
        return profileService.getProfile(id);
    }
    @PostMapping
    public Profile createProfile(@RequestParam Long userId,@RequestBody Profile profile){
        return profileService.addProfile(userId,profile);
    }
    @PutMapping(path = "{id}")
    public Profile updateProfile(@PathVariable Long id,
                                           @RequestBody Profile profile){
        return profileService.updateProfile(id,profile);
    }
}
