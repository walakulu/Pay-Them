package com.recruit.paythem.enums;

/**
 * <p>
 * Keep all the application error codes & messages(If application need to support internationalised
 * ,move these errors in to external properties files).
 * </p>
 * 
 * @author Hasitha Maduranga
 *
 */
public enum ResponseMessage {
  // c- client , s-server 
  BAD_REQUEST("C001", "Malformed JSON request"), 
  ENTITY_NOT_FOUND("C402","Request Entity Not Found"), 
  INVALID_DATE("C403","Invalid Date"),
  SUCCESS("S500", "Success"),
  DATA_NOT_AVAILABLE("S501","Data Not Available"),
  NO_HEAD_HUNTERS("S502","No Registed Head Hunters"),
  DATA_NOT_FOUND_FOR_GIVEN_PARAM("S503","No Data Found For Given Params"),
  NO_BILL_INFO("S504","NO Bill Info");


  private final String code;
  private final String message;

  ResponseMessage(String code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * Gives the custom error code.
   * 
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gives the error message.
   * 
   * @return the message
   */
  public String getMessage() {
    return message;
  }


}


