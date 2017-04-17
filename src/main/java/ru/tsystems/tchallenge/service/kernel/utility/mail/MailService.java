package ru.tsystems.tchallenge.service.kernel.utility.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import ru.tsystems.tchallenge.service.kernel.conventions.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericService;

@CommonService
public class MailService extends GenericService {

    @Autowired
    private MailSender mailSender;

    public void send(final MailInvoice invoice) {
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setText(invoice.getContent());
        message.setTo(invoice.getTarget());
        message.setSubject(invoice.getSubject());
        message.setFrom("info@t-challenge.ru");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
