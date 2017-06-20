package ru.tchallenge.service.kernel.security.rescue;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericService;
import ru.tchallenge.service.kernel.utility.mail.MailService;

@ServiceComponent
public class RescueServiceBean extends GenericService implements RescueService {

    private final Duration deactivation = Duration.ofMinutes(30);
    private final Map<String, Rescue> rescues = new ConcurrentHashMap<>();

    @Autowired
    private RescueMapper rescueMapper;

    @Autowired
    private MailService mailService;

    @Override
    public RescueInfo create(final RescueInvoice invoice) {
        final Rescue rescue = new Rescue(
                invoice.getEmail(),
                invoice.getUrl());
        sendRescueViaEmail(rescue);
        return info(rescue);
    }

    @Override
    public RescueInfo getAndRemove(final String id) {
        final Rescue rescue = rescues.get(id);
        if (rescue == null) {
            // TODO: throw specific exception
            throw new RuntimeException("rescue was not found");
        }
        if (rescue.getCreatedAt().plus(deactivation).isBefore(Instant.now())) {
            // TODO: throw specific exception
            throw new RuntimeException("rescue was expired");
        }
        rescues.remove(id);
        return info(rescue);
    }

    private RescueInfo info(final Rescue rescue) {
        return rescueMapper.rescueInfo(rescue);
    }

    private void sendRescueViaEmail(final Rescue rescue) {
        // TODO: implement sending an email
        throw new UnsupportedOperationException();
    }

    private String createRescueLinkUrl(final Rescue rescue) {
        // TODO: implement creation of rescue link URL
        throw new UnsupportedOperationException();
    }
}
