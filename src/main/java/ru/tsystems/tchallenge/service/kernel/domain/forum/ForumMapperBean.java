package ru.tsystems.tchallenge.service.kernel.domain.forum;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class ForumMapperBean extends GenericMapper implements ForumMapper {

    @Override
    public ForumInfo info(final Forum forum) {
        return new ForumInfo();
    }
}
