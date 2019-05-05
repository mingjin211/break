package util;

import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import java.util.stream.Collectors;

public class RSAUtils {
  public static final String RSA_ALGORITHM = "RSA";
  public static final Charset UTF8 = Charset.forName("UTF-8");

  public static void main(String[] args) throws Exception {
    // generate public and private keys
//    KeyPair keyPair = buildKeyPair();
//    PublicKey publicKey = keyPair.getPublic();
//    PrivateKey privateKey = keyPair.getPrivate();


    long past = System.currentTimeMillis();
    PrivateKey privateKey = loadPrivateKey(readResourceKey(RSAUtils.class.getClassLoader().getResource("pri.pem").getPath()));
    System.out.println("loadPrivateKey cost time:" + (System.currentTimeMillis() - past));

    past = System.currentTimeMillis();
    PublicKey publicKey = loadPublicKey(readResourceKey(RSAUtils.class.getClassLoader().getResource("pub.pem").getPath()));
    System.out.println("loadPublicKey cost time:" + (System.currentTimeMillis() - past));

    // encrypt the message
    past = System.currentTimeMillis();
    byte[] encrypted = encrypt(publicKey, "MyPassword");
    System.out.println(base64Encode(encrypted));  // <<encrypted message>>
    System.out.println("encrypt cost time:" + (System.currentTimeMillis() - past));

    // decrypt the message
    past = System.currentTimeMillis();
    byte[] secret = decrypt(privateKey, encrypted);
    System.out.println(new String(secret, UTF8));     // This is a secret message

    System.out.println("decrypt cost time:" + (System.currentTimeMillis() - past));
  }

  public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
    final int keySize = 2048;
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
    keyPairGenerator.initialize(keySize);
    return keyPairGenerator.genKeyPair();
  }

  public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
    Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, privateKey);

    return cipher.doFinal(message.getBytes(UTF8));
  }

  public static byte[] decrypt(PublicKey publicKey, byte[] encrypted) throws Exception {
    Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, publicKey);

    return cipher.doFinal(encrypted);
  }

  public static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
    Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);

    return cipher.doFinal(message.getBytes(UTF8));
  }

  public static byte[] decrypt(PrivateKey privateKey, byte[] encrypted) throws Exception {
    Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, privateKey);

    return cipher.doFinal(encrypted);
  }

  /**
   * 从字符串中加载公钥
   */
  public static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
    try {
      byte[] buffer = base64Decode(publicKeyStr);
      KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
      return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
    try {
      byte[] buffer = base64Decode(privateKeyStr);
      PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
      KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
      return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public void savePublicKey(PublicKey publicKey) throws IOException {
    // 得到公钥字符串
    String publicKeyString = base64Encode(publicKey.getEncoded());
    System.out.println("publicKeyString=" + publicKeyString);
    FileWriter fw = new FileWriter("publicKey.keystore");
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(publicKeyString);
    bw.close();
  }

  public void savePrivateKey(PrivateKey privateKey) throws IOException {
    // 得到私钥字符串
    String privateKeyString = base64Encode(privateKey.getEncoded());
    System.out.println("privateKeyString=" + privateKeyString);

    BufferedWriter bw = new BufferedWriter(new FileWriter("privateKey.keystore"));
    bw.write(privateKeyString);
    bw.close();
  }

  public static String base64Encode(byte[] data) {
    return new BASE64Encoder().encode(data);
  }

  public static byte[] base64Decode(String data) throws IOException {
    return new BASE64Decoder().decodeBuffer(data);
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
