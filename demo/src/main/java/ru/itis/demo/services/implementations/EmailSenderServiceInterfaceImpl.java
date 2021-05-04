package ru.itis.demo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import ru.itis.demo.services.interfaces.EmailSenderServiceInterface;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;


@RequiredArgsConstructor
@Service
@PropertySource(value = "classpath:/application.properties")
public class EmailSenderServiceInterfaceImpl implements EmailSenderServiceInterface {
    private final JavaMailSender mailSender;
    private final ExecutorService executorService;

//    @Value("${sender.name}")
    private String senderName;
    @Override
    public void sendMessage(String subject, String mail, String html) {
        Runnable runnable = () -> {
            MimeMessagePreparator message = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                        StandardCharsets.UTF_8.name());
                messageHelper.setFrom("someone");
                messageHelper.setTo(mail);
                messageHelper.setSubject(subject);
                messageHelper.setText(html, true);
            };
            mailSender.send(message);
        };
        executorService.submit(runnable);
    }
}
