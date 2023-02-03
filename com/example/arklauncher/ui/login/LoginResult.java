package com.example.arklauncher.ui.login;

class LoginResult
{
  private Integer error;
  private LoggedInUserView success;
  
  LoginResult(LoggedInUserView paramLoggedInUserView)
  {
    this.success = paramLoggedInUserView;
  }
  
  LoginResult(Integer paramInteger)
  {
    this.error = paramInteger;
  }
  
  Integer getError()
  {
    return this.error;
  }
  
  LoggedInUserView getSuccess()
  {
    return this.success;
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklaunche\\ui\login\LoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */