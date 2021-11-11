//package com.spring.boot;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//   @Autowired
//   private StudentRepository studentRepo;
//    
//   @Override
//   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//       Student student = studentRepo.findByEmail(email);
//       if (student == null) {
//           throw new UsernameNotFoundException("User not found");
//       }
//       return new CustomUserDetails(student);
//   }
//
//}
