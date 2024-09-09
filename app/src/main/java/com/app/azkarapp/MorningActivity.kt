package com.app.azkarapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class MorningActivity : AppCompatActivity() {
    lateinit var data : ArrayList<Morning_Remembrance_Model>
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        data = ArrayList<Morning_Remembrance_Model>()
        condation()

        // This will pass the ArrayList to our Adapter
        val adapter = Morning_Remembrance_Adapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter



    }


    fun condation() {

        val intent = getIntent().getStringExtra("Option Name")

        if(intent == "أذكار الصباح")
        //  Log.d("M" ,R.string.ziker_1.toString())
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_1), "مرة واحدة" , resources.getString(R.string.ziker_1_1)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_2), "ثلاث مرات" , resources.getString(R.string.ziker_2_2)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_3), "ثلاث مرات" , resources.getString(R.string.ziker_2_2)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_4), "ثلاث مرات" , resources.getString(R.string.ziker_2_2)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_5), " مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_6), "مرة واحدة" , resources.getString(R.string.ziker_6_6)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_7), "ثلاث مرات" , resources.getString(R.string.ziker_7_7)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_8), "أربع مرات" , resources.getString(R.string.ziker_8_8)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_9), "مرة واحدة" , resources.getString(R.string.ziker_9_9)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_10), "سبع مرات" , resources.getString(R.string.ziker_10_10)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_11), "ثلاث مرات" , resources.getString(R.string.ziker_11_11)))

        }
        else if(intent == "أذكار المساء")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_1), "مرة واحدة" , resources.getString(R.string.ziker_1_1)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_2), "ثلاث مرات" , resources.getString(R.string.ziker_2_2)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_3), "ثلاث مرات" , resources.getString(R.string.ziker_2_2)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_4), "ثلاث مرات" , resources.getString(R.string.ziker_2_2)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_5), " مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_6), "مرة واحدة" , resources.getString(R.string.ziker_6_6)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_7), "ثلاث مرات" , resources.getString(R.string.ziker_7_7)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_8), "أربع مرات" , resources.getString(R.string.ziker_8_8)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_9), "مرة واحدة" , resources.getString(R.string.ziker_9_9)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_10), "سبع مرات" , resources.getString(R.string.ziker_10_10)))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.ziker_11), "ثلاث مرات" , resources.getString(R.string.ziker_11_11)))

        }
        else if(intent == "أذكار بعد الصلاة")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_1), "مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_2), "مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_3), "مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_4), "ثلاثة و ثلاثين" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_5), " مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_6), "مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_7), "سبع مرات" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_8), "مرة واحدة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.AP_ziker_9), "عشر مرات" , resources.getString(R.string.AP_ziker_9_9)))

        }

        else if(intent == "أذكار الصلاة")
        {   data.add(Morning_Remembrance_Model("<font color=#64CCC5>أدعيةالاستفتاح</font>"+"<br/>"+resources.getString(R.string.P_ziker_1)+"<br/>"+resources.getString(R.string.P_ziker_1_1), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>أدعيةالركوع</font>"+"<br/>"+resources.getString(R.string.P_ziker_2)+"<br/>"+resources.getString(R.string.P_ziker_2_2)+"<br/>"+resources.getString(R.string.P_ziker_2__2), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>أدعية الرفع من الركوع</font>"+"<br/>"+resources.getString(R.string.P_ziker_3)+"<br/>"+resources.getString(R.string.P_ziker_3_3)+"<br/>"+resources.getString(R.string.P_ziker_3__3), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>أدعية السجود</font>"+"<br/>"+resources.getString(R.string.P_ziker_4)+"<br/>"+resources.getString(R.string.P_ziker_4_4)+"<br/>"+resources.getString(R.string.P_ziker_4__4), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>أدعية الجلوس بين السجدتين</font>"+"<br/>"+resources.getString(R.string.P_ziker_5)+"<br/>"+resources.getString(R.string.P_ziker_5_5), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>التشهد الأول</font>"+"<br/>"+resources.getString(R.string.P_ziker_6), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>التشهد الأخير</font>"+"<br/>"+resources.getString(R.string.P_ziker_7), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>أدعية بعد التشهد الأخير وقبل السلام</font>"+"<br/>"+resources.getString(R.string.P_ziker_8)+"<br/>"+resources.getString(R.string.P_ziker_8_8)+"<br/>"+resources.getString(R.string.P_ziker_8__8), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء القنوت</font>"+"<br/>"+resources.getString(R.string.P_ziker_9)+"<br/>"+resources.getString(R.string.P_ziker_9_9), "دعاء القنوت يكون في الركعة الأخيرة من صلاة الوتر بعد الركوع " ,""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء سجود التلاوة</font>"+"<br/>"+resources.getString(R.string.P_ziker_10)+"<br/>"+resources.getString(R.string.P_ziker_10_10), "" , ""))

        }
        else if(intent == "أذكار الأذان")
        {   data.add(Morning_Remembrance_Model("<font color=#64CCC5>ما يقال عند سماع الأذان</font>"+"<br/>"+resources.getString(R.string.C_ziker_1), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.C_ziker_2), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.C_ziker_3), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>ما يقال بعد سماع الأذان</font>"+"<br/>"+resources.getString(R.string.C_ziker_4), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>ما يقال بين الأذان والإقامة</font>"+"<br/>"+resources.getString(R.string.C_ziker_5), "" , ""))

        }

        else if(intent == "أذكار الوضوء")
        {   data.add(Morning_Remembrance_Model("<font color=#64CCC5>الذكر قبل الوضوء</font>"+"<br/>"+resources.getString(R.string.A_ziker), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>الذكر بعد الوضوء</font>"+"<br/>"+resources.getString(R.string.A_ziker_2)+"<br/>"+resources.getString(R.string.A_ziker_2_2)+"<br/>"+resources.getString(R.string.A_ziker_2__2), "" , ""))

        }


        else if(intent == "أذكار الاستيقاظ")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.W_ziker_1), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.W_ziker_2), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.W_ziker_3), "" , ""))

        }

        else if(intent == "أذكار النوم")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.S_ziker_1), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.S_ziker_2), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.S_ziker_3)+"<br/>"+resources.getString(R.string.S_ziker_4)+"<br/>", "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.S_ziker_5), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.S_ziker_6), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.S_ziker_7), "ثلاثة و ثلاثين" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.S_ziker_8), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>سورة البقرة: أَعُوذُ بِاللهِ مِنْ الشَّيْطَانِ الرَّجِيمِ</font>"+"<br/>"+resources.getString(R.string.S_ziker_9), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>آية الكرسى: أَعُوذُ بِاللهِ مِنْ الشَّيْطَانِ الرَّجِيمِ</font>"+"<br/>"+resources.getString(R.string.S_ziker_10), "" , ""))

        }

        else if (intent == "أذكار الخلاء")
        {
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>الذكر عند الخلاء</font>"+"<br/>"+resources.getString(R.string.TR_ziker), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>الذكر بعد الخروج من الخلاء</font>"+"<br/>"+resources.getString(R.string.TR_ziker_2), "" , ""))

        }
        else if (intent == "أذكار الطعام")
        {
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>الذكر عند الطعام والشراب</font>"+"<br/>"+resources.getString(R.string.F_ziker)+"<br/>"+"<font color=#64CCC5>فإنْ نسي في أَوَّلِهِ، فَليَقُلْ:</font>"+resources.getString(R.string.F_ziker_2), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>الذكر عند الفراغ من الطعام والشراب</font>"+"<br/>"+resources.getString(R.string.F_ziker_2)+ "<br/>"+resources.getString(R.string.F_ziker_2_), "غُفِرَ لَهُ مَا تَقَدَّمَ مِنْ ذَنْبِهِ." , ""))

        }

        else if(intent == "أدعية الأنبياء")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_1), "آدم علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_2)+"<br/>"+"<br/>"+(resources.getString(R.string.D_ziker_2_2))+"<br/>"+(resources.getString(R.string.D_ziker_2_)), "نوح علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_3)+"<br/>"+"<br/>"+resources.getString(R.string.D_ziker_3_3)+"<br/>"+"<br/>"+resources.getString(R.string.D_ziker_3_)+"<br/>"+"<br/>"+resources.getString(R.string.D_ziker_3__)+"<br/>", "إبراهيم علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_4)+"<br/>"+resources.getString(R.string.D_ziker_4_)+"<br/>", "لوط علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_5), "يوسف علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_6)+"<br/>"+"<br/>"+resources.getString(R.string.D_ziker_6_)+"<br/>"+"<br/>"+resources.getString(R.string.D_ziker_6__), "موسى علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_7), "أيوب علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_8), "سليمان علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_9), "يونس علية السلام." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_10)+"<br/>"+"<br/>"+resources.getString(R.string.D_ziker_10_), "زكريا علية السلام" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.D_ziker_11), "يعقوب علية السلام." , ""))

        }

        else if(intent == "أدعية قرآنية")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_1), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_2), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_3), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_4), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_5), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_6), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_7), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_8), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_9), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_10), "" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Q_ziker_11), "" , ""))

        }
        else if(intent == "تسابيح")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_1), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_2), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_3), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_4), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_5), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_6), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_7), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_8), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_9), "100 مرة" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.Z_ziker_10), "100 مرة" , ""))

        }

        else if(intent == "أذكار متفرقة")

        {  data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعـاء من استصعب عليه أمر</font>"+"<br/>"+resources.getString(R.string.AL_ziker_1), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>كفارة المجلس</font>"+"<br/>"+resources.getString(R.string.AL_ziker_2), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء لبس الثوب</font>"+"<br/>"+resources.getString(R.string.AL_ziker_3), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء لبس الثوب الجديد</font>"+"<br/>"+resources.getString(R.string.AL_ziker_4), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء الكرب</font>"+"<br/>"+resources.getString(R.string.AL_ziker_5), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء الهم والحزن</font>"+"<br/>"+resources.getString(R.string.AL_ziker_6), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء قضاء الدين</font>"+"<br/>"+resources.getString(R.string.AL_ziker_7), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء الريح</font>"+"<br/>"+resources.getString(R.string.AL_ziker_8), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء الرعـد</font>"+"<br/>"+resources.getString(R.string.AL_ziker_9), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء نزول االمطر</font>"+"<br/>"+resources.getString(R.string.AL_ziker_10), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء ركوب الدابة أو ما يقوم مقامها</font>"+"<br/>"+resources.getString(R.string.AL_ziker_11), "" ,""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء السفر</font>"+"<br/>"+resources.getString(R.string.AL_ziker_12), "" , ""))
            data.add(Morning_Remembrance_Model("<font color=#64CCC5>دعاء المسافر للمقيم</font>"+"<br/>"+resources.getString(R.string.AL_ziker_12), "" , ""))

        }

        else if(intent == "أدعية النبي")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_1), "رواه البخاري (6306) عن شداد بن أوس وقد وصف النبي هذا الدعاء بأنه سيد الاستغفار." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_2), "رواه البخاري (834) ومسلم (6869) عن أبي بكر." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_3), "رواه البخاري (6398) ومسلم " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_4), "رواه مسلم" , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_5), "رواه مسلم (6889) عن أبي هريرة.  " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_6), "رواه مسلم (6895) عن عائشة." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_7), "رواه مسلم (6903) عن أبي هريرة. " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_8), "رواه مسلم (6904) عن ابن مسعود. " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_9), "رواه مسلم (6943) عن ابن عمر. " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_10), "رواه مسلم (6750) عن عبد الله بن عمرو " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_11), "رواه مسلم (1090) عن عائشة." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_12), "رواه البخاري (6347) ومسلم (6877) عن أبي هريرة." , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_13), "رواه البخاري (6316) ومسلم (1797) عن ابن عباس. " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_14), "رواه ابن ماجه (3846) بإسناد صحيح عن عائشة. " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_15), "رواه النَّسائي (1305) بإسناد حسن عن عمار بن ياسر ",""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_16), "رواه أبو داود (5074) وغيره بإسناد صحيح عن ابن عمر. " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_17), "رواه الترمذي (3392) وغيره بإسناد صحيح عن أبي هريرة. " , ""))
            data.add(Morning_Remembrance_Model(resources.getString(R.string.R_ziker_18), " رواه أبو داود (5090) بإسناد حسن عن أبي بكرة." , ""))

        }

        else if(intent == "دعاء ختم القرآن")
        {   data.add(Morning_Remembrance_Model(resources.getString(R.string.D_Kuran), "" , ""))
        }
        }
}
