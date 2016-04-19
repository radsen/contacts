package com.mobilebutterfly.pibes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by radsen on 4/18/16.
 */
public class LoginFragment extends Fragment implements FacebookCallback<LoginResult>{

    private static final String TAG = LoginFragment.class.getSimpleName();

    private LoginButton loginButton;
    private CallbackManager callbackManger;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getActivity());

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        callbackManger = CallbackManager.Factory.create();

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);

        loginButton.registerCallback(callbackManger, this);

        return view;
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Log.d(TAG, loginResult.getAccessToken().getToken());
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManger.onActivityResult(requestCode, resultCode, data);
    }
}
