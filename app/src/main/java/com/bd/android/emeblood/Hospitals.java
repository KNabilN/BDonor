package com.bd.android.emeblood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bd.android.emeblood.NotificationsPack.Notifications;

import java.util.ArrayList;

public class Hospitals extends AppCompatActivity {
//    TextView ty ;
//    TextView th;
//    TextView gm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Notifications> notifications = new ArrayList<Notifications>();
        notifications.add(new Notifications("1. تجديد الدم","من المعلوم أن كرات الدم الحمراء (أهم مكونات الدم، والتي تنقل الأكسجين إلى خلايا الجسم كافة ) تتجدد تقريبًا كل 4 أشهر، حيث يتم التخلص من القديم عبر الطحال وبعض الأنسجة اللميفاوية، وضخ الجديد الذي تنتجه مصانع الدم في نخاع العظام الموجود في قلب عظامنا المحورية في الظهر والصدر.. إلخ.\n" +
                "\n" +
                "يخزن الجسم حوالي 500 مل من الدم الجديد كاحتياطي استراتيجي في الطحال بالأساس، وذلك لضخه في حالة الفقد المفاجئ للدم كما في حالة النزيف .. الخ. عندما تتبرع بالدم، يقوم الطحال فورًا بضخ الاحتياطي لتعويض ما فقده الجسم، ويتم تجديد الاحتياطي من الدم الجديد في الأيام التالية. وهذا هو سر جعل التبرع الدوري كل 4 أشهر."));

   notifications.add(new Notifications("2. تقليل احتمالات الإصابة بالعديد من السرطانات","أظهرت نتائج  إحدى الدراسات منذ 10 سنوات، انخفاض معدلات الإصابة ببعض السرطانات الهامة لدى من يقومون بالتبرع الدوري بالدم، خاصة سرطانات الكبد والمريء والمعدة والقولون والرئة. والتفسير الذي رجَّحتْه الدراسة لذلك هو أن التبرع الدوري بالدم يحافظ دائمًا على الحديد في معدلاته الطبيعية، دون أي زيادة قد تسبب تضرر الأنسجة، وزيادة قابليتها للنمو السرطاني."));
        notifications.add(new Notifications("3. تقليل احتمالات حدوث جلطات القلب","أظهرت إحدى الدراسات أن التبرع بالدم لمرة واحدة في العام على الأقل، يقلل فرص الإصابة بجلطات القلب، والنوبات القلبية عمومًا، بنسبة تزيد على 80%. قدمت الدراسة عدة تفسيرات لهذه الملاحظة الهامة، من أهمها أيضًا قصة الحديد. حيث يؤدي التبرع بالدم إلى دفع الجسم لتنشيط عملية تصنيع الدم الجديد لتعويض ما تم فقده، ولتعويض الاحتياطي الاستراتيجي للجسم، وبالطبع يتم استهلاك أي حديد زائد في هذه العملية، مما يحافظ على معدلات الحديد في الدم، وفي الأنسجة، في المتوسطات الطبيعية المفيدة. وقد أظهرت دراسات سابقة وجود ارتباط بين معدلات زيادة الحديد في القلب والشرايين التاجية، وحدوث تصلب الشرايين، الذي يسبب ضيقها، ويزيد فرص حدوث الجلطات داخلها.\n" +
                "\n" +
                "كذلك يحسن التبرع الدوري بالدم من جودة مكونات الدم، وزيادة نسبة الخلايا الشابة حديثة التصنيع، ذات الكفاءة الأكبر في نقل الأكسجين، مما يحسن التغذية الدموية للقلب، ويقلل ولو بشكل طفيف فرص تعرضه للنوبات القلبية. كذلك يحافظ التبرع الدوري بالدم على نسبة الهيموجلوبين في الدم في المعدل الطبيعي، وقد كشفت الدراسة وجود علاقة بين زيادة نسبة الهيموجلوبين، وزيادة تأثير الكوليسترول الضار LDL على شرايين القلب، وهذا الأخير هو المسئول عن حدوث تصلب الشرايين."));
        notifications.add(new Notifications("4. حالات مرضية علاجها التبرع بالدم","بعض اختلالات الدم مثل الزيادة غير الطبيعية في كمية كرات الدم الحمراء، أحد أهم علاجاتها هو التبرع بالدم بشكل مستمر، على فواصل زمنية أقصر بكثير من مدة الـ4 أشهر المعتادة لدى المتبرعين الأصحاء. دون التبرع المستمر بالدم، يتعرض هؤلاء المرضى لمضاعفات خطيرة مثل جلطات الدم نتيجة زيادة لزوجة الدم، والارتفاع الشديد في ضغط الدم، وارتفاع البوتاسيوم في الدم والذي قد يسبب اضطرابات كهربية خطيرة في القلب .. الخ.\n" +
                "\n" +
                "وحالة مرضية خطيرة أخرى تحتاج للتبرع المستمر، هي الزيادة المرضية في كمية الحديد في الدم. الحديد من أهم مكونات الدم، لكن في وجود بعض الاختلالات الجينية، يزداد امتصاصه من الطعام بشكل كبير يفوق حاجة الجسم منه، مما يؤدي إلى ترسبه في الأعضاء الحيوية وتلفها، وأشهرها القلب والمفاصل والخصيتيْن والبنكرياس."));
        notifications.add(new Notifications("5. الحفاظ على سلامة الكبد","الكبد من أهم أعضاء الجسم الحيوية، فهو ينتج العديد من البروتينات الهامة مثل الألبيومين الذي يحافظ على السوائل في الدم، ويمنع التورم، ومثل مضادات التجلط التي تمنع النزيف، وكذلك هو المصفاة الرئيسية بالجسم للتخلص من السموم. يساهم التبرع الدوري بالدم في الحفاظ على الكبد من خلال الحفاظ على معدلات الحديد الطبيعية كما فصَّلنا في النقاط السابقة."));
        notifications.add(new Notifications("6. تقليل عوامل الأكسدة ومحفزات الالتهاب","هناك بعض المواد الضارة تنتج من بعض التفاعلات داخل خلايا وأنسجة الجسم، وتسمى بعوامل الأكسدة. ظهرت وفرة من الأبحاث التي تتحدث عن تلك المواد، وعند دورها في تحفيز حدوث بعض الأمراض الخطيرة مثل السرطانات، والجلطات، وفشل الأجهزة الحيوية، لكن لم تصل أغلب تلك  الدراسات لنتائج قاطعة في هذا الصدد. لكن عمومًا أظهرت دراسة عام 2016م أن التبرع الدوري بالدم يساهم في تقليل نسب تلك المواد الضارة في الدم والجسم."));
        notifications.add(new Notifications("7. فوائد نفسية هامة","عندما يقوم المرء بعمل نبيل يخدم به الآخرين، كأن يتبرع المرء بدمه، للمساهمة في إنقاذ قريب أو حتى غريب في حاجة ماسة، فهذا يؤدي إلى شعور كبير بالإنجاز، وتحسن الحالة المزاجية، والإحساس بالذات، ويقلل من الطاقة السلبية، ومن جلد الذات. ليس هذا كلامًا إنشائيًا، إنما تدعمه نتائج بعض الدراسات."));
        notifications.add(new Notifications("8. تحاليل حيوية مجانية","يمثل التبرع بالدم فرصة للاطمئنان الدوري بخصوص الإصابة ببعض الأمراض الخطيرة التي تنتقل بالدم مثل فيروسات الإيدز والفيروسات الكبدية بي وسي، ومرض الزهري .. الخ، حيث يتم إجراء هذه التحاليل إجباريًا على دماء كل متبرع في كل مرة تبرع. كذلك يقوم المشرفون على عملية التبرع إلزاميًا بالاطمئنان على ضغط دم المتبرع، ونبض القلب، ونسبة الهيموجلوبين بالدم، وكذلك الوزن (لا يسمح بالتبرع لشديدي النحافة) مما يسهم في الكشف المبكر عن ارتفاع الضغط والأنيميا .. إلخ."));
        notifications.add(new Notifications("9. مساهمة طفيفة في إنقاص الوزن","تؤدي كل مرة تبرع بالدم إلى فقد حوالي 650 كيلو سعر. وهذا يمثل حوالي ثلث الاحتياج اليومي المتوازن من السعرات للإنسان البالغ متوسط الوزن. بالطبع على المدى البعيد يبدو هذا مساهمة رمزية للغاية، وهي بالفعل كذلك. لكن عند تمكن ثقافة التبرع الدوري من الشخص، فإنها ستساعده في الحفاظ على الحمية الغذائية المتوازنة، إذ سيحرص دائمًا على البقاء بصحة جيدة، وتجنب الإصابة بالأنيميا، وذلك ليتمكن من التبرع في أي وقت. ولن يتمكن الشخص من هذا إلا بالإكثار من الأطعمة المفيدة كالفواكه والخضروات والأسماك، والألبان قليلة الدسم، والبروتينات النباتية كالبقوليات، والبروتينات الحيوانية قليلة الدهون، وكل هذا سيساعد في حميته بشكل جيد."));
        notifications.add(new Notifications("10. فوائد عظمى بثمن قليل للغاية","ذا عُرضَ عليك أن تشارك في تجارة مكسبها مضاعف ومضمون، باحتمالية خسارة، ومشكلات أقل من 1%، هل تفوت مثل هذه الفرصة؟ كذلك هو التبرع بالدم. أما المخاطر، فتكاد تكون منعدمة طالما تم الالتزام بالقواعد الصحية السليمة من استخدام الإبر والمحاقن لمرة واحدة فقط، وتعقيم مكان الدخول الوريدي، وأن يتم الدخول بواسطة طبيب أو ممرض متمرس، وكل هذا يسهل توافره في أغلب المشافي.\n" +
                "\n" +
                "لو لم يكن للتبرع بالدم، وانتشار ثقافته لدى معظم الجمهور من فائدة سوى أن يجد أي منا أكياس الدم متوافرة عندما يحتاجها في حالة طارئة – وهذا للأسف احتمال غير بعيد عن أي منا، وعن أحبابنا – لكان هذا يكفي. لكن بالفعل فوائد الأمر تتخطى هذا."));
        ListView listView = findViewById(R.id.list);

        NotificationAdabter itemsAdapter = new NotificationAdabter(this, notifications);
        listView.setAdapter(itemsAdapter);
    }
}