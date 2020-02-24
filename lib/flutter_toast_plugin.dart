import 'dart:async';

import 'package:flutter/services.dart';

class FlutterToastPlugin {
  static const MethodChannel _channel =
      const MethodChannel('flutter_toast_plugin');

//  static Future<String> get platformVersion async {
//    final String version = await _channel.invokeMethod('getPlatformVersion');
//    return version; showDialog
//  }
  static Future<bool>  showToast(String msg) async {

    return await _channel.invokeMethod('showToast',{"msg":msg});
  }

  static Future<bool>  showDialog(String msg) async {

    return await _channel.invokeMethod('showDialog',{"msg":msg});
  }
}
