# JobSaw-backend

## Features

- **Google OAuth2 Authentication**: Users can log in using their Google account.

## Setup & Configuration

To test the Google OAuth2 functionality locally:
1. Go to the [Google Cloud Console](https://console.cloud.google.com/) and create an OAuth 2.0 Web Application.
2. Add `http://localhost:8080/login/oauth2/code/google` as an authorized redirect URI.
3. Obtain your **Client ID** and **Client Secret**.
4. Configure them in `src/main/resources/application.properties`:
   ```properties
   spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
   spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
   ```
5. Run the application and open `http://localhost:8080/index.html` to test the login flow.