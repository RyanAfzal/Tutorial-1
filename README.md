Ryandhika Al Afzal/ 2206081502/ A

<details>
<summary>Tutorial 1</summary>

Reflection 1
Menurut saya coding saya masih belum baik, tetapi setidaknya saya sudah lebih baik daripada saat masih di kelas DDP 2. Saat ini code saya sudah sedikit menerapkan prinsip clean code, setelah mengerjakan exercise 1 ini saya sedikit kesulitan karena belum terbiasa dengan syntax java springboot.Contoh clean code yang sudah saya terapkan adalah:
1. Menuliskan nama variable dan nama function dengan jelas
2. Comment dapat saya buat se minimal mungkin dengan cara membuat code yang lebih jelas untuk dibaca

Error yang saya temui adalah Whitelabel Error Page, solusi : membuat nama file sama persis dengan yang ada di controller sebelumnya saya menulis nama file html CreateProduct sementara di controller adalah createProduct di mana seharusnya file html juga huruf c pertama tidak kapital begitu juga untuk file html productList dan memperbaiki typo nama variable di file html

Reflection 2
1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?
   setelah menulis unit test saya merasa awalnya unit test ini merepotkan, tetapi jika project yang dikerjakan besar unit test dapat membuat saya lebih tenang karena mengetahui hampir seluruh kemungkinan terjadi bug atau error tidak akan terjadi. Menurut saya jumlah unit test tidak ada batas minimal atau maksimal harus berapa tapi minimmal dapat membuat unit test untuk setiap function dan class beserta untuk skenario berhasil dan gagal. Untuk cara memastikan unit test dapat memverifikasi code program kita adalah semua fitur terutama pada function sudah dibuat unit-test nya beserta kemungkinan berhasil dan gagal serta minimal 80% dari program sudah di test. Menurut saya 100% code coverage belum menjamin code tidak memiliki bug atau error masih ada banyak kemungkinan dari skenario berhasil dan gagal yang belum di test.

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
   What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!
   Untuk pertanyaan ini saya belum dapat menjawabnya karena saya belum sepenuhnya selesai membuat Functional Test.
</details>

<details>
<summary>Tutorial 2</summary>

Reflection

1. Code qualitiy issue yang saya alami di antaranya :
   - masalah permission denied pada gradlew di dockerfile, solusi saya adalah menggunakan perintah chmod +x gradlew
   - jacoco tidak muncul pada build report, solusi dengan run test jacocoTestReport tetapi test yang fail saya hapus terlebih dahulu
   - memperbaiki isu sonarcloud dengan memastikan properti yang ada pada sonar sudah sesuai dengan yang ada di sonarcloud, mengubah port yang sebelumnya 8000 menjadi 8080
2. Menurut saya implementasi saya sudah menerapkan ci/cd karena github akan melakukan test dan code scanning otomatis jika ada push atau pull dengan ada nya workflows ci dan scorecard dan implementasi saat ini juga dapat deploy dan redeploy otomatis dengan platform koyeb jika ada push atau pull dari branch main.
</details>

<details>
<summary>Tutorial 3</summary>

1. Prinsip yang saya terapkan adalah
   - SRP, yaitu setiap class hanya memiliki 1 tanggung jawab. Pada tutorial ini saya terapkan dengan :
      - memindahkan set id dari yang sebelumnya ada pada class Car ke class CarRepository, agar class car hanya memiliki 1 tanggung jawab yaitu sebagai model dan CarRepository juga tetap hanya memiliki 1 tanggung jawab sebagai pengatur object Car yang dibuat
      - memisahkan CarController dengan ProductController agar CarController hanya memiliki 1 tanggung jawab sebagai controller untuk Car dan ProductController hanya memiliki 1 tanggung jawab sebagai controller untuk Product
      - CarController tidak lagi extend ProductController
   - OCP, yaitu class open untuk digunakan dan diekstensi, tetapi close untuk modifikasi, yang saya terapkan adalah :
      - yang saya gunakan pada CarController adalah interface dari CarService bukan implementasi agar implementasinya tetap close untuk modifikasi
   - Dependency Inversion, yaitu membuat class ketergantungannya pada suatu abstraksi bukan dengan class lain, yang saya terapkan adalah :
      - dengan menghapus public modifier pada method di interface Car Service dan Product Service sehingga mencegah class lain dependent dengan interface tersebut
   - Selain prinsip solid saya juga menerapkan clean code dengan menghapus comment yang tidak diperlukan dan membuat code lebih readable
   - Pada tutorial ini belum menerapkan LSP karena  belum ada suatu class yang di extend dari class lain
   - Sudah menerapkan interface segregation karena interface sudah dibagi sesuai dengan fungsinya
   
2. Manfaat solid principle pada project saya adalah code sudah lebih rapi sehingga lebih mudah untuk di maintain hingga selesai tutorial, low coupling sehingga jika ada perubahan yang dilakukan di kemudian hari tidak harus merubah class atau function yang lain, scalable dari awal semester yang sederhana hingga semakin kompleks ke depannya, dan adaptable. Contoh kasus adalah dengan SRP jika ada error pada ProductController maka saya dapat langsung tau harus memperbaiki ProductController dan kemungkinan besar tidak perlu mengubah controller yang lain.

3. Tanpa menerapkan solid principle code saya akan berantakan dan sulit dibaca sehingga pada tutorial berikutnya dapat menyulitkan saya jika ada perubahan atau tambahan bahkan saya dapat lupa apa maksud dari code saya, jika dependency tinggi atau high coupling dapat menyulitkan karena jika salah satu class atau function diubah maka harus mengubah class atau function lain yang bersangkutan jika tidak dapat membuat code berjalan tidak sesuai yang diinginkan, code saya menjadi sulit dimaintain dan tidak adaptable, dan tidak scalable untuk dilanjutkan pada tutorial berikutnya. Contoh kasus adalah jika ada error pada CarController, tetapi tidak menerapkan solid artinya tanpa srp semua function bersatu dan saya akan bingung untuk memperbaiki error di mana, dan jika sudah ketemu karena ada dependency kemungkinan harus memperbaiki semua class atau function yang saling bergantungan.
</details>