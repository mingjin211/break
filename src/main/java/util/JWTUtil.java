package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
  static Key KEY;
  JWTUtil(){
    KEY = new SecretKeySpec("javastack".getBytes(), SignatureAlgorithm.HS512.getJcaName());
  }

  public static String generateToken(Map<String, Object> claims) {
    return Jwts.builder()
            .setClaims(claims)
            .setExpiration(new Date(System.currentTimeMillis()+100000L))
            .signWith(SignatureAlgorithm.HS256, "c2f489ffdaa4e9a49a642c722bffd087") //采用什么算法是可以自己选择的，不一定非要采用HS512
            .compact();
  }

  public static Claims getClaimsFromToken(String token) {
    Claims claims;
    try {
      claims = Jwts.parser()
              .setSigningKey(KEY)
              .parseClaimsJws(token)
              .getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

  public static void main(String args[]){
////    Claims claims = getClaimsFromToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Ikpvc2FhaG4yM0RvZSIsImlhdCI6MTUxNjIzOTAyMn0.itinQaAs2YJuP9qkzLljK9CrWqRcJqTL4VT2TBdV3G8");
////    System.out.println(System.currentTimeMillis());
//    if(KEY ==null){
//      KEY = new SecretKeySpec("javastack".getBytes(), SignatureAlgorithm.HS512.getJcaName());
//    }
//
//    Map<String, Object> stringObjectMap = new HashMap<>();
//    stringObjectMap.put("type", "1");
//    String payload = "{\"iss\":\"1341137\", \"exp\":\"2018-01-01 0:00:00\"}";
//    String compactJws = Jwts.builder()
//            .setHeader(stringObjectMap).setId("123")
//            .setIssuedAt(new Date(System.currentTimeMillis()+100000L))
//            .setSubject("subject")
//            .setIssuer("user")
//            .signWith(SignatureAlgorithm.HS512, KEY).compact();
////            .setHeader(stringObjectMap)
////            .setPayload(payload).signWith(SignatureAlgorithm.HS512, KEY).compact();
//
//    System.out.println("jwt key:" + new String(KEY.getEncoded()));
//    System.out.println("jwt payload:" + payload);
//    System.out.println("jwt encoded:" + compactJws);
//    LoginClaims claims = (LoginClaims)getClaimsFromToken(compactJws);
//    System.out.println(claims);
    String x = JWTUtils.genJwtByUser(new Date(),"12323");
    Claims claims = JWTUtils.parseJwtHs256(x+"1","bgzsJwtTokenKey");
    claims.getIssuer();
  }

}
