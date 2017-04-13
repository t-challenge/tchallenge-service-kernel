package ru.tsystems.tchallenge.service.kernel.domain.task;

public interface CandidateTaskMapper {

    CandidateTaskInfoClosed infoClosed(Task task);

    CandidateTaskInfoOpened infoOpened(Task task);
}
