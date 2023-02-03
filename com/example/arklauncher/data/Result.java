package com.example.arklauncher.data;

public class Result<T>
{
  public String toString()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if ((this instanceof Success))
    {
      localObject = (Success)this;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Success[data=");
      localStringBuilder.append(((Success)localObject).getData().toString());
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((this instanceof Error))
    {
      localObject = (Error)this;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error[exception=");
      localStringBuilder.append(((Error)localObject).getError().toString());
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static final class Error
    extends Result
  {
    private Exception error;
    
    public Error(Exception paramException)
    {
      super();
      this.error = paramException;
    }
    
    public Exception getError()
    {
      return this.error;
    }
  }
  
  public static final class Success<T>
    extends Result
  {
    private T data;
    
    public Success(T paramT)
    {
      super();
      this.data = paramT;
    }
    
    public T getData()
    {
      return (T)this.data;
    }
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklauncher\data\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */