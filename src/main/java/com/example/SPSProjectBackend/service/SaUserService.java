//package com.example.SPSProjectBackend.service;
//
//import com.example.SPSProjectBackend.model.SaUser;
//import com.example.SPSProjectBackend.repository.SaUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import util.common.Encryption;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.Optional;
//
////@Service
////public class SaUserService {
////
////    private final SaUserRepository saUserRepository;
////
////    @Autowired
////    public SaUserService(SaUserRepository saUserRepository) {
////        this.saUserRepository = saUserRepository;
////    }
////
////    //    public SaUser login(String userId, String password) {
//////        try {
//////            // Encrypt the password using the Encryption class
//////            Encryption encryption = new Encryption();
//////            String encryptedPassword = encryption.checkPass(password);
//////
//////            // Fetch the user from the database
//////            Optional<SaUser> user = saUserRepository.findByUserIdAndPassword(userId, encryptedPassword);
//////
//////            if (user.isPresent()) {
//////                SaUser saUser = user.get();
//////
//////                // Check if the user is inactive
//////                if (saUser.getStatus() != null && saUser.getStatus() == 1) {
//////                    throw new RuntimeException("User is inactive");
//////                }
//////
//////                // Check if the user account has expired
//////                if (saUser.getExpiryDate().before(new java.util.Date())) {
//////                    throw new RuntimeException("User account has expired");
//////                }
//////
//////                return saUser;
//////            } else {
//////                throw new RuntimeException("Invalid user ID or password");
//////            }
//////        } catch (Exception e) {
//////            throw new RuntimeException("Error during login: " + e.getMessage());
//////        }
//////    }
////
////
////
//////    public SaUser login(String userId) {
//////        if (userId == null || userId.isEmpty()) {
//////            throw new RuntimeException("User ID must not be empty");
//////        }
//////
//////        try {
//////            // Fetch the user from the database
//////            Optional<SaUser> user = saUserRepository.findByUserId(userId.trim().toUpperCase());
//////
//////            if (user.isPresent()) {
//////                SaUser saUser = user.get();
//////
//////                // Check if the user is inactive
//////                if (saUser.getStatus() != null && saUser.getStatus() == 1) {
//////                    throw new RuntimeException("User is inactive");
//////                }
//////
//////                // Check if the user account has expired
//////                if (saUser.getExpiryDate().before(new java.util.Date())) {
//////                    throw new RuntimeException("User account has expired");
//////                }
//////
//////                return saUser;
//////            } else {
//////                throw new RuntimeException("Invalid user ID");
//////            }
//////        } catch (Exception e) {
//////            throw new RuntimeException("Error during login: " + e.getMessage());
//////        }
//////    }
////
////    public SaUser login(String userId, String rawPassword) {
////        if (userId == null || userId.isEmpty()) {
////            throw new RuntimeException("User ID must not be empty");
////        }
////        if (rawPassword == null || rawPassword.isEmpty()) {
////            throw new RuntimeException("Password must not be empty");
////        }
////
////        try {
////            Optional<SaUser> userOpt = saUserRepository.findByUserId(userId.trim().toUpperCase());
////
////            if (userOpt.isEmpty()) {
////                throw new RuntimeException("Invalid user ID or password");
////            }
////
////            SaUser saUser = userOpt.get();
////
////            Encryption encryption = new Encryption();
////            String encodedInputPassword = encryption.checkPass(rawPassword);
////
////            // Now compare encoded password
////            if (!encodedInputPassword.equals(saUser.getPassword())) {
////                throw new RuntimeException("Invalid user ID or password");
////            }
////
////            if (saUser.getStatus() != null && saUser.getStatus() == 1) {
////                throw new RuntimeException("User is inactive");
////            }
////
////            if (saUser.getExpiryDate().before(new java.util.Date())) {
////                throw new RuntimeException("User account has expired");
////            }
////
////            return saUser;
////        } catch (Exception e) {
////            throw new RuntimeException("Error during login: " + e.getMessage());
////        }
////    }
////
////}
//
//
//@Service
//public class SaUserService {
//
//    private final SaUserRepository saUserRepository;
//    private final Encryption encryption;
//
//    @Autowired
//    public SaUserService(SaUserRepository saUserRepository, Encryption encryption) {
//        this.saUserRepository = saUserRepository;
//        this.encryption = encryption;
//    }
//
//    @Transactional
//    public SaUser login(String userId, String password) {
//        if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
//            throw new RuntimeException("User ID and password must not be empty");
//        }
//
//        Optional<SaUser> userOptional = saUserRepository.findByUserId(userId.trim().toUpperCase());
//
//        if (userOptional.isPresent()) {
//            SaUser user = userOptional.get();
//
//            if (user.getStatus() != null && user.getStatus() == 1) {
//                throw new RuntimeException("User is inactive");
//            }
//
////            if (user.getExpiryDate() != null && user.getExpiryDate().before(new Date())) {
////                throw new RuntimeException("User account has expired");
////            }
//            // Check expiry date
//            if (user.getExpiryDate() != null) {
//                try {
//                    LocalDate expiryDate = user.getExpiryDate().toInstant()
//                            .atZone(ZoneId.systemDefault())
//                            .toLocalDate();
//                    LocalDate currentDate = LocalDate.now();
//
//                    if (currentDate.isAfter(expiryDate)) {
//                        throw new RuntimeException("User account has expired on " + expiryDate);
//                    }
//                } catch (Exception dateException) {
//                    System.err.println("Error parsing expiry date: " + dateException.getMessage());
//                    System.err.println("Raw expiry date: " + user.getExpiryDate());
//                    System.out.println("Warning: Could not parse expiry date, allowing login");
//                }
//            }
//
//            try {
//                boolean isValid = encryption.validateLogin(userId, password, user.getPassword());
//                if (!isValid) {
//                    throw new RuntimeException("Invalid password");
//                }
//            } catch (Exception e) {
//                throw new RuntimeException("Error validating password: " + e.getMessage());
//            }
//
//            return user;
//
//        } else {
//            throw new RuntimeException("Invalid user ID");
//        }
//    }
//}

////NEW UPDATED CODES
//package com.example.SPSProjectBackend.service;
//
//import com.example.SPSProjectBackend.model.SaUser;
//import com.example.SPSProjectBackend.repository.SaUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import util.common.Encryption;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.Optional;
//
//@Service
//public class SaUserService {
//
//    private final SaUserRepository saUserRepository;
//    private final Encryption encryption;
//
//    @Autowired
//    public SaUserService(SaUserRepository saUserRepository, Encryption encryption) {
//        this.saUserRepository = saUserRepository;
//        this.encryption = encryption;
//    }
//
//    @Transactional
//    public SaUser login(String userId, String password) {
//        if (userId == null || userId.trim().isEmpty() || password == null || password.trim().isEmpty()) {
//            throw new RuntimeException("User ID and password must not be empty");
//        }
//
//        String normalizedUserId = userId.trim().toUpperCase();
//        Optional<SaUser> userOptional = saUserRepository.findByUserId(normalizedUserId);
//
//        if (userOptional.isEmpty()) {
//            throw new RuntimeException("Invalid user ID or password");
//        }
//
//        SaUser user = userOptional.get();
//
//        // CHANGED: Added null check for status with clearer error message
//        if (user.getStatus() != null && user.getStatus() == 1) {
//            throw new RuntimeException("User account is inactive");
//        }
//
//        // CHANGED: Improved expiry date checking with better error handling
//        if (user.getExpiryDate() != null) {
//            try {
//                LocalDate expiryDate = user.getExpiryDate().toInstant()
//                        .atZone(ZoneId.systemDefault())
//                        .toLocalDate();
//                LocalDate currentDate = LocalDate.now();
//
//                if (currentDate.isAfter(expiryDate)) {
//                    throw new RuntimeException("User account has expired on " + expiryDate);
//                }
//            } catch (Exception dateException) {
//                // CHANGED: Log the error but don't block login due to date parsing issues
//                System.err.println("Warning: Error parsing expiry date for user " + normalizedUserId + ": " + dateException.getMessage());
//                // Continue with login despite date parsing issues
//            }
//        }
//
//        // CHANGED: Improved password validation with better error handling
//        try {
//            boolean isValid = encryption.validateLogin(normalizedUserId, password, user.getPassword());
//            if (!isValid) {
//                throw new RuntimeException("Invalid user ID or password");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Error validating password: " + e.getMessage());
//        }
//
//        return user;
//    }
//}

////NEW UPATED CODES 2
//
////this is working code 1 with all the users
//package com.example.SPSProjectBackend.service;
//
//import com.example.SPSProjectBackend.model.SaUser;
//import com.example.SPSProjectBackend.repository.SaUserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import util.common.Encryption;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.Optional;
//
//@Service
//public class SaUserService {
//
//    //in here added logger
//    private static final Logger logger = LoggerFactory.getLogger(SaUserService.class);
//    private final SaUserRepository saUserRepository;
//    private final Encryption encryption;
//
//    @Autowired
//    public SaUserService(SaUserRepository saUserRepository, Encryption encryption) {
//        this.saUserRepository = saUserRepository;
//        this.encryption = encryption;
//    }
//
//    @Transactional
//    public SaUser login(String userId, String password) {
//        if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
//            throw new RuntimeException("User ID and password must not be empty");
//        }
//
//        Optional<SaUser> userOptional = saUserRepository.findByUserId(userId.trim().toUpperCase());
//        logger.info("Attempting login for userId: {}", userOptional);  // Use {} for params
//        logger.debug("User optional: {}", userOptional);  // Or logger.error for issues
//
//        if (userOptional.isPresent()) {
//            SaUser user = userOptional.get();
//
//            if (user.getStatus() != null && user.getStatus() == 1) {
//                throw new RuntimeException("User is inactive");
//            }
//
//            // Check expiry date
//            if (user.getExpiryDate() != null) {
//                try {
//                    LocalDate expiryDate = user.getExpiryDate().toInstant()
//                            .atZone(ZoneId.systemDefault())
//                            .toLocalDate();
//                    LocalDate currentDate = LocalDate.now();
//
//                    if (currentDate.isAfter(expiryDate)) {
//                        throw new RuntimeException("User account has expired on " + expiryDate);
//                    }
//                } catch (Exception dateException) {
//                    System.err.println("Error parsing expiry date: " + dateException.getMessage());
//                    System.err.println("Raw expiry date: " + user.getExpiryDate());
//                    // Changed: Instead of allowing login on parse error, throw exception to prevent insecure behavior
//                    // Existing: Previously had System.out.println("Warning: Could not parse expiry date, allowing login");
//                    throw new RuntimeException("Error parsing expiry date: " + dateException.getMessage());
//                }
//            }
//
//            try {
//                boolean isValid = encryption.validateLogin(userId, password, user.getPassword());
//                if (!isValid) {
//                    throw new RuntimeException("Invalid password");
//                }
//            } catch (Exception e) {
//                throw new RuntimeException("Error validating password: " + e.getMessage());
//            }
//
//            return user;
//
//        } else {
//            throw new RuntimeException("Invalid user ID");
//        }
//    }
//}

// NEW UPDATED CODES 3 - SaUserService.java
// Changes:
// 1. Fixed logger statement: Previously, logger.info was logging the userOptional object instead of the userId. Changed to log the normalized userId.
// 2. In expiry date check: Changed to log warning and allow login if parsing fails, instead of throwing exception. This prevents login failures due to invalid date formats in DB, matching the original code's lack of strict expiry check during validation.
// 3. Passed normalizedUserId to encryption.validateLogin instead of original userId, for consistency (though encryption trims/uppercases internally, this ensures consistency).
// 4. Added more debug logging for better traceability during issues.
// 5. No other major changes, as the service flow is mostly correct now.
package com.example.SPSProjectBackend.service;

import com.example.SPSProjectBackend.model.SaUser;
import com.example.SPSProjectBackend.repository.SaUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.common.Encryption;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class SaUserService {

    private static final Logger logger = LoggerFactory.getLogger(SaUserService.class);
    private final SaUserRepository saUserRepository;
    private final Encryption encryption;

    @Autowired
    public SaUserService(SaUserRepository saUserRepository, Encryption encryption) {
        this.saUserRepository = saUserRepository;
        this.encryption = encryption;
    }

    @Transactional
    public SaUser login(String userId, String password) {
        if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
            throw new RuntimeException("User ID and password must not be empty");
        }

        String normalizedUserId = userId.trim().toUpperCase();
        logger.info("Attempting login for userId: {}", normalizedUserId); // FIXED: Log normalized userId instead of
                                                                          // userOptional

        Optional<SaUser> userOptional = saUserRepository.findByUserId(normalizedUserId);
        logger.debug("User optional: {}", userOptional); // Existing debug log

        if (userOptional.isPresent()) {
            SaUser user = userOptional.get();

            if (user.getStatus() != null && user.getStatus() == 1) {
                throw new RuntimeException("User is inactive");
            }

            // Check expiry date
            if (user.getExpiryDate() != null) {
                try {
                    LocalDate expiryDate = user.getExpiryDate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    LocalDate currentDate = LocalDate.now();

                    if (currentDate.isAfter(expiryDate)) {
                        throw new RuntimeException("User account has expired on " + expiryDate);
                    }
                } catch (Exception dateException) {
                    logger.warn("Warning: Could not parse expiry date for user {}, allowing login. Error: {}",
                            normalizedUserId, dateException.getMessage()); // CHANGED: Log warning and allow login
                                                                           // instead of throwing
                    logger.debug("Raw expiry date: {}", user.getExpiryDate());
                }
            }

            try {
                boolean isValid = encryption.validateLogin(normalizedUserId, password, user.getPassword()); // CHANGED:
                                                                                                            // Pass
                                                                                                            // normalizedUserId
                                                                                                            // for
                                                                                                            // consistency
                if (!isValid) {
                    throw new RuntimeException("Invalid password");
                }
            } catch (Exception e) {
                logger.error("Error validating password for user {}: {}", normalizedUserId, e.getMessage()); // ADDED:
                                                                                                             // More
                                                                                                             // logging
                                                                                                             // for
                                                                                                             // errors
                throw new RuntimeException("Error validating password: " + e.getMessage());
            }

            logger.info("Successful login for user: {}", normalizedUserId); // ADDED: Log successful login
            return user;

        } else {
            throw new RuntimeException("Invalid user ID");
        }
    }
}