// Generated by view binder compiler. Do not edit!
package com.example.gymapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gymapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final EditText edPassword;

  @NonNull
  public final EditText edUsername;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView txtLogin;

  private ActivityLoginBinding(@NonNull LinearLayoutCompat rootView, @NonNull Button btnLogin,
      @NonNull EditText edPassword, @NonNull EditText edUsername, @NonNull ProgressBar progressBar,
      @NonNull TextView txtLogin) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.edPassword = edPassword;
    this.edUsername = edUsername;
    this.progressBar = progressBar;
    this.txtLogin = txtLogin;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogin;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.edPassword;
      EditText edPassword = ViewBindings.findChildViewById(rootView, id);
      if (edPassword == null) {
        break missingId;
      }

      id = R.id.edUsername;
      EditText edUsername = ViewBindings.findChildViewById(rootView, id);
      if (edUsername == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.txtLogin;
      TextView txtLogin = ViewBindings.findChildViewById(rootView, id);
      if (txtLogin == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayoutCompat) rootView, btnLogin, edPassword,
          edUsername, progressBar, txtLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}