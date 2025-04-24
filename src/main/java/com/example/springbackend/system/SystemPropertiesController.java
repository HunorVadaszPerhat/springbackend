package com.example.springbackend.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
public class SystemPropertiesController {

    @GetMapping("/v1/getAll")
    public void getAllPropertiesV1() {
        // 📂 Current working directory (where relative paths resolve from)
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory: " + workingDir);

        // 🏠 User's home directory
        String userHome = System.getProperty("user.home");
        System.out.println("User Home: " + userHome);

        // 💻 OS and Java environment info
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));

        // 🔍 Optional: see all properties
        System.getProperties().forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }

    @GetMapping("/v2/getAll")
    public Map<String, String> getAllPropertiesV2() {
        Map<String, String> propertiesMap = new HashMap<>();

        // 📂 Current working directory
        propertiesMap.put("workingDir", System.getProperty("user.dir"));

        // 🏠 User's home directory
        propertiesMap.put("userHome", System.getProperty("user.home"));

        // 💻 OS and Java environment info
        propertiesMap.put("osName", System.getProperty("os.name"));
        propertiesMap.put("osVersion", System.getProperty("os.version"));
        propertiesMap.put("javaVersion", System.getProperty("java.version"));
        propertiesMap.put("javaVendor", System.getProperty("java.vendor"));

        // 🔍 Optional: Add all system properties
        Properties sysProps = System.getProperties();
        for (String key : sysProps.stringPropertyNames()) {
            propertiesMap.putIfAbsent(key, sysProps.getProperty(key));
        }

        return propertiesMap;
    }
}
