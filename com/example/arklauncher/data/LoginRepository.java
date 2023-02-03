package com.example.arklauncher.data;

import com.example.arklauncher.data.model.LoggedInUser;

public class LoginRepository
{
  private static volatile LoginRepository instance;
  private LoginDataSource dataSource;
  private LoggedInUser user = null;
  
  private LoginRepository(LoginDataSource paramLoginDataSource)
  {
    this.dataSource = paramLoginDataSource;
  }
  
  public static LoginRepository getInstance(LoginDataSource paramLoginDataSource)
  {
    if (instance == null) {
      instance = new LoginRepository(paramLoginDataSource);
    }
    return instance;
  }
  
  private void setLoggedInUser(LoggedInUser paramLoggedInUser)
  {
    this.user = paramLoggedInUser;
  }
  
  public boolean isLoggedIn()
  {
    return this.user != null;
  }
  
  public Result<LoggedInUser> login(String paramString1, String paramString2)
  {
    paramString1 = this.dataSource.login(paramString1, paramString2);
    if ((paramString1 instanceof Result.Success)) {
      setLoggedInUser((LoggedInUser)((Result.Success)paramString1).getData());
    }
    return paramString1;
  }
  
  public void logout()
  {
    this.user = null;
    this.dataSource.logout();
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklauncher\data\LoginRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */