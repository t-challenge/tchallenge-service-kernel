package ru.tchallenge.service.kernel.domain.forum;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class ForumMapperBean extends GenericMapper implements ForumMapper {

    @Override
    public ForumInfo info(final Forum forum) {
        return new ForumInfo();
    }
}
