package ru.tchallenge.service.kernel.utility.mail;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.GenericService;

@CommonService
public class MailService extends GenericService {

    @Autowired
    private JavaMailSender mailSender;

    public void send(final MailInvoice invoice) {
        try {
            final MimeMessage mimeMessage = mailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            mimeMessage.setContent(invoice.getContent(), "text/html;charset=utf-8");
            helper.setTo(invoice.getTarget());
            helper.setSubject(invoice.getSubject());
            helper.setFrom("info@t-challenge.ru");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
