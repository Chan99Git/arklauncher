package com.example.arklauncher.data;

import com.example.arklauncher.data.model.LoggedInUser;
import java.io.IOException;
import java.util.UUID;

public class LoginDataSource
{
  public Result<LoggedInUser> login(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Result.Success(new LoggedInUser(UUID.randomUUID().toString(), paramString1));
      return paramString1;
    }
    catch (Exception paramString1) {}
    return new Result.Error(new IOException("Error logging in", paramString1));
  }
  
  public void logout() {}
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklauncher\data\LoginDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */