package ru.tchallenge.service.kernel.security.rescue;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericService;
import ru.tchallenge.service.kernel.utility.mail.MailService;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionProvider;

@ServiceComponent
public class RescueServiceBean extends GenericService implements RescueService {

    private final Duration deactivation = Duration.ofMinutes(30);
    private final Map<String, Rescue> rescues = new ConcurrentHashMap<>();

    @Autowired
    private AccessValidationExceptionProvider accessValidationExceptionProvider;

    @Autowired
    private RescueMapper rescueMapper;

    @Autowired
    private MailService mailService;

    @Override
    public void create(final RescueInvoice invoice) {
        final Rescue rescue = new Rescue(
                invoice.getEmail(),
                invoice.getUrl());
        rescues.put(rescue.getId(), rescue);
        sendRescueViaEmail(rescue);
    }

    @Override
    public RescueInfo getAndRemove(final String id) {
        final Rescue rescue = rescues.remove(id);
        if (rescue == null) {
            throw accessValidationExceptionProvider.unknownRescue(id);
        }
        if (rescue.isDeactivated(deactivation)) {
            throw accessValidationExceptionProvider.rescueExpired(id);
        }
        return asInfo(rescue);
    }

    private RescueInfo asInfo(final Rescue rescue) {
        return rescueMapper.asInfo(rescue);
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
