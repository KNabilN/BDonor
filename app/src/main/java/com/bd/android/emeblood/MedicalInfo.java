package com.bd.android.emeblood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bd.android.emeblood.NotificationsPack.Notifications;

import java.util.ArrayList;

public class MedicalInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Notifications> notifications = new ArrayList<Notifications>();
        notifications.add(new Notifications("أولاً : الموانع المؤقتة ", "\n" +
                "·التبرع بالدم خلال الشهرين السابقين.\n" +
                "\n" +
                "·الصيام.\n" +
                "\n" +
                "·حالات الإصابة فى حادث (يؤجل لمدة عام).\n" +
                "\n" +
                "·إجراء عملية كبرى (يؤجل لمدة عام).\n" +
                "\n" +
                "·إجراء نقل دم (يؤجل لمدة عام).\n" +
                "\n" +
                "·خلع ضرس (يؤجل لمدة عام).\n" +
                "\n" +
                "·إجراء عملية صغرى (يؤجل لمدة 6 شهور).\n" +
                "\n" +
                "·علاج بالإبر الصينية (يؤجل لمدة 6 شهور).\n" +
                "\n" +
                "·علاج أسنان \"تنظيف وحشو\" (يؤجل لمدة 6 شهور).\n" +
                "\n" +
                "·إجراء وشم (يؤجل لمدة 6 شهور).\n" +
                "\n" +
                "·ثقب للأذن (يؤجل لمدة 6 شهور).\n" +
                "\n" +
                "·إلتهاب رئوى أو شعبى (بعد تمام الشفاء).\n" +
                "\n" +
                "·أنيميا نقص الحديد (بعد تمام الشفاء).\n" +
                "\n" +
                "·إلتهاب الكلى والمسالك البولية (بعد تمام الشفاء).\n" +
                "\n" +
                "·المخالطة لحالة إلتهاب كبدى (يؤجل لمدة عام من تاريخ المخالطة).\n" +
                "\n" +
                "·تضخم فى الغد الليمفاوية (يؤجل لحين التشخيص والعلاج).\n" +
                "\n" +
                "·الملاريا (يؤجل لمدة عام بعد التأكد من الشفاء).\n" +
                "\n" +
                "(فى حالة زيارة المتبرع لمنطقة يتوطن فيها المرض) يؤجل لمدة ثلاثة أسابيع بعد العودة.\n" +
                "\n" +
                "·التطعيم\n" +
                "\n" +
                "\n" +
                "بعض التطعيمات تستدعي التاجيل لفترة تتراوح بين اسبوعين و سنة \n" +
                "\n" +
                "·الحمل والرضاعة (يؤجل لمدة عام بعد الولادة).\n" +
                "\n" +
                "·الدورة الشهرية (لا داعى للتأجيل الإ فى حالة زيادة الطمث).\n" +
                "\n" +
                "vالادوية :\n" +
                "\n" +
                "·أسبرين (يؤجل لمدة 3 أيام إذا كان التبرع بصفائح دموية \"وتوضع علامة على وحدة الدم الكامل فى حالة التبرع قبل ذلك حتى لا يفصل منه صفائح دموية\").\n" +
                "\n" +
                "·مضادات حيوية أو كورتيزون (يؤجل لحين انتهاء العلاج). \n"));
        notifications.add(new Notifications(
                "ثانياً : الموانع الدائمة", "\n" +
                "·الأمراض الصدرية المزمنة.\n" +
                "\n" +
                "·جميع أنواع الأنيميا عدا أنيميا نقص الحديد.\n" +
                "\n" +
                "·أمراض الدم الأخرى بأنواعها.\n" +
                "\n" +
                "·مرض السكر.\n" +
                "\n" +
                "·أمراض القلب والحمى الروماتيزمية.\n" +
                "\n" +
                "·حالات تضخم الكبد.\n" +
                "\n" +
                "·البلهارسيا.\n" +
                "\n" +
                "·الصفراء (الإلتهاب الكبدى).\n" +
                "\n" +
                "·حالات الفشل الكلوى.\n" +
                "\n" +
                "·حالات التشنجات والصرع والإغماء المتكرر.\n" +
                "\n" +
                "·أمراض تناسلية (إيدز – زهرى – سيلان).\n" +
                "\n" +
                "·زيادة أو نقص إفرازات الغدة الدرقية.\n" +
                "\n" +
                "·الأمراض السرطانية.\n" +
                "\n" +
                "·الأمراض النفسية.\n" +
                "\t\n"));

        ListView listView = findViewById(R.id.list);

        NotificationAdabter itemsAdapter = new NotificationAdabter(this, notifications);
        listView.setAdapter(itemsAdapter);
    }
}
