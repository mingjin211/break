package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import sun.misc.BASE64Decoder;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import java.util.stream.Collectors;

public class JWTRsaTest {

  public static String buildJwtRS256() throws Exception {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;

    // 读取私钥
    String key = readResourceKey(JWTRsaTest.class.getClassLoader().getResource("pri.pem").getPath());

    // 生成签名密钥
    byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
    JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
            .setIssuer("marco")
            .setSubject("token")
            .signWith(signatureAlgorithm, privateKey);
    // jwt中需要传递的内容
    builder.claim("id", 10001);
    return builder.compact();
  }

  public static String buildJwtRS256(DefaultClaims claims) throws Exception {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;

    // 读取私钥
    String key = readResourceKey(JWTRsaTest.class.getClassLoader().getResource("pri.pem").getPath());

    // 生成签名密钥
    byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
    JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setClaims(claims)
            .setIssuer("marco")
            .setSubject("token")
            .signWith(signatureAlgorithm, privateKey);
    // jwt中需要传递的内容
    builder.claim("id", 10001);
    return builder.compact();
  }


  public static Claims parseJwtRS256(String jwt) {
    Claims claims = null;
    try {
      // 读取公钥
      String key = readResourceKey(JWTRsaTest.class.getClassLoader().getResource("pub.pem").getPath());
      // 生成签名公钥
      byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PublicKey publicKey = keyFactory.generatePublic(keySpec);
      claims = Jwts.parser()
              .setSigningKey(publicKey)
              .parseClaimsJws(jwt).getBody();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return claims;
  }

  public static void main(String args[]) throws Exception{
    String fileName = JWTRsaTest.class.getClassLoader().getResource("pub.pem").getPath();
    String jwt = buildJwtRS256();
    System.out.println(jwt);
    Claims claims = parseJwtRS256(jwt);
    System.out.println("x");

  }

  /**
   * 读取资源文件
   *
   * @param fileName
   * @return
   */
  public static String readResourceKey(String fileName) {
    String key = null;
    try {
      File file = new File(fileName);
      List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());
      lines = lines.subList(1, lines.size() - 1);
      key = lines.stream().collect(Collectors.joining());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return key;
  }
}
