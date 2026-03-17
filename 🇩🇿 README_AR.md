إدارة المعلمين 👨‍🏫




مشروع جامعي — رخصة MIT
نظام إدارة كامل للمعلمين للمؤسسات التعليمية.

📋 فهرس المحتويات

نظرة عامة

الميزات

التقنيات

التثبيت

الاستخدام

هيكل المشروع

المساهمات

الرخصة

التواصل

🎯 نظرة عامة

GestionEnseignants هو تطبيق مكتبي يهدف لتسهيل إدارة معلومات المعلمين، الجداول، الدروس، والمهام الإدارية في المؤسسات التعليمية. تم تطويره كمشروع أكاديمي للسنة الثانية (L2)، ويعرض تطبيق عملي لمبادئ البرمجة الكائنية وإدارة قواعد البيانات.

✨ الميزات
الميزات الأساسية

👤 إدارة ملفات المعلمين – إضافة، تعديل، حذف وعرض التفاصيل

📚 تعيين الدروس – تخصيص الدروس للمعلمين وإدارة الجداول

📅 إدارة الجداول الزمنية – إنشاء وإدارة مواعيد الحصص

🔍 بحث وفلترة – إمكانية البحث المتقدم للوصول السريع للبيانات

📊 التقارير – إنشاء تقارير حول عبء المعلمين وتوزيع الدروس

ميزات إدارية

🔐 تسجيل دخول آمن – نظام دخول مع صلاحيات حسب الدور

📝 تصدير البيانات – تصدير إلى PDF وExcel

🗄️ قاعدة بيانات – دعم MySQL/PostgreSQL للتخزين المستمر

🛠️ التقنيات
الفئة	التقنية
اللغة	Java 17+
واجهة المستخدم	JavaFX / Swing
قاعدة البيانات	MySQL / PostgreSQL
أداة البناء	Maven / Gradle
IDE	IntelliJ IDEA / Eclipse
التحكم بالإصدارات	Git & GitHub
🚀 التثبيت
المتطلبات

JDK 17 أو أعلى

MySQL 8.0+ أو PostgreSQL 13+

Maven 3.8+ أو Gradle 7+

الخطوات

استنساخ المستودع

git clone https://github.com/N1N0u/GestionEnseignants.git
cd GestionEnseignants

إعداد قاعدة البيانات

إنشاء قاعدة باسم gestion_enseignants

تعديل بيانات الاتصال في src/main/resources/config.properties

db.url=jdbc:mysql://localhost:3306/gestion_enseignants
db.username=your_username
db.password=your_password

بناء المشروع

# باستخدام Maven
mvn clean install
# باستخدام Gradle
gradle build

تشغيل التطبيق

# باستخدام Maven
mvn javafx:run
# أو تشغيل JAR مباشرة
java -jar target/GestionEnseignants-1.0.jar
💻 الاستخدام

أول تشغيل

تشغيل التطبيق

تسجيل الدخول بالبيانات الافتراضية:

Username: admin
Password: admin123

تغيير كلمة المرور مباشرة للحماية

إدارة المعلمين

الذهاب إلى Enseignants → Ajouter

تعبئة المعلومات الشخصية والمهنية

رفع صورة الملف الشخصي (اختياري)

الحفظ في قاعدة البيانات

تعيين الدروس

اختيار المعلم من القائمة

الضغط على Assigner cours

اختيار القسم والدورة

تحديد الجدول والزمن

تأكيد التعيين

📁 هيكل المشروع
GestionEnseignants/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/gestion/enseignants/
│   │   │   │   ├── controllers/
│   │   │   │   ├── models/
│   │   │   │   ├── dao/
│   │   │   │   ├── services/
│   │   │   │   ├── utils/
│   │   │   │   └── Main.java
│   │   └── resources/
│   │       ├── fxml/
│   │       ├── css/
│   │       ├── images/
│   │       └── config.properties
│   └── test/
├── docs/
├── database/
│   ├── schema.sql
│   └── seed_data.sql
├── README.md
├── LICENSE
└── pom.xml / build.gradle
🤝 المساهمات

المساهمات مرحب بها!

عمل Fork للمستودع

إنشاء فرع جديد: git checkout -b feature/AmazingFeature

عمل Commit للتغييرات: git commit -m 'Add some AmazingFeature'

رفع الفرع: git push origin feature/AmazingFeature

فتح Pull Request

إرشادات التطوير

اتباع تسميات Java

كتابة اختبارات للوحدات الجديدة

تحديث الوثائق

التأكد من عدم وجود تحذيرات أثناء التجميع

📄 الرخصة

مرخص تحت MIT — راجع ملف LICENSE

📞 التواصل

المؤلف: ALIAT Atef GitHub: @N1N0u رابط المشروع: https://github.com/N1N0u/GestionEnseignants
