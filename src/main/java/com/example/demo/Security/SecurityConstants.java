package com.example.demo.Security;

class SecurityConstants {
  
  static final String SECRET = "SecretKeyToGenJWTs";
  static final long EXPIRATION_TIME = 864_000_000; // 10 days
  static final String TOKEN_PREFIX = "Bearer ";
  static final String HEADER_STRING = "Authorization";
  static final String SIGN_UP_URL = "/sign-up";
  static final String LOG_OUT_URL = "/logout";
  static final String UPVOTE_URL = "/upvote/**";
  static final String DOWNVOTE_URL = "/downvote/**";
  static final String DELETE_URL = "/delete/**";
  static final String EDIT_URL = "/edit/**";
  static final String ADD_URL = "/add";
}