package ru.tchallenge.service.kernel.security.rescue;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperServiceComponent
public class RescueMapperBean extends GenericMapper implements RescueMapper {

    @Override
    public RescueInfo rescueInfo(final Rescue rescue) {
        return new RescueInfo(
                rescue.getId(),
                rescue.getEmail(),
                rescue.getUrl(),
                rescue.getCreatedAt()
        );
    }
}
