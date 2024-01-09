package com.project1.david.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project1.david.dto.UserDto;
import com.project1.david.entity.User;
import com.project1.david.mapper.MapperUser;
import com.project1.david.repository.UserRepositoty;
import com.project1.david.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositoty userRepo;

	@Autowired
	MapperUser mapperUser;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public HashMap<Integer, String> aggiungiUser(UserDto userDto) throws Exception, IllegalArgumentException {

		log.info("Strat AggiungiUser");
		User entityUser = new User();
		HashMap<Integer, String> datiuser = new HashMap<Integer, String>();

		try {

			entityUser = mapperUser.dtoToEntity(userDto);
			User ret = userRepo.save(entityUser);
			datiuser.put(ret.getIdUser(), ret.getFiscalCode());

		} catch (IllegalArgumentException e) {

			log.error("errore nel mapper " + e.getMessage());
			throw new IllegalArgumentException();
		} catch (Exception ex) {

			log.error("errore nella query " + ex.getMessage());
			throw new Exception();
		}

		return datiuser;

	}

	@Override
	@Transactional
	public HttpStatus aggiungiIdUserAIDIndirizzo(String idIndirizzo) throws Exception {

		log.info("Strat aggiungiIdUserAIDIndirizzo");
		User entityUser = new User();
		Integer idInd = Integer.valueOf(idIndirizzo);
		try {

			// TODO : inserire logica per aggiungere idIndirizzo

			userRepo.updateIdIndirizzo(1, idInd);

		} catch (IllegalArgumentException e) {

			log.error("errore nel mapper " + e.getMessage());
			throw new IllegalArgumentException();
		} catch (Exception ex) {

			log.error("errore nella query " + ex.getMessage());
			throw new Exception();
		}

		return HttpStatus.OK;

	}

	@Override
	public List<UserDto> recuperaListaUtenti() throws Exception {

		List<UserDto> userListDto = new ArrayList<UserDto>();
		List<User> st = userRepo.findAll();
		st.forEach(user -> {
			UserDto userDto = new UserDto();
			try {
				userDto = mapperUser.entitytToDto(user);
				userListDto.add(userDto);
			} catch (Exception e) {
				log.error("errore nel recupero dei dati dal DB " + e.getMessage());
			}
		});
		return userListDto;
	}

}
