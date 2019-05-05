package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Date;
import java.util.Map;

public class LoginClaims extends DefaultClaims implements Claims {

  public LoginClaims() {
    super();
  }

  public LoginClaims(Map<String, Object> map) {
    super(map);
  }

  public LoginClaims(Claims claims) {
    this.setEmail((String)claims.get(USER_ID));
    this.setUserId((Long)claims.get(USER_NAME));
    this.setUserAcount((String)claims.get(USER_ACOUNT));
    this.setEmail((String)claims.get(EMAIL));
    this.setMobile((String)claims.get(MOBILE));
    this.setSessionId((String)claims.get(SESSION_ID));
    this.setState((String)claims.get(STATE));
  }

  /** JWT {@code USER_ID} claims parameter name: <code>"usi"</code> */
  public static final String USER_ID = "usi";

  /** JWT {@code USER_NAME} claims parameter name: <code>"usn"</code> */
  public static final String USER_NAME = "usn";

  /** JWT {@code USER_ACOUNT} claims parameter name: <code>"usa"</code> */
  public static final String USER_ACOUNT = "usa";

  /** JWT {@code EMAIL} claims parameter name: <code>"eml"</code> */
  public static final String EMAIL = "eml";

  /** JWT {@code MOBILE} claims parameter name: <code>"mbl"</code> */
  public static final String MOBILE = "mbl";

  /** JWT {@code SESSION_ID} claims parameter name: <code>"ssi"</code> */
  public static final String SESSION_ID = "ssi";

  /** JWT {@code REFRESH} claims parameter name: <code>"rsh"</code> */
  public static final String STATE = "sta";

  public long getUserId() {
    return get(USER_ID,long.class);
  }

  public Claims setUserId(long usi) {
    setValue(USER_ID, usi);
    return this;
  }

  public String getUserName() {
    return getString(USER_NAME);
  }

  public Claims setUserName(String usn) {
    setValue(USER_NAME, usn);
    return this;
  }

  public String getUserAcount() {
    return getString(USER_ACOUNT);
  }

  public Claims setUserAcount(String usa) {
    setValue(USER_ACOUNT, usa);
    return this;
  }

  public String getEmail() {
    return getString(EMAIL);
  }

  public Claims setEmail(String eml) {
    setValue(EMAIL, eml);
    return this;
  }

  public String getMobile() {
    return getString(MOBILE);
  }

  public Claims setMobile(String mbl) {
    setValue(MOBILE, mbl);
    return this;
  }

  public String getSessionId() {
    return getString(SESSION_ID);
  }

  public Claims setSessionId(String ssi) {
    setValue(SESSION_ID, ssi);
    return this;
  }

  public String getState() {
    return getString(STATE);
  }

  public Claims setState(String sta) {
    setValue(STATE, sta);
    return this;
  }


  @Override
  public String getIssuer() {
    return getString(ISSUER);
  }

  @Override
  public Claims setIssuer(String iss) {
    setValue(ISSUER, iss);
    return this;
  }

  @Override
  public String getSubject() {
    return getString(SUBJECT);
  }

  @Override
  public Claims setSubject(String sub) {
    setValue(SUBJECT, sub);
    return this;
  }

  @Override
  public String getAudience() {
    return getString(AUDIENCE);
  }

  @Override
  public Claims setAudience(String aud) {
    setValue(AUDIENCE, aud);
    return this;
  }

  @Override
  public Date getExpiration() {
    return get(Claims.EXPIRATION, Date.class);
  }

  @Override
  public Claims setExpiration(Date exp) {
    setDate(Claims.EXPIRATION, exp);
    return this;
  }

  @Override
  public Date getNotBefore() {
    return get(Claims.NOT_BEFORE, Date.class);
  }

  @Override
  public Claims setNotBefore(Date nbf) {
    setDate(Claims.NOT_BEFORE, nbf);
    return this;
  }

  @Override
  public Date getIssuedAt() {
    return get(Claims.ISSUED_AT, Date.class);
  }

  @Override
  public Claims setIssuedAt(Date iat) {
    setDate(Claims.ISSUED_AT, iat);
    return this;
  }

  @Override
  public String getId() {
    return getString(ID);
  }

  @Override
  public Claims setId(String jti) {
    setValue(Claims.ID, jti);
    return this;
  }

  @Override
  public <T> T get(String claimName, Class<T> requiredType) {
    Object value = get(claimName);
    if (value == null) { return null; }

    if (Claims.EXPIRATION.equals(claimName) ||
            Claims.ISSUED_AT.equals(claimName) ||
            Claims.NOT_BEFORE.equals(claimName)
    ) {
      value = getDate(claimName);
    }

    return castClaimValue(value, requiredType);
  }

  private <T> T castClaimValue(Object value, Class<T> requiredType) {
    if (requiredType == Date.class && value instanceof Long) {
      value = new Date((Long)value);
    }

    if (value instanceof Integer) {
      int intValue = (Integer) value;
      if (requiredType == Long.class) {
        value = (long) intValue;
      } else if (requiredType == Short.class && Short.MIN_VALUE <= intValue && intValue <= Short.MAX_VALUE) {
        value = (short) intValue;
      } else if (requiredType == Byte.class && Byte.MIN_VALUE <= intValue && intValue <= Byte.MAX_VALUE) {
        value = (byte) intValue;
      }
    }

    if (!requiredType.isInstance(value)) {
      throw new RequiredTypeException("Expected value to be of type: " + requiredType + ", but was " + value.getClass());
    }

    return requiredType.cast(value);
  }

}
