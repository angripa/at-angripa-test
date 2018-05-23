package awantunai.test.mapper;

import java.util.List;

public interface EntityToDTOMapper<Entity, DTO> {
	
	Entity createEntity(DTO dto);
	
	Entity updateEntity(DTO dto);

	DTO convertToDto(Entity entity);

	List<DTO> convertToDto(Iterable<Entity> entities);

	Entity convertToEntity(DTO dto);

	List<Entity> convertToEntity(Iterable<DTO> dtos);

}
