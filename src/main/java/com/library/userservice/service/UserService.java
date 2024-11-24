package com.library.userservice.service;

import com.library.userservice.dto.NotificationDTO;
import com.library.userservice.dto.UserDTO;
import com.library.userservice.model.User;
import com.library.userservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    public User createUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        User savedUser = userRepository.save(user);


        //send notification
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setSubject("Welcome to Book Management System");
        notificationDTO.setMessage("You have been registered successfully");
        notificationDTO.setReceiverEmail(savedUser.getEmail());
        restTemplate.postForEntity("http://EMAIL-SERVICE/api/notifications/notify/"+savedUser.getId(),
                notificationDTO, String.class);
        return savedUser;
    }
    
    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
            
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public void deactivateUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setActive(false);
        userRepository.save(user);
    }
    
    public void renewMembership(Long id, int months) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        
        LocalDateTime newEndDate = user.getMembershipEndDate().plusMonths(months);
        user.setMembershipEndDate(newEndDate);
        user.setActive(true);
        userRepository.save(user);
    }
}
