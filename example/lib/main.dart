import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_toast_plugin/flutter_toast_plugin.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();

  }



  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Column(
            children: <Widget>[
              FlatButton(
                child: Text("show toast"),
                onPressed: (){
                  FlutterToastPlugin.showToast("Hello flutter toast plugin");

                },
              ),FlatButton(
                child: Text("show Dialog"),
                onPressed: (){
                  FlutterToastPlugin.showDialog("Hello flutter Dialog plugin");

                },
              ),
            ],
          )
        ),
      ),
    );
  }
}
