package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

public class JWTUtils{

  private final static int expiresSecond = 172800000;

  /**
   * 生成HS256签名的JWT
   * @param claims 请求头和荷载
   * @param signKey 密钥
   * @return
   */
  public static String buildJwtHs256(LoginClaims claims, String signKey) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    //生成签名密钥
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(signKey);
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    //添加构成JWT的参数
    JwtBuilder builder = Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setClaims(claims)
            .signWith(signatureAlgorithm, signingKey);

    //添加Token过期时间
    if (expiresSecond >= 0) {
      long expMillis = nowMillis + expiresSecond;
      Date exp = new Date(expMillis);
      builder.setExpiration(exp).setNotBefore(now);
    }

    //生成JWT
    return builder.compact();
  }

  /**
   * 解析HS256签名的JWT
   * @param jsonWebToken
   * @param signKey 密钥
   * @return
   */
  public static Claims parseJwtHs256(String jsonWebToken, String signKey) {
    try {
      return Jwts.parser()
              .setSigningKey(DatatypeConverter.parseBase64Binary(signKey))
              .parseClaimsJws(jsonWebToken).getBody();
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   * 生成RS256签名的JWT
   * @param claims
   * @param privateKey RSA私钥
   * @return
   * @throws Exception
   */
  public static String buildJwtRS256(DefaultClaims claims,PrivateKey privateKey) throws Exception {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;

    JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setClaims(claims)
            .signWith(signatureAlgorithm, privateKey);
    // jwt中需要传递的内容
    builder.claim("id", 10001);
    return builder.compact();
  }

  /**
   * 解密RS256签名的JWT
   * @param jsonWebToken
   * @return
   */
  private static LoginClaims parseJwtRS256(String jsonWebToken,PublicKey publicKey) {
    LoginClaims claims = null;
    try {
      claims = (LoginClaims)Jwts.parser()
              .setSigningKey(publicKey)
              .parseClaimsJws(jsonWebToken).getBody();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return claims;
  }

  public static String  genJwtByUser(Date now,String uuid){
    LoginClaims claims = new LoginClaims();
    claims.setSubject("bgzs");
    claims.setUserId(123L);
    claims.setUserAcount("acc");
    claims.setUserName("name");
    claims.setEmail(".com");
    claims.setMobile("mobile");
    claims.setIssuedAt(now);
    claims.setId(uuid);
    String jwtToken;
//    String passMd5 = MD5Utils.md5("bgzsJwtTokenKey");
    try{
      jwtToken = JWTUtils.buildJwtHs256(claims,"bgzsJwtTokenKey");
    }catch (Exception e){
//      logger.info(localeMessage.getMessage("user.login.jwt.error"));
      throw new RuntimeException("user.login.jwt.error");
    }
    return jwtToken;
  }

}


