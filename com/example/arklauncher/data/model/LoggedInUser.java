package com.example.arklauncher.data.model;

public class LoggedInUser
{
  private String displayName;
  private String userId;
  
  public LoggedInUser(String paramString1, String paramString2)
  {
    this.userId = paramString1;
    this.displayName = paramString2;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklauncher\data\model\LoggedInUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */