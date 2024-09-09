package com.app.azkarapp

import android.app.*
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.navigation.NavigationView
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.chrono.HijrahDate
import java.time.format.DateTimeFormatter
import java.util.*

var counter :Int = 0
lateinit var mDrawerLayout: DrawerLayout
lateinit var actionBarDrawerToggle :ActionBarDrawerToggle
lateinit var vNV :NavigationView
lateinit var dateHijri : TextView
lateinit var Month : TextView
private lateinit var adView : AdView


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        // Initialize Mobile Ads SDK
        MobileAds.initialize(this)
        // Load Banner Ad
        adView = findViewById(R.id.adView)
        // Create an ad request.
        val adRequest = AdRequest.Builder().build()
        // Start loading the ad in the background.
        adView.loadAd(adRequest)

        mDrawerLayout = findViewById(R.id.drawerlayout)
       vNV = findViewById(R.id.vNV)
       dateHijri = findViewById(R.id.dateHijri)
        Month = findViewById(R.id.Month)
       val toolbar = findViewById(R.id.toolbar) as Toolbar

         // using toolbar as ActionBar
        setSupportActionBar(toolbar)
        createNotificationChannel()
        TestTimeToDisplayNotificationNight()

        //Calender Hijri
        val hijrahDate: HijrahDate = HijrahDate.now()
       // val NormalDate: LocalDate.from(hijrahDate)
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
      //or =>  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
        val formatted: String = formatter.format(hijrahDate)
        dateHijri.setText(formatted)
        //Month Name
        val Month1 : DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM")
        Month.setText("|" +"\t"+ Month1.format(hijrahDate).toString())
        //Calender Hijri


        // TestTimeToDisplayNotificationMorning()
        actionBarDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.nav_open, R.string.nav_close)
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        // to make the Navigation drawer icon always appear on the action bar
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)
        NavClick()
    }
    private fun NavClick() {
        vNV.setNavigationItemSelectedListener { item ->
             when (item.getItemId()) {
                 R.id.nav_Mas_developer -> sendEmail()
                 R.id.nav_Share -> shareapp()
                 R.id.nav_about -> {
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                 }

            }
            mDrawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
    override fun onBackPressed() {
      //  val currFrag: Fragment? = supportFragmentManager.findFragmentById(R.id.layFL)
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    protected fun shareapp(){
        // Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
        val sharingIntent = Intent(Intent.ACTION_SEND)
        // type of the content to be shared
        sharingIntent.type = "text/plain"
        // Body of the content
        val shareBody = "من فضلك حمل هذا التطبيق وشاركه لتعم الفائدة "
        // subject of the content. you can share anything
        val shareSubject = "https://play.google.com/store/apps/"
        // passing body of the content
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

        // passing subject of the content
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject+packageName)
        startActivity(Intent.createChooser(sharingIntent, "Share using"))

    }

    protected fun sendEmail() {
        val mailIntent = Intent(Intent.ACTION_VIEW)
        val data =
            Uri.parse("mailto:?subject=" + "تقديم اقتراح | مراسلة المطور" + "&to=" + "samoasma80@gmail.com")
        mailIntent.data = data
        startActivity(Intent.createChooser(mailIntent, "Send mail..."))
    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = " أذكار اليوم"
            val desc = "تذكير بقراءة الاذكار"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            //class NotificationChannel
            val channel = NotificationChannel("notifylemubit" , name , importance)
            channel.description = desc
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun TestTimeToDisplayNotificationNight(){


       // Log.d("Calendar" , Calendar.getInstance().toString())
       // Log.d("Calendar" , Calendar.getInstance().after(calendar).toString())

       // if(Calendar.getInstance().after(calendar))
        //{ calendar.add(Calendar.DAY_OF_MONTH,1) }

        val intent = Intent(this , MyReceiver::class.java)

//        Log.d("Calendar" , "Hii")
        val pendingIntent = PendingIntent.getBroadcast(applicationContext , 0 , intent, PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY ,17)
        calendar.set(Calendar.MINUTE , 11)
        calendar.set(Calendar.SECOND , 1)

        var startUpTime = calendar.timeInMillis

//        // تحويل الميللي ثانية إلى كائن LocalDateTime
//        val dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(startUpTime), ZoneId.systemDefault())
//        // تنسيق التاريخ والوقت
//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//        val formattedDate = dateTime.format(formatter)
//
        val dateTime1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault())

        // تنسيق التاريخ والوقت
       var  formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
       var  formattedDate2 = dateTime1.format(formatter1)

        Log.d("Calendar","2=   " +formattedDate2)

        if (System.currentTimeMillis() > startUpTime) {
            Log.d("Calendar","true")
            Log.d("Calendar","1  " +startUpTime.toString())
            Log.d("Calendar","2   " +System.currentTimeMillis().toString())

            startUpTime = startUpTime + 24 * 60 * 60 * 1000
           Toast.makeText(this, " hg استعفر الله", Toast.LENGTH_SHORT).show()



        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP , startUpTime,pendingIntent)
//            val snackbar =
//                Snackbar.make(mDrawerLayout, "This is Simple Snackbar", Snackbar.LENGTH_LONG)
//            snackbar.show()


        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,startUpTime,AlarmManager.INTERVAL_DAY, pendingIntent)



       // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.timeInMillis,AlarmManager.INTERVAL_DAY  ,pendingIntent)
      // if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
    // alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP , calendar.timeInMillis,pendingIntent)
     //  }


    }




    fun onClickM( view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار الصباح")
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onClickN(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار المساء")
        startActivity(intent)
    }

    fun onClickP(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار الصلاة")
        startActivity(intent)
    }

    fun onClickP_after(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار بعد الصلاة")
        startActivity(intent)
    }

    fun onClick_Call_to_prayer(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار الأذان")
        startActivity(intent)
    }

    fun onClick_Ablution(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار الوضوء")
        startActivity(intent)
    }

    fun onClick_WakeUp(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار الاستيقاظ")
        startActivity(intent)
    }

    fun onClick_Sleep(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار النوم")
        startActivity(intent)
    }

    fun onClick_toiletRoom(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار الخلاء")
        startActivity(intent)
    }

    fun onClick_Food(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار الطعام")
        startActivity(intent)
    }

    fun onClick_Hajj(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "دعاء ختم القرآن")
        startActivity(intent)
    }

    fun onClick_ziker(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "تسابيح")
        startActivity(intent)
    }

    fun onClick_Duas(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أدعية الأنبياء")
        startActivity(intent)
    }

    fun onClick_Duas_Quran(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أدعية قرآنية")
        startActivity(intent)
    }

    fun onClick_Allziker(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أذكار متفرقة")
        startActivity(intent)
    }

    fun onClick_R(view: View) {
        val intent = Intent(this, MorningActivity::class.java)
        intent.putExtra("Option Name", "أدعية النبي")
        startActivity(intent)
    }





}


