package com.project1.david.utils;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.http.HttpStatus;

import com.project1.david.execption.NotFoundException;
import com.project1.david.execption.NotValidException;



public class ValidationUtils {

	
	private static final String SPECIAL_CHAR_REGEX = "[!@#$%^&*(),?\":{}/|<>=]";
    private static Pattern pattern = Pattern.compile(SPECIAL_CHAR_REGEX, Pattern.CASE_INSENSITIVE);

    public static NotFoundException throwNotFound(String messaggio) {
        return new NotFoundException(HttpStatus.NOT_FOUND.value(), messaggio);
    }

    public static boolean isEmpty(String var) {
        return (var == null || "".equals(var));
    }

    public static boolean isEmpty(Date var) {
        return (var == null);
    }

    public static boolean isEmpty(Integer var) {
        return (var == null);
    }

    public static boolean isEmpty(List<?> var) {
        return var == null || var.isEmpty();
    }

    public static boolean isEmpty(Set<?> var) {
        return var == null || var.isEmpty();
    }

    public static void throwNotValid(boolean condition, String message, int code) throws NotValidException {
        if (condition) throw new NotValidException(code, message);
    }

    public static void throwNotValid(boolean condition, String message) throws NotValidException {
        throwNotValid(condition, message, HttpStatus.NOT_ACCEPTABLE.value());
    }

    public static void throwNoContent(boolean condition, String message) throws NotValidException {
        throwNotValid(condition, message, HttpStatus.NO_CONTENT.value());
    }

    public static void throwNotFound(boolean condition, String message, int code) throws NotFoundException {
        if (condition) throw new NotFoundException(code, message);
    }

    public static void throwNotFound(boolean condition, String message) throws NotFoundException {
        throwNotFound(condition, message, HttpStatus.NOT_FOUND.value());
    }

    public static void checkRule(Set<String> errori, boolean condition, String errorMessage) {
        if (condition) errori.add(errorMessage);
    }

    public static void throwNotValidRulesIfPresent(Set<String> errori) throws NotValidException {
        StringBuilder builder = new StringBuilder();
        errori.forEach(s -> builder.append("<p>").append(s).append("</p>"));
        throwNotValid(!isEmpty(errori), builder.toString());
    }

    public static void checkBlockingRule(Set<String> errori, boolean condition, String errorMessage) throws NotValidException {
        if (condition) errori.add(errorMessage);
        throwNotValid(true, null, HttpStatus.NOT_ACCEPTABLE.value());
    }

    public static List nullSafeStream(List collection) {
        return Optional.ofNullable(collection).orElse(Collections.emptyList());
    }

    public static boolean isListOrdinataSequenziale(List<Long> listaIdCriteriDto) {
        return isElementoSequenziale(listaIdCriteriDto.stream().sorted().collect(Collectors.toList()), 0);
    }

    public static boolean isElementoSequenziale(List<Long> numeriOrdinati, int index) {
        if (index == numeriOrdinati.size()) return true;
        Long num = numeriOrdinati.get(index);
        Long numPrec = index == 0 ? 0L : numeriOrdinati.get(index - 1);
        if (num.compareTo(Long.sum(numPrec, 1)) == 0) return isElementoSequenziale(numeriOrdinati, ++index);
        return false;
    }

    public static boolean contieneCaratteriNonAmmessi (String toVerify){
        return pattern.matcher(toVerify).find();
    }

    public static String removeLastCharacter(String str) {
        String result = Optional.ofNullable(str)
                .filter(sStr -> sStr.length() != 0)
                .map(sStr -> sStr.substring(0, sStr.length() - 1))
                .orElse(str);
        return result;
    }

    public static String getCaratteriNonAmmessi(String testo) {
        String nonAmmessi = testo.replaceAll("[a-zA-Z0-9-\\s.]+", "");
        String[] split = nonAmmessi.split("");
        StringBuilder nonAmmessiBuilder = new StringBuilder();
        for (String s : split) {
            nonAmmessiBuilder.append("'").append(s).append("', ");
        }
        nonAmmessi = nonAmmessiBuilder.toString();
        return removeLastCharacter(nonAmmessi);
    }
    
    /**
     * controlla se il valore passato è vero
     * @param val
     * @return true se il valore è diverso da null e pari a Boolean.TRUE
     */
    public static boolean isTrue(Boolean val) {
        return Boolean.TRUE.equals(val);
    }

    /**
     * controlla se il valore passato è falso
     * @param val
     * @return true se il valore è diverso da null e pari a Boolean.FALSE
     */
    public static boolean isFalse(Boolean val) {
        return Boolean.FALSE.equals(val);
    }

    /**
     * controlla  che la condizione di input sull'oggetto di input sia vera o falsa, 
     * @param p condizione da verificare, 
     * @param T oggetto su cui verificare la condizione, 
     * @param msg messaggio da restituire in caso la condizione sia vera
     * @return se vera restituisce
     * optional del messaggio se falsa restituisce un Optional vuoto
     */
   public static <T> Optional<String> checkParam(Predicate<T> p, T valueObj, String msg) {
    	return p.test(valueObj)?Optional.of(msg):Optional.empty();
    }
   
   public static Set<String> addError(boolean condition, String errorMsg, Set<String>errors){
	   if(errors == null) {
		   errors = new HashSet<String>();
	   }
	   if(condition) {
		   errors.add(errorMsg);
	   }
	   return errors;
   }
   

}
