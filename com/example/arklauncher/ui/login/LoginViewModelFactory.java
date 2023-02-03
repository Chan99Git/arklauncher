package com.example.arklauncher.ui.login;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.example.arklauncher.data.LoginDataSource;
import com.example.arklauncher.data.LoginRepository;

public class LoginViewModelFactory
  implements ViewModelProvider.Factory
{
  public <T extends ViewModel> T create(Class<T> paramClass)
  {
    if (paramClass.isAssignableFrom(LoginViewModel.class)) {
      return new LoginViewModel(LoginRepository.getInstance(new LoginDataSource()));
    }
    throw new IllegalArgumentException("Unknown ViewModel class");
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklaunche\\ui\login\LoginViewModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */