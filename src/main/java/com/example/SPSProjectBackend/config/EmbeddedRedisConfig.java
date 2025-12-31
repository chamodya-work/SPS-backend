// package com.example.SPSProjectBackend.config;
//
// import org.springframework.context.annotation.Configuration;
// import javax.annotation.PostConstruct;
// import javax.annotation.PreDestroy;
// import redis.embedded.RedisServer;
// import java.io.IOException;
//
//// package com.example.SPSProjectBackend.config;
////
//// import org.springframework.context.annotation.Configuration;
//// import javax.annotation.PostConstruct;
//// import javax.annotation.PreDestroy;
//// import redis.embedded.RedisServer;
//// import java.io.IOException;
////
//// @Configuration
//// public class EmbeddedRedisConfig {
////
//// private RedisServer redisServer;
////
//// @PostConstruct
//// public void startRedis() throws IOException {
//// redisServer = new RedisServer(6381); // Use your preferred port
//// redisServer = new RedisServer(6379);// Use your preferred port
//// redisServer.start();
//// }
////
//// @PreDestroy
//// public void stopRedis() {
//// if (redisServer != null) {
//// redisServer.stop();
//// }
//// }
//// }
//
//
// package com.example.SPSProjectBackend.config;
//
// import org.springframework.context.annotation.Configuration;
// import javax.annotation.PostConstruct;
// import javax.annotation.PreDestroy;
// import redis.embedded.RedisServer;
// import redis.embedded.RedisServerBuilder;
// import java.io.IOException;
//
// @Configuration
// public class EmbeddedRedisConfig {
//
// private RedisServer redisServer;
//
// @PostConstruct
// public void startRedis() throws IOException {
// redisServer = RedisServer.builder()
// .port(6380) // Use 6380 for SPS project
// .setting("maxheap 64MB") // Reduced heap size
// .setting("maxmemory 64MB") // Set max memory
// .setting("save \"\"") // Disable persistence
// redisServer = new RedisServerBuilder()
// .port(6379) // Use your preferred port
// .setting("maxheap 256mb") // ✅ Reduce heap to avoid Windows error 0x5AF
// .build();
// redisServer.start();
// }
//
// @PreDestroy
// public void stopRedis() {
// if (redisServer != null) {
// redisServer.stop();
// }
// }
// }