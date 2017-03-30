package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.domain.shared.OrdinalEntityRepository;import ru.tsystems.tchallenge.service.kernel.domain.shared.SubsequentEntity;

public interface CandidateRepository extends OrdinalEntityRepository<Candidate> {

    Collection<Candidate> findAll();

    @Query("SELECT c FROM Candidate AS c WHERE c.account.login = :login")
    Candidate findByLogin(@Param("login") String login);
}
