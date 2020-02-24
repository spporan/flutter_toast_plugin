package com.example.flutter_toast_plugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/** FlutterToastPlugin */
public class FlutterToastPlugin implements MethodCallHandler,FlutterPlugin {
  private  Context activity;
  private MethodChannel methodChannel;

  public static void registerWith(Registrar registrar) {
    final FlutterToastPlugin instance = new FlutterToastPlugin();
    instance.onAttachedToEngine(registrar.context(), registrar.messenger());

  }


  @Override
  public void onMethodCall(MethodCall call, Result result) {

    switch (call.method){
      case "showToast":
        String mMessage = call.argument("msg").toString();
        Toast.makeText(activity,mMessage,Toast.LENGTH_LONG).show();
        result.success(true);
        break;
      case "showDialog":
        Intent intent=new Intent(activity,SecondPage.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

//        String message = call.argument("msg").toString();
//        Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
        //result.success(true);

//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setMessage(message);
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//          public void onClick(DialogInterface dialog, int id) {
//            // User clicked OK button
//          }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//          public void onClick(DialogInterface dialog, int id) {
//            // User cancelled the dialog
//          }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
        Dialog dialog=new Dialog(activity);
        dialog.setTitle("Hi, My Name is Flutter");
        dialog.show();
        result.success(true);
        break;
      default:
        result.notImplemented();
        break;
    }

    // use activity here
  }

  @Override
  public void onAttachedToEngine(FlutterPluginBinding binding) {
    onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger());

  }
  private void onAttachedToEngine(Context applicationContext, BinaryMessenger messenger) {
    this.activity = applicationContext;
    methodChannel = new MethodChannel(messenger, "flutter_toast_plugin");
    methodChannel.setMethodCallHandler(this);
  }

  @Override
  public void onDetachedFromEngine(FlutterPluginBinding binding) {
    Log.d("TAG","Detach");
    activity=null;
    methodChannel=null;

  }
}
