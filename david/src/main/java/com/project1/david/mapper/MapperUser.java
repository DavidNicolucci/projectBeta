package com.project1.david.mapper;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.project1.david.dto.UserDto;
import com.project1.david.entity.User;
import com.project1.david.utils.ValidationUtils;

@Component
public class MapperUser {

	private final Logger log = LoggerFactory.getLogger(getClass());

//	@Autowired
//	private PasswordEncoder passEncoder;
	
	
	public User dtoToEntity(UserDto userDto)throws Exception {
		
		Set<String> allowedRoles = new HashSet<>();
				
//				Set.of("USER", "ADMIN").
		
		allowedRoles.addAll(Stream.of("USER", "ADMIN")
                .collect(Collectors.toSet()));
		log.info("Strat dtoToEntity");
		User userEntity = new User();

		userEntity.setDateOfBirth(userDto.getDateOfBirth() != null ? userDto.getDateOfBirth() : null);
		//TODO verifica che la data sia nel formato giusto
		if (userEntity.getDateOfBirth() == null) {
			ValidationUtils.throwNotValid(false, "data non presente");
		}
		
		//TODO verifica codice fiscale
		userEntity.setFiscalCode( Optional.ofNullable(userDto.getFiscalCode())
				.orElseThrow(()-> new IllegalArgumentException("codice fidcale non valido")));
		
		
		userEntity.setNameUser(Optional.ofNullable(userDto.getNameUser())
				.orElseThrow(()-> new IllegalArgumentException("nome utente non valido")));
		
		userEntity.setSurnameUser(Optional.ofNullable(userDto.getSurnameUser())
				.orElseThrow(()-> new IllegalArgumentException("cognome utente non valido")));
		
		//setta la password
//	    userEntity.setPassword(passEncoder.encode("spring"));
	   
//	    userEntity.setRoles(Optional.ofNullable(userDto.getRoles())
//verfica se userDto.getRoles() sia presente la stringa ADMIN o USER
//	    		  .filter(roles -> allowedRoles.contains(roles))
//	    		  .orElseThrow(()->new IllegalArgumentException("ruolo utente non valido")));

		
		return userEntity;

	}



	public UserDto entitytToDto(User user)throws Exception {
		
		log.info("Strat entitytToDto");
		
		UserDto userDto = new UserDto();
		
		userDto.setDateOfBirth(user.getDateOfBirth() != null ? user.getDateOfBirth() : null);
		//TODO verifica che la data sia nel formato giusto
		if (userDto.getDateOfBirth() == null) {
			ValidationUtils.throwNotValid(false, "data non presente");
		}
		
		//TODO verifica codice fiscale
		userDto.setFiscalCode( Optional.ofNullable(user.getFiscalCode())
				.orElseThrow(()-> new IllegalArgumentException("codice fidcale non valido")));
		
		userDto.setNameUser(Optional.ofNullable(user.getNameUser())
				.orElseThrow(()-> new IllegalArgumentException("nome utente non valido")));
		
		userDto.setSurnameUser(Optional.ofNullable(user.getSurnameUser())
				.orElseThrow(()-> new IllegalArgumentException("cognome utente non valido")));

//		userDto.setRoles(Optional.ofNullable(user.getRoles())
//	    		  .orElseThrow(()->new IllegalArgumentException("ruolo utente non valido")));

	
		return userDto;
		
	}



}