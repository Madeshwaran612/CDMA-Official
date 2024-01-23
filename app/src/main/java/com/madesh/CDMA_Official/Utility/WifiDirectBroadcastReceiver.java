//package com.maddy.CDMA_Tv.Utility;
//
//import android.Manifest;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.net.wifi.p2p.WifiP2pManager;
//import android.widget.Toast;
//
//import androidx.core.app.ActivityCompat;
//
//import com.maddy.CDMA_Tv.ScoreSheet.HangingMallakhamb;
//
//public class WifiDirectBroadcastReceiver extends BroadcastReceiver {
//
//    private WifiP2pManager mManager;
//    private WifiP2pManager.Channel mChannel;
//    private HangingMallakhamb mActivity;
//
//    public WifiDirectBroadcastReceiver(WifiP2pManager mManager, WifiP2pManager.Channel mChannel, HangingMallakhamb mActivity) {
//        this.mManager = mManager;
//        this.mChannel = mChannel;
//        this.mActivity = mActivity;
//    }
//
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//
//        String action = intent.getAction();
//        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
//            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
//
//            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
//                Toast.makeText(context, "Wifi is On", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(context, "Wifi is Off", Toast.LENGTH_SHORT).show();
//            }
//        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
//            if (mManager != null) {
////                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////                    // TODO: Consider calling
////                    //    ActivityCompat#requestPermissions
////                    // here to request the missing permissions, and then overriding
////                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
////                    //                                          int[] grantResults)
////                    // to handle the case where the user grants the permission. See the documentation
////                    // for ActivityCompat#requestPermissions for more details.
////                    return;
////                }
////                mManager.requestPeers(mChannel, mActivity.peerListListener);
//            }
//        }else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)){
//
//        }else if(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)){
//
//        }
//
//
//    }
//}