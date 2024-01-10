package com.project2.indirizzo.serviceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project2.indirizzo.dto.MasterDataDto;
import com.project2.indirizzo.entity.MasterData;
import com.project2.indirizzo.mapper.MapperMasterData;
import com.project2.indirizzo.repository.MasterDataRepository;
import com.project2.indirizzo.service.MasterDataService;

@Service
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	MasterDataRepository userRepo;

	@Autowired
	MapperMasterData mapperUser;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public String aggiungiAnagrafica(MasterDataDto userDto) throws Exception, IllegalArgumentException {
		
		log.info("Strat AggiungiUser");
		MasterData entityUser = new MasterData();
		String id;
		try {

			entityUser = mapperUser.dtoToEntity(userDto);
			MasterData ret = userRepo.save(entityUser);
			 id =  String.valueOf(ret.getIdData()) ;
		
			
		} catch (IllegalArgumentException e) {
			
			log.error("errore nel mapper " + e.getMessage());
			throw new IllegalArgumentException();
		} catch (Exception ex) {
			
			log.error("errore nella query " + ex.getMessage());
			throw new Exception();
		}

		return id;

	}
	
}
