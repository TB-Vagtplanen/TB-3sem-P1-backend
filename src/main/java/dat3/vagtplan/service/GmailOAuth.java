package dat3.vagtplan.service;

import java.io.*;
import java.util.Base64;
import java.util.Properties;

import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.model.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;


public class GmailOAuth {

    private static final String APPLICATION_NAME = "tbvagtplannen";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
    private static final String CREDENTIALS_FILE_PATH = "static/client_secret_994509002939-q5ps1jdmsa2rdf7d6jc634q2i5hcn6lf.apps.googleusercontent.com.json";

    private static Credential getCredentials(final NetHttpTransport httpTransport) throws IOException {
        // Load client secrets.
        InputStream in = GmailOAuth.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        System.out.println("InputStream: " + in); // Debugging line
        InputStreamReader reader = new InputStreamReader(in);
        System.out.println("InputStreamReader: " + reader); // Debugging line
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, reader);

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
            httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
            .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public void sendMail(String userUsername, String userPassword, String recipient) throws GeneralSecurityException, IOException, MessagingException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(httpTransport, JSON_FACTORY, getCredentials(httpTransport))
            .setApplicationName(APPLICATION_NAME)
            .build();

        // Use the Gmail service to send an email.
        // Replace the following placeholders with appropriate values.
        String from = "vagtplannentb@gmail.com";
        String to = recipient;
        String subject = "Vagtplannen brugeroprettelse";
        String txt = "hej";
        String bodyText = txt;
        MimeMessage email = createEmail(to, from, subject, bodyText);
        sendMessage(service, "me", email);
    }

    private static MimeMessage createEmail(String to, String from, String subject, String bodyText)
        throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

    private static Message sendMessage(Gmail service, String userId, MimeMessage emailContent)
        throws MessagingException, IOException {
        Message message = new Message();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.getUrlEncoder().encodeToString(bytes);
        message.setRaw(encodedEmail);
        return service.users().messages().send(userId, message).execute();
    }
}



