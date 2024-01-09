package com.project1.david.mapper;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.project1.david.dto.MasterDataDto;
import com.project1.david.entity.MasterData;
import com.project1.david.utils.ValidationUtils;

@Component
public class MapperMasterData {

	private final Logger log = LoggerFactory.getLogger(getClass());

	
	public MasterData dtoToEntity(MasterDataDto masterDataDto)throws Exception {
		
		log.info("Strat dtoToEntity");
		MasterData masterDataEntity = new MasterData();

		masterDataEntity.setAddress(Optional.ofNullable(masterDataDto.getAddress())
				.orElseThrow(()->  new IllegalArgumentException("indirizzo non valido")));
		
		masterDataEntity.setCap(Optional.ofNullable(masterDataDto.getCap())
				.orElseThrow(()-> new IllegalArgumentException("cap non valido")));
		
		masterDataEntity.setCity(Optional.ofNullable(masterDataDto.getCity())
				.orElseThrow(()-> new IllegalArgumentException("citta non valida")));
		
		masterDataEntity.setNation(Optional.ofNullable(masterDataDto.getNation())
				.orElseThrow(()-> new IllegalArgumentException("nazione non valida")));
		
		masterDataEntity.setAdrresNumber(Optional.ofNullable(masterDataDto.getAddressNumber())
				.orElseThrow(() -> new IllegalArgumentException("numero non valida")));
		
//		List<User> userList = new ArrayList<User>();
//		userList.stream().forEach(user->{
//		});
		
		return masterDataEntity;

	}
}