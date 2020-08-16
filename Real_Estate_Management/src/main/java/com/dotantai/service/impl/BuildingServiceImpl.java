package com.dotantai.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.dotantai.builder.BuildingSearchBuilder;
import com.dotantai.converter.BuildingConverter;
import com.dotantai.dto.BuildingDTO;
import com.dotantai.entity.BuildingEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.repository.IBuildingRepository;
import com.dotantai.repository.impl.BuildingRepositoryImpl;
import com.dotantai.service.IBuildingService;

public class BuildingServiceImpl implements IBuildingService {
	private IBuildingRepository buildingRepository;
	private BuildingConverter buildingConverter;

	public BuildingServiceImpl() {
		buildingRepository = (IBuildingRepository) new BuildingRepositoryImpl();
		buildingConverter = new BuildingConverter();
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
		Map<String, Object> properties = convertToMapProperties(fieldSearch);
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(properties, pageable, fieldSearch);
		return buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	/*
	 * This method convert to Map which contains search no-sqpecial condition
	 * 
	 * @ fieldSeach: contains condition search
	 * 
	 * @ Map<String: name of condition to search, Object: value for search>
	 */
	private Map<String, Object> convertToMapProperties(BuildingSearchBuilder fieldSearch) {

		Map<String, Object> properties = new HashMap<>();

		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				if (!field.getName().equals("buildingTypes") && !field.getName().startsWith("costRent")
						&& !field.getName().startsWith("staffId")) {
					field.setAccessible(true);
					if (field.get(fieldSearch) instanceof String) {
						if (field.getName().equals("buildingArea") || field.getName().equals("numberOfBasement")) {
							if (StringUtils.isNotBlank((String) field.get(fieldSearch))) {
								properties.put(field.getName().toLowerCase(),
										Integer.parseInt((String) field.get(fieldSearch)));
							}
						} else {
							properties.put(field.getName().toLowerCase(), field.get(fieldSearch));
						}

					}
				}

			}

		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.out.print(e);
		}

		return properties;
	}

}
