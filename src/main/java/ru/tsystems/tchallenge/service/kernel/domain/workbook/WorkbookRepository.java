package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface WorkbookRepository extends OrdinalEntityRepository<Workbook> {

    @Query("SELECT w FROM Workbook AS w " +
            "WHERE w.candidate.account.login LIKE :login " +
            "AND w.event.textcode LIKE :event " +
            "AND w.status.id IN :statuses")
    Page<Workbook> findPage(@Param("login") String login,
                            @Param("event") String event,
                            @Param("statuses") Collection<String> statuses,
                            Pageable pageable);
}
