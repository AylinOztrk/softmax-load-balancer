📌 Proje Amacı

Bu projede istemci taraflı bir yük dengeleme (load balancing) sistemi geliştirilmiştir. Amaç, birden fazla sunucu arasında gelen istekleri dağıtarak ortalama gecikmeyi (latency) minimize etmektir.
Problem, öğrenmeye dayalı bir karar verme süreci olarak ele alınmış ve Multi-Armed Bandit yaklaşımı ile modellenmiştir.

🧠 Kullanılan Yaklaşım

Projede Softmax Action Selection algoritması kullanılmıştır.
Bu yöntem, iki önemli kavram arasında denge kurar:
Exploration (Keşif): Farklı sunucuları denemek
Exploitation (Sömürü): En iyi performans gösteren sunucuyu daha sık seçmek

Softmax algoritması, her sunucuya geçmiş performansına göre bir olasılık atar ve seçimleri bu olasılıklara göre yapar. Böylece sistem zamanla daha iyi sunucuları öğrenir.

🔄 Öğrenme Mekanizması

Her istek sonrasında seçilen sunucunun performansı gözlemlenir ve o sunucuya ait tahmini değer güncellenir.
Projede constant step-size (sabit öğrenme oranı) yöntemi kullanılmıştır. Bu tercih özellikle non-stationary (zamanla değişen) ortamlarda daha başarılı sonuç verir.

🖥️ Proje Mimarisi:
Kod yapısı modüler olarak tasarlanmıştır:
environment → Sunucu modeli
balancer → Yük dengeleme algoritmaları
simulation → Simülasyon ve sonuç hesaplama
Main → Programın çalıştırıldığı sınıf

Bu yapı sayesinde algoritmalar kolayca değiştirilebilir ve sistem genişletilebilir.

⚙️ Karşılaştırılan Yöntemler

Softmax Load Balancer
Round Robin
Random Selection

📊 Sonuç

Simülasyon sonuçları göstermiştir ki:
Softmax yöntemi, değişken (non-stationary) ortamda en düşük ortalama gecikmeyi sağlamıştır.
Round Robin sabit ve dengeli bir performans göstermiştir.
Random seçim en yüksek performans dalgalanmasına sahiptir.


Bu sonuçlar, öğrenmeye dayalı yöntemlerin dinamik sistemlerde daha etkili olduğunu göstermektedir.

	​

