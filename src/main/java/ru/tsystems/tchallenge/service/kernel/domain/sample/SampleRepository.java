package ru.tsystems.tchallenge.service.kernel.domain.sample;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface SampleRepository extends OrdinalEntityRepository<Sample> {

    Collection<Sample> findAll();

    @Query("SELECT s FROM Sample AS s " +
            "WHERE s.title LIKE :titleFilter " +
            "AND s.status.id = :statusFilter")
    Page<Sample> findPage(@Param("titleFilter") String titleFilter,
                          @Param("statusFilter") String statusFilter,
                          Pageable pageable);
}
