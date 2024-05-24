package com.example.coachingapp;

import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.mockito.Mockito.*;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(Looper.class)
public class MainActivityTest {

    @Mock
    FirebaseAuth fAuth;

    @Mock
    FirebaseAuth.AuthStateListener authStateListener;

    @Mock
    Task<AuthResult> task;

    @Mock
    EditText mEmail;

    @Mock
    EditText mPassword;

    @Mock
    Button mLogin;

    @Mock
    TextView notRegister;

    @Mock
    ProgressBar progressBar;

    MainActivity mainActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockLooper(); // Mock Looper
        mainActivity = new MainActivity();
        mainActivity.fAuth = fAuth;
        mainActivity.authStateListener = authStateListener;
        mainActivity.mEmail = mEmail;
        mainActivity.mPassword = mPassword;
        mainActivity.mLogin = mLogin;
        mainActivity.notRegister = notRegister;
        mainActivity.progressBar = progressBar;
    }

    // Method to mock Looper class
    private void mockLooper() {
        Looper mockedLooper = mock(Looper.class);
        when(mockedLooper.myLooper()).thenReturn(mockedLooper);
        PowerMockito.mockStatic(Looper.class);
        PowerMockito.when(Looper.myLooper()).thenReturn(mockedLooper);
    }

    @Test
    public void testLoginButtonClicked() {
        // Simulate button click
        // Stubbing getText() method on mEmail EditText
        when(mEmail.getText().toString()).thenReturn("test@example.com");

        // Stubbing getText() method on mPassword EditText
        when(mPassword.getText().toString()).thenReturn("password");

        // Mock sign-in behavior
        when(fAuth.signInWithEmailAndPassword("test@example.com", "password")).thenReturn(task);
        when(task.isSuccessful()).thenReturn(true);

        mainActivity.mLogin.performClick();

        // Verify that progress bar is shown
        verify(progressBar).setVisibility(View.VISIBLE);

        // Verify that email and password are retrieved
        verify(mEmail).getText();
        verify(mPassword).getText();

        // Verify that Firebase sign-in is attempted
        verify(fAuth).signInWithEmailAndPassword("test@example.com", "password");
    }

    @Test
    public void testEmptyEmail() {
        when(mEmail.getText().toString()).thenReturn("");
        mainActivity.mLogin.performClick();
        verify(mEmail).setError("Email is Required.");
    }

    @Test
    public void testEmptyPassword() {
        // Simulate button click
        when(mEmail.getText().toString()).thenReturn("test@example.com");
        when(mPassword.getText().toString()).thenReturn(""); // Empty password

        mainActivity.mLogin.performClick();

        // Verify that error is set on password EditText
        verify(mPassword).setError("Password is Required.");
    }

    @Test
    public void testShortPassword() {
        // Simulate button click
        when(mEmail.getText().toString()).thenReturn("test@example.com");
        when(mPassword.getText().toString()).thenReturn("123"); // Short password

        mainActivity.mLogin.performClick();

        // Verify that error is set on password EditText
        verify(mPassword).setError("Password length must be at least 6 characters.");
    }

    // Add more test cases for other scenarios like incorrect email format, etc.
}
