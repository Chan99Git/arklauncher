package com.example.arklauncher.ui.login;

import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.arklauncher.data.LoginRepository;
import com.example.arklauncher.data.Result.Success;
import com.example.arklauncher.data.model.LoggedInUser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginViewModel
  extends ViewModel
{
  private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData();
  private LoginRepository loginRepository;
  private MutableLiveData<LoginResult> loginResult = new MutableLiveData();
  
  LoginViewModel(LoginRepository paramLoginRepository)
  {
    this.loginRepository = paramLoginRepository;
  }
  
  private boolean isPasswordValid(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() > 5);
  }
  
  private boolean isUserNameValid(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.contains("@")) {
      return Patterns.EMAIL_ADDRESS.matcher(paramString).matches();
    }
    return paramString.trim().isEmpty() ^ true;
  }
  
  LiveData<LoginFormState> getLoginFormState()
  {
    return this.loginFormState;
  }
  
  LiveData<LoginResult> getLoginResult()
  {
    return this.loginResult;
  }
  
  public void login(String paramString1, String paramString2)
  {
    paramString1 = (LoggedInUser)((Result.Success)this.loginRepository.login(paramString1, paramString2)).getData();
    this.loginResult.setValue(new LoginResult(new LoggedInUserView(paramString1.getDisplayName())));
  }
  
  public void loginDataChanged(String paramString1, String paramString2)
  {
    if (!isUserNameValid(paramString1))
    {
      this.loginFormState.setValue(new LoginFormState(Integer.valueOf(2131623981), null));
      return;
    }
    this.loginFormState.setValue(new LoginFormState(true));
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklaunche\\ui\login\LoginViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */