package com.example.arklauncher.ui.login;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.arklauncher.databinding.ActivityLoginBinding;

public class LoginActivity
  extends AppCompatActivity
{
  private ActivityLoginBinding binding;
  private LoginViewModel loginViewModel;
  
  private void showLoginFailed(Integer paramInteger)
  {
    Toast.makeText(getApplicationContext(), paramInteger.intValue(), 0).show();
  }
  
  private void updateUiWithUser(LoggedInUserView paramLoggedInUserView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131624043));
    localStringBuilder.append(paramLoggedInUserView.getDisplayName());
    paramLoggedInUserView = localStringBuilder.toString();
    Toast.makeText(getApplicationContext(), paramLoggedInUserView, 1).show();
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ActivityLoginBinding.inflate(getLayoutInflater());
    this.binding = paramBundle;
    setContentView(paramBundle.getRoot());
    this.loginViewModel = ((LoginViewModel)new ViewModelProvider(this, new LoginViewModelFactory()).get(LoginViewModel.class));
    paramBundle = this.binding.username;
    final EditText localEditText = this.binding.password;
    final Button localButton = this.binding.login;
    final Object localObject = this.binding.loading;
    SharedPreferences localSharedPreferences = getSharedPreferences("ArkLauncher", 0);
    if (localSharedPreferences.contains("url"))
    {
      paramBundle.setText(localSharedPreferences.getString("url", ""));
      localButton.setEnabled(true);
    }
    this.loginViewModel.getLoginFormState().observe(this, new Observer()
    {
      public void onChanged(LoginFormState paramAnonymousLoginFormState)
      {
        if (paramAnonymousLoginFormState == null) {
          return;
        }
        localButton.setEnabled(paramAnonymousLoginFormState.isDataValid());
        if (paramAnonymousLoginFormState.getUsernameError() != null) {
          paramBundle.setError(LoginActivity.this.getString(paramAnonymousLoginFormState.getUsernameError().intValue()));
        }
        if (paramAnonymousLoginFormState.getPasswordError() != null) {
          localEditText.setError(LoginActivity.this.getString(paramAnonymousLoginFormState.getPasswordError().intValue()));
        }
      }
    });
    this.loginViewModel.getLoginResult().observe(this, new Observer()
    {
      public void onChanged(LoginResult paramAnonymousLoginResult)
      {
        if (paramAnonymousLoginResult == null) {
          return;
        }
        localObject.setVisibility(8);
        if (paramAnonymousLoginResult.getError() != null) {
          LoginActivity.this.showLoginFailed(paramAnonymousLoginResult.getError());
        }
        if (paramAnonymousLoginResult.getSuccess() != null) {
          LoginActivity.this.updateUiWithUser(paramAnonymousLoginResult.getSuccess());
        }
        LoginActivity.this.setResult(-1);
        LoginActivity.this.finish();
      }
    });
    localObject = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        LoginActivity.this.loginViewModel.loginDataChanged(paramBundle.getText().toString(), localEditText.getText().toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramBundle.addTextChangedListener((TextWatcher)localObject);
    localEditText.addTextChangedListener((TextWatcher)localObject);
    localEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 6) {
          LoginActivity.this.loginViewModel.login(paramBundle.getText().toString(), localEditText.getText().toString());
        }
        return false;
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ComponentName localComponentName = new ComponentName("com.hypergryph.arknightss", "com.u8.sdk.U8UnityContext");
        String str = paramBundle.getText().toString();
        Object localObject = str.replace(" ", "");
        paramAnonymousView = (View)localObject;
        if (((String)localObject).indexOf("http://") == -1)
        {
          paramAnonymousView = new StringBuilder();
          paramAnonymousView.append("http://");
          paramAnonymousView.append((String)localObject);
          paramAnonymousView = paramAnonymousView.toString();
        }
        localObject = paramAnonymousView;
        if (paramAnonymousView.length() != 103)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramAnonymousView);
          ((StringBuilder)localObject).append("?");
          for (paramAnonymousView = ((StringBuilder)localObject).toString();; paramAnonymousView = ((StringBuilder)localObject).toString())
          {
            localObject = paramAnonymousView;
            if (paramAnonymousView.length() == 103) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramAnonymousView);
            ((StringBuilder)localObject).append("0");
          }
        }
        paramAnonymousView = new Intent();
        Bundle localBundle = new Bundle();
        localBundle.putString("url", (String)localObject);
        paramAnonymousView.putExtras(localBundle);
        paramAnonymousView.setComponent(localComponentName);
        LoginActivity.this.startActivity(paramAnonymousView);
        paramAnonymousView = LoginActivity.this.getSharedPreferences("ArkLauncher", 0).edit();
        paramAnonymousView.putString("url", str);
        paramAnonymousView.commit();
      }
    });
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklaunche\\ui\login\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */