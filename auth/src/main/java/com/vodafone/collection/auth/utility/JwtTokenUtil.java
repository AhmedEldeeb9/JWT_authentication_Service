package com.vodafone.collection.auth.utility;

import com.vodafone.collection.auth.constants.AuthConstant;
import com.vodafone.collection.auth.repo.ConfigurationRepository;
import com.vodafone.collection.auth.service.ConfigurationEntityService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Autowired
    private ConfigurationEntityService configurationEntityService;


    public String generateToken(String userName, List<Long> userFinalResources) throws Exception {
        Map<String, Object> claims = new HashMap<>();
        claims.put("jti", generateRandomString(10));

        claims.put("authorities", userFinalResources);

        claims.put("name", userName);


        return doGenerateToken(claims, userName);
    }


    private String doGenerateToken(Map<String, Object> claims, String userName) {

        long JWT_TOKEN_VALIDITY = Integer
                .parseInt(configurationEntityService.getByKey(AuthConstant.JWT_TOKEN_VALIDITY).getValue());

        String secretJWTKey = configurationEntityService.getByKey(AuthConstant.JWT_SECRET_KEY).getValue();
        Date jwtCreation = new Date(System.currentTimeMillis());

        Date expiratioDate = new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 60000);
        return Jwts.builder().setClaims(claims).setSubject(userName)
                .setIssuedAt(jwtCreation)
                .signWith(SignatureAlgorithm.HS256, secretJWTKey.getBytes()).compact();


    }

//	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = getAllClaimsFromToken(token);
//		return claimsResolver.apply(claims);
//	}

//	private Claims getAllClaimsFromToken(String token) {
//
//		String secretJWTKey = configurationEntityService.getByKey(AuthConstant.JWT_SECRET_KEY).getValue();
//		return Jwts.parser().setSigningKey(secretJWTKey).parseClaimsJws(token).getBody();
//	}

    // retrieve username from jwt token
//	public String getUsernameFromToken(String token) {
//		return getClaimFromToken(token, Claims::getSubject);
//	}

//	private void logUserLogin(SMUsers userDetails, String jti,int channelType) {
//		try {
//
//			SMUserLog userLog = new SMUserLog();
//			userLog.setJobTitle(userDetails.getJobTitle());
//			userLog.setLoggingAt(userDetails.getLoggingAt());
//			userLog.setManagerName(userDetails.getManagerName());
//			userLog.setName(userDetails.getName());
//			userLog.setPhoneNumber(userDetails.getPhoneNumber());
//			userLog.setTokenExpirationDate(userDetails.getTokenExpirationDate());
//			userLog.setUserId(userDetails.getUserId());
//			userLog.setUserType(userDetails.getUserType());
//			userLog.setJti(jti);
//			userLog.setChannelType(channelType);
//			userLogRepository.save(userLog);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

    private static final String CHAR_LOWER = "abcdefghjkmnopqrstuvwxyz";
    //	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "023456789";
    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + NUMBER;
    private static SecureRandom random = new SecureRandom();

    public static String generateRandomString(int length) {
        if (length < 1)
            throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }

        return sb.toString();

    }
}