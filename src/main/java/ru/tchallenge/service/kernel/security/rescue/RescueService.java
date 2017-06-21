package ru.tchallenge.service.kernel.security.rescue;

public interface RescueService {

    void create(RescueInvoice invoice);

    RescueInfo getAndRemove(String id);
}
