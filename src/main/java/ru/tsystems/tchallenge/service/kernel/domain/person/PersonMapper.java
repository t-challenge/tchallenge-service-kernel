package ru.tsystems.tchallenge.service.kernel.domain.person;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class PersonMapper extends GenericMapper {

    public PersonInfo info(final Person person) {
        final PersonInfo info = new PersonInfo();
        info.setFirstname(person.getFirstname());
        info.setLastname(person.getLastname());
        info.setQuickname(person.getQuickname());
        return info;
    }
}
