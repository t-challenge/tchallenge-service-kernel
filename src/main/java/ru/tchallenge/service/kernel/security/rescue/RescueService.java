package ru.tchallenge.service.kernel.security.rescue;

public interface RescueService {

    RescueInfo create(RescueInvoice invoice);

    RescueInfo getAndRemove(String id);
}
