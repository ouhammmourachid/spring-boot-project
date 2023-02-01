package com.web.springbootproject.service.employee;

import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.employee.ProfileRepository;
import com.web.springbootproject.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfileService {
    @Autowired
    private final ProfileRepository profileRepository;
    @Autowired
    private final UserRepository userRepository;
    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }
    public Optional<Profile> getProfile(Long id){
        return profileRepository.findById(id);
    }
    public Profile addProfile(Long userId,Profile profile){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user with id [%s] not found .".formatted(userId)));
        user.setProfile(profile);
        profile.setUser(user);
        userRepository.save(user);
        return user.getProfile();
    }
    public Profile updateProfile(Long id,Profile updateRequest){
        Profile profile = profileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("profile with id [%s] not found .".formatted(id)));
        boolean changed = false;
        if(updateRequest.getFirstName()!=null && !updateRequest.getFirstName().equals(profile.getFirstName())){
            profile.setFirstName(updateRequest.getFirstName());
            changed=true;
        }
        if(updateRequest.getLastName() !=null && !updateRequest.getLastName().equals(profile.getLastName())){
            profile.setLastName(updateRequest.getLastName());
            changed=true;
        }
        if(updateRequest.getHeadLine()!=null && !updateRequest.getHeadLine().equals(profile.getHeadLine())){
            profile.setHeadLine(updateRequest.getHeadLine());
            changed=true;
        }
        if(updateRequest.getPhoneNumber()!=null && !updateRequest.getPhoneNumber().equals(profile.getPhoneNumber())){
            profile.setPhoneNumber(updateRequest.getPhoneNumber());
            changed=true;
        }
        if(updateRequest.getCountry()!=null && !updateRequest.getCountry().equals(profile.getCountry())){
            profile.setCountry(updateRequest.getCountry());
            changed=true;
        }
        if(updateRequest.getCityOrState()!=null && !updateRequest.getCityOrState().equals(profile.getCityOrState())){
            profile.setCityOrState(updateRequest.getCityOrState());
            changed=true;
        }
        if(!updateRequest.isShowPhoneNumber()!=profile.isShowPhoneNumber()){
            profile.setShowPhoneNumber(updateRequest.isShowPhoneNumber());
            changed=true;
        }
        if(updateRequest.getDob()!=null && !updateRequest.getDob().equals(profile.getDob())){
            profile.setDob(updateRequest.getDob());
            changed=true;
        }
        if(updateRequest.getJobTitle()!=null && !updateRequest.getJobTitle().equals(profile.getJobTitle())){
            profile.setJobTitle(updateRequest.getJobTitle());
            changed=true;
        }
        if(updateRequest.getCompany()!=null && !updateRequest.getCompany().equals(profile.getCompany())){
            profile.setCompany(updateRequest.getCompany());
            changed=true;
        }
        if(!updateRequest.isReadyToWork()!=profile.isReadyToWork()){
            profile.setReadyToWork(updateRequest.isReadyToWork());
            changed=true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
       return profileRepository.save(profile);
    }
}
