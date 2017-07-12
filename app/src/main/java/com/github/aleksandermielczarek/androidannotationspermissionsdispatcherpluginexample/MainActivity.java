package com.github.aleksandermielczarek.androidannotationspermissionsdispatcherpluginexample;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by Aleksander Mielczarek on 15.09.2016.
 */
@EActivity(R.layout.activity_main)
@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Click(R.id.permissionButton)
    protected void askForPermission() {
        showCamera();
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    protected void showCamera() {
        Toast.makeText(this, "Permission for camera granted", Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    protected void showRationaleForCamera(PermissionRequest request) {
        Toast.makeText(this, "OnShowRationale for camera", Toast.LENGTH_SHORT).show();
        request.proceed();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    protected void showNeverAskForCamera() {
        Toast.makeText(this, "OnNeverAskAgain for camera", Toast.LENGTH_SHORT).show();
    }

}
