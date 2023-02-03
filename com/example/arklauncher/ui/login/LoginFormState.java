package com.example.arklauncher.ui.login;

class LoginFormState
{
  private boolean isDataValid;
  private Integer passwordError;
  private Integer usernameError;
  
  LoginFormState(Integer paramInteger1, Integer paramInteger2)
  {
    this.usernameError = paramInteger1;
    this.passwordError = paramInteger2;
    this.isDataValid = false;
  }
  
  LoginFormState(boolean paramBoolean)
  {
    this.usernameError = null;
    this.passwordError = null;
    this.isDataValid = paramBoolean;
  }
  
  Integer getPasswordError()
  {
    return this.passwordError;
  }
  
  Integer getUsernameError()
  {
    return this.usernameError;
  }
  
  boolean isDataValid()
  {
    return this.isDataValid;
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklaunche\\ui\login\LoginFormState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */