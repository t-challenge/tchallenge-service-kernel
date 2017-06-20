package ru.tchallenge.service.kernel.security.rescue;

public interface RescueService {

    RescueInfo create(RescueInvoice invoice);

    RescueInfo get(String id);

    void remove(String id);
}
