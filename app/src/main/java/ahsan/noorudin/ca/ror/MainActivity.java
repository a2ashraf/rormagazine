package ahsan.noorudin.ca.ror;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.geniusforapp.fancydialog.FancyAlertDialog;

public class MainActivity extends AppCompatActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //check if user has playstand installed.  if not, throw dialog:
        // -> Please install Google NewsStand and relaunch this application, OK -> goes to google news stand intent.
        //if installed, launch below.

//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.google.android.apps.magazines")));
        
        
        if (isNewsStandInstalled()) {
            launchNewsStand();
        } else {
            launchDialogToInstallNewsStand();
        }
        
        
    }
    
    private void launchDialogToInstallNewsStand() {
        FancyAlertDialog.Builder alert = new FancyAlertDialog.Builder(MainActivity.this)
                .setImageDrawable(getResources().getDrawable(R.drawable.newsstanda))
                .setTextTitle("GOOGLE NEWS STAND NOT FOUND")
                .setTextSubTitle("PLEASE INSTALL IT!")
                .setBody("After clicking continue, please install Newsstand from the Play store. Then Close the Google Play store, close this app and relaunch this app")
                .setPositiveButtonText("Continue")
                .setOnPositiveClicked(new FancyAlertDialog.OnPositiveClicked() {
                    @Override
                    public void OnClick(View view, Dialog dialog) {
                        String appPackageName = "com.google.android.apps.magazines";
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }finally {
                            finish();
                        }
                    }
                })
                       /* .setAutoHide(true)*/
                .build();
        alert.show();
        launchGooglePlay();
    }
    
    private void launchGooglePlay() {
    }
    
    private boolean isNewsStandInstalled() {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo("com.google.android.apps.magazines", PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            
        }
        
        return false;
    }
    
    
    private void launchNewsStand() {
        
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://newsstand.google.com/publications/CAAqBwgKMKKZ9AowhJDVAg"));
        startActivity(browserIntent);
        
    }

//
//                String inputString = "";
//                int talley = 0;
//
//                HashMap<String, Integer> hashmap=new HashMap<String, Integer>();
//                hashmap.put("0",6);
//                hashmap.put("1",2);
//                hashmap.put("2",5);
//                hashmap.put("3",5);
//                hashmap.put("4",4);
//                hashmap.put("5",5);
//                hashmap.put("6",6);
//                hashmap.put("7",4);
//                hashmap.put("8",7);
//                hashmap.put("9",6);
//                //get input from args, check for null/empty.
////                if(args.length == 0){
////                    System.out.println("No arguments");
////                    inputString="12134";
////                }else
////                    inputString=args[0];
//
//        inputString="12134";
//                //with input, for each character, look up associated value in map and add to a running talley.
//                for(int i=0;i<inputString.length();i++){
//                    int val = hashmap.get( inputString.charAt(i) +"");
//                    talley+=val;
//                }
//                System.out.println(talley);
//                //print out talley.


//        //String input = "DD MM YYYY";
//        String strDate = "1 1 1986";
//        String output = "7 1 1986";
//
//       String[] inputArray= strDate.split(" ");
//
//        int day =Integer.parseInt(inputArray[0]);
//        int month = Integer.parseInt(inputArray[1]);
//        int year = Integer.parseInt(inputArray[2]);
//
//        if(day-1 == 0){
//            //strDate =    handlemonthEnd(day,month,year);
//            month = month-1;
//            if(month % 2 == 0){
//                //even month therefore sed date to 31
//                day = 31;
//            }else
//                day  = 30;
//
//
//        }
//
//        if(month ==0){
//            year = year -1 ;
//            month = 12;
//            day = 31;
//        }
//
//        String previousDay = day-1 + " " + month + " " + year;
//        System.out.println("Current day:" +strDate );
//        System.out.println("previous day: " +previousDay );
//
    
}


//decrease year, choose end of month date (30/31) based on if month is odd or not.
//    public String handleyearEnd(String date) {
//
//        System.out.print("here");
//    }


//        finish();
//    }
 