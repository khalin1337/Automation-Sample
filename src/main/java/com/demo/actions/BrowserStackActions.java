package com.demo.actions;

import org.json.simple.JSONObject;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrowserStackActions {
    public void setWebTestStatus(String username, String accessKey, boolean isSuccess, String reason) {
        try {
            String sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();

            System.out.println("Session ID: " + sessionId);

            URL url = new URL("https://api.browserstack.com/automate/sessions/" + sessionId + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String auth = username + ":" + accessKey;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            json.put("status", isSuccess ? "passed" : "failed");
            json.put("reason", reason);

            String body = json.toString();
            connection.getOutputStream().write(body.getBytes());

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode >= 200 && responseCode < 300) {
                System.out.println("Status updated successfully!");
            } else {
                try (InputStream errorStream = connection.getErrorStream()) {
                    if (errorStream != null) {
                        String errorResponse = new String(errorStream.readAllBytes());
                        System.err.println("Error response: " + errorResponse);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAppTestStatus(String username, String accessKey, boolean isSuccess, String reason) {
        try {
            String sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
            System.out.println("Session ID: " + sessionId);
            URL url = new URL("https://api.browserstack.com/app-automate/sessions/" + sessionId + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String auth = username + ":" + accessKey;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            json.put("status", isSuccess ? "passed" : "failed");
            json.put("reason", reason);

            String body = json.toString();
            connection.getOutputStream().write(body.getBytes());

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode >= 200 && responseCode < 300) {
                System.out.println("Status updated successfully!");
            } else {
                try (InputStream errorStream = connection.getErrorStream()) {
                    if (errorStream != null) {
                        String errorResponse = new String(errorStream.readAllBytes());
                        System.err.println("Error response: " + errorResponse);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
