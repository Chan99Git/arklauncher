package com.example.arklauncher.databinding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

public final class ActivityLoginBinding
  implements ViewBinding
{
  public final ConstraintLayout container;
  public final ProgressBar loading;
  public final Button login;
  public final EditText password;
  private final ConstraintLayout rootView;
  public final EditText username;
  
  private ActivityLoginBinding(ConstraintLayout paramConstraintLayout1, ConstraintLayout paramConstraintLayout2, ProgressBar paramProgressBar, Button paramButton, EditText paramEditText1, EditText paramEditText2)
  {
    this.rootView = paramConstraintLayout1;
    this.container = paramConstraintLayout2;
    this.loading = paramProgressBar;
    this.login = paramButton;
    this.password = paramEditText1;
    this.username = paramEditText2;
  }
  
  public static ActivityLoginBinding bind(View paramView)
  {
    ConstraintLayout localConstraintLayout = (ConstraintLayout)paramView;
    int i = 2131230926;
    ProgressBar localProgressBar = (ProgressBar)ViewBindings.findChildViewById(paramView, 2131230926);
    if (localProgressBar != null)
    {
      i = 2131230927;
      Button localButton = (Button)ViewBindings.findChildViewById(paramView, 2131230927);
      if (localButton != null)
      {
        i = 2131231000;
        EditText localEditText1 = (EditText)ViewBindings.findChildViewById(paramView, 2131231000);
        if (localEditText1 != null)
        {
          EditText localEditText2 = (EditText)ViewBindings.findChildViewById(paramView, 2131231126);
          if (localEditText2 != null) {
            return new ActivityLoginBinding((ConstraintLayout)paramView, localConstraintLayout, localProgressBar, localButton, localEditText1, localEditText2);
          }
          i = 2131231126;
        }
      }
      else {}
    }
    throw new NullPointerException("Missing required view with ID: ".concat(paramView.getResources().getResourceName(i)));
  }
  
  public static ActivityLoginBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, null, false);
  }
  
  public static ActivityLoginBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131427356, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.addView(paramLayoutInflater);
    }
    return bind(paramLayoutInflater);
  }
  
  public ConstraintLayout getRoot()
  {
    return this.rootView;
  }
}


/* Location:              C:\Users\admin\Desktop\dex2jar-2.0\dex2jar-2.0\3_方舟代理.jar!\com\example\arklauncher\databinding\ActivityLoginBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */