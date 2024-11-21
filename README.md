# PA_PBO_Kelompok 
## Sistem Antrian BPJS di Rumah Sakit Samarinda

## Anggota Kelompok 7
|          **Nama**          |     **NIM**     |
|----------------------------|-----------------|
| LISA NAFRATHILOYA          | 2309116006      |
| REYFALDHO ALFARAZEL        | 2309116007      |
| ALYA RIZQI RAMADHANI       | 2309116008      |
| HANA ANASTASYA WARDAH      | 2309116012      |
| NELY OKTAVIA REDECA        | 2309116024      |


## 📌 Deskripsi Studi Kasus
**Sistem Informasi Antrian Pasien BPJS** merupakan aplikasi Java yang dirancang untuk mengatasi masalah antrian pasien yang tidak efisien di Rumah Sakit Samarinda. Masalah ini menyebabkan waktu tunggu lama, estimasi waktu pelayanan yang tidak pasti, serta kurangnya informasi real-time. Hal tersebut berdampak negatif pada tingkat kepuasan pasien dan kelancaran operasional rumah sakit. Sistem ini hadir sebagai solusi untuk menyediakan pengelolaan antrian yang lebih terstruktur dan modern.

Mengacu pada Peraturan Presiden No. 12 Tahun 2013 dan penelitian terkait, pelayanan kesehatan yang berkualitas harus berpusat pada kebutuhan pasien. Namun, sistem antrian manual sering memicu penumpukan pasien, memperlambat proses birokrasi, dan meningkatkan risiko kesehatan. Oleh karena itu, aplikasi ini diharapkan dapat mendukung peningkatan kualitas layanan rumah sakit secara keseluruhan.

### Tujuan Pengembangan Aplikasi
**- Meningkatkan Efisiensi Pelayanan:** Mengurangi waktu tunggu pasien dengan pengelolaan antrian yang lebih terorganisir.

**- Menyediakan Estimasi Waktu Pelayanan:** Memberikan informasi real-time terkait estimasi waktu bagi pasien yang menunggu.

**- Mempermudah Pengelolaan Antrian:** Mengoptimalkan proses pendaftaran, pencatatan, dan prioritas pasien secara digital.

**- Meningkatkan Kepuasan Pasien:** Dengan layanan yang cepat, akurat, dan transparan, pasien merasa lebih dihargai.

**- Mengurangi Risiko Kesehatan:** Menghindari penumpukan pasien di area tunggu yang dapat meningkatkan risiko penyebaran penyakit.

### Fitur Utama
**- Manajemen Antrian:** Memungkinkan pengguna untuk menambah, mengubah, dan menghapus data pasien dalam antrian.

**- Sorting Berdasarkan Jenis Penyakit:** Mengatur prioritas pasien berdasarkan tingkat keparahan penyakit.

**- Pencarian Data:** Menyediakan fitur pencarian cepat untuk menemukan informasi pasien.

**- Jadwal Pelayanan:** Memberikan estimasi waktu pelayanan berdasarkan jadwal yang telah diatur.

### Teknologi
**- Java:** Bahasa pemrograman utama yang digunakan untuk pengembangan aplikasi.
  
**- NetBeans IDE:** Lingkungan pengembangan terpadu untuk membangun dan mengelola proyek.
  
**- MySQL:** Sistem manajemen basis data untuk menyimpan informasi pasien dan antrian.

### Struktur Projek
**- src:** Direktori yang berisi source code Java, termasuk paket Controller, Database, Model, dan View.
  
**- dist:** Direktori yang berisi file JAR yang dapat dijalankan serta library pihak ketiga yang dibutuhkan.
  
**- nbproject:** Berisi file konfigurasi proyek yang spesifik untuk NetBeans.
  
**- antrian_pasien.sql:** Skrip SQL yang menyediakan struktur basis data, termasuk tabel dan relasi yang diperlukan untuk aplikasi ini.

### Cara Menjalankan
Untuk menjalankan aplikasi ini, gunakan file JAR yang tersedia di direktori dist. Pastikan semua library yang terdapat di dist/lib telah termasuk dalam classpath aplikasi. Aplikasi ini dirancang untuk meningkatkan efisiensi pengelolaan antrian, kepuasan pasien, dan kualitas pelayanan rumah sakit sesuai dengan standar pelayanan publik.

## 📌 FLOWCHART
Aplikasi Sistem Analis Antrian BPJS. Kelompok kami membuat sebuah alur diagram atau yang dibasa dikenal dengan sebutan flowchart. Flowchart digunakan untuk menjelaskan alur dari sebuah program. Berikut adalah flowchart dari Aplikasi Sistem Analis Antrian BPJS:

![FC Sistem Antrian BPJS-Page-1 drawio](https://github.com/user-attachments/assets/e40b809c-22af-4de0-99c3-440d627dfc6e)

## 📌 USECASE DIAGRAM
Salah satu jenis diagram dalam Unified Modeling Language (UML) yang digunakan untuk menggambarkan interaksi antara pengguna (aktor) dan sistem yang akan dikembangkan. Diagram ini berfokus pada fungsi-fungsi yang disediakan oleh sistem (use case) dan hubungan antara aktor dengan fungsi-fungsi tersebut.

![USE CASE DIAGRAM PA drawio (9)](https://github.com/user-attachments/assets/c5dd28fd-6ee2-4ba6-bcb6-a9c8920cd4a4)

## 📌 ACTIVITY DIAGRAM
Salah satu diagram dalam Unified Modeling Language (UML) yang digunakan untuk menggambarkan alur kerja (workflow) atau proses bisnis dalam sebuah sistem. Diagram ini fokus pada urutan aktivitas yang dilakukan dalam suatu proses, baik secara linier maupun bercabang.

Komponen Utama Activity Diagram:
![activity diagram pbo pa](https://github.com/user-attachments/assets/b7fab713-8751-49ef-8cb0-fed580910a2e)

## 📌 ERD
Rancangan ERD untuk database mencakup struktur tabel, hubungan antar tabel, dan skema penyimpanan data. Database menggunakan MySQL dan menyimpan informasi tentang data pasien, kategori penyakit, data dokter dan juga jadwal pelayanan.

### Logical
![Logical_PAPBOO](https://github.com/user-attachments/assets/26f2a15c-02f5-435c-9b45-c186d385a99f)
### Relational
![Relational_PA PBO](https://github.com/user-attachments/assets/feaf97c5-a173-4999-a85d-71441351ff35)

### Erdish
1.	Setiap satu dan hanya satu data pasien harus dimiliki oleh satu dan hanya satu penyakit, dan setiap satu dan hanya satu penyakit harus memiliki satu dan hanya satu data pasien.
2.	Setiap satu dan hanya satu data pasien harus menerima satu atau banyak antrian, dan setiap satu atau banyak antrian harus diterima oleh satu dan hanya satu data pasien.
3.	Setiap satu dan hanya satu penyakit harus memiliki satu atau banyak jadwal pelayanan, dan setiap satu atau banyak jadwal pelayanan harus dimiliki oleh satu dan hanya satu penyakit.
4.	Setiap satu dan hanya satu antrian harus menjadwalkan satu dan hanya satu jadwal pelayanan, dan setiap satu dan hanya satu jadwal pelayanan harus dijadwalkan oleh satu dan hanya satu antrian.
5.	Setiap satu dan hanya satu jadwal pelayanan harus dihubungkan oleh satu dan hanya satu data dokter, dan setiap satu dan hanya satu data dokter harus menghubungkan satu dan hanya satu jadwal pelayanan.
6.	Setiap satu dan hanya satu data dokter harus diakses oleh satu dan hanya satu user, dan setiap satu dan hanya satu user harus mengakses satu dan hanya satu data dokter.

## OUTPUT
### **a. Role Staff**
1. Login Sebagai Staff

Pada tampilan login, staff harus memasukkan username dan password, lalu memilih peran Staff dari dropdown sebelum menekan tombol LOGIN. Jika data benar, sistem akan memverifikasi dan mengarahkan ke halaman utama sesuai hak akses. Jika belum memiliki akun, pengguna bisa membuatnya dengan mengklik opsi Sign In.
   ![Screenshot 2024-11-21 133849](https://github.com/user-attachments/assets/b02acd4c-9ad3-4bbf-ba7d-06720592c2f0)

   - Login Berhasil
     ![Screenshot 2024-11-21 133947](https://github.com/user-attachments/assets/fab1ad5e-d4d9-40de-be6f-91043f9f87f4)

   - Login Gagal
      ![Screenshot 2024-11-21 134613](https://github.com/user-attachments/assets/81b584e7-dfca-4951-b848-504b4aff41aa)

Saat login, terdapat dua kemungkinan hasil yaitu Login Berhasil dan Login Gagal. Jika username, password, dan role benar, sistem akan menampilkan notifikasi "Login berhasil sebagai Staff" dalam bentuk pop-up. Setelah pengguna mengklik OK, mereka akan diarahkan ke halaman utama sesuai hak akses staff. Sebaliknya, jika ada kesalahan pada username, password, atau role, sistem akan memunculkan pesan "Username, password, atau role salah!" dalam pop-up. Pengguna harus mengklik OK untuk menutup pesan dan mencoba login kembali dengan data yang benar.

2. Tampilan Menu Staff

Setelah berhasil login, Staff akan di tujukan dengan halaman menu Staff. Di Menu staff, pengguna di berikan tampilan beberapa menu staff. Menu tersebut mencakup tentang Informasi Data Pasien, Sorting Penyakit, dan Data Dokter.
    
   ![Screenshot 2024-11-21 134057](https://github.com/user-attachments/assets/5a91d7fb-8d71-40f9-a30d-86de008eb3cf)

3. Data Dokter
   
   Pada menu "Data Dokter", staff dapat mengelola data dokter seperti ID Dokter, Nama Dokter, Spesialisasi, Nomor Telepon, dan Jadwal       Kerja. Setelah data diisi, informasi dokter akan tampil di sistem.
   Staff dapat menambah, memperbarui, atau menghapus data dokter, serta keluar dari menu "Data Dokter" ke halaman sebelumnya. Fitur         ini memastikan data dokter selalu akurat dan mendukung kelancaran pelayanan kesehatan.
   
   - Menampilkan data dokter (read)
     ![image](https://github.com/user-attachments/assets/bb148271-a59e-47e4-ab5e-ca210c1ef062)
     
   - Add data dokter
     
     ![Screenshot 2024-11-21 175239](https://github.com/user-attachments/assets/10509f1d-7e38-46e7-ae3f-cb5f85696bf8)

   - Update data dokter
     
     ![update dokter](https://github.com/user-attachments/assets/8c4f828a-0409-4917-a904-9ef6b515debf)

   - Hapus data Dokter
     
     ![hapus dokter 2](https://github.com/user-attachments/assets/0468852b-99b9-411d-a6da-b7de01d754a1)

5. Data Pasien
   
   Pada menu "Data Dokter", staff dapat mengelola data dokter seperti ID Dokter, Nama Dokter, Spesialisasi, Nomor Telepon, dan Jadwal       Kerja. Setelah data diisi, informasi dokter akan tampil di sistem.
   Staff dapat menampilkan, menambah, memperbarui, atau menghapus data dokter, serta keluar dari menu "Data Dokter" ke halaman              sebelumnya. Fitur ini memastikan data dokter selalu akurat dan mendukung kelancaran pelayanan kesehatan.

   
   - Menampilkan data pasien (read)
     
     ![Screenshot 2024-11-21 172025](https://github.com/user-attachments/assets/095d4c98-46cf-4634-8036-8b9d7ca829ea)

   - Add data pasien
     
     ![Screenshot 2024-11-21 173052](https://github.com/user-attachments/assets/26f2921b-4c0b-48ef-9275-609cb31f9607)

   - Update data pasien
     
     ![Screenshot 2024-11-21 172339](https://github.com/user-attachments/assets/16967f32-fbf6-49e1-ae3e-2fc261e55c7d)

   - Hapus data pasien
     
     ![Screenshot 2024-11-21 172826](https://github.com/user-attachments/assets/454bffc6-f092-4904-9dbc-a6add0273421)

7. Data Antrian
   
   Pada menu "Data Antrian", staff dapat mengelola informasi antrian pasien. Halaman ini menampilkan form dengan kolom yang perlu diisi,    seperti ID Antrian, Waktu Masuk Antrian, Status Antrian, ID Pelayanan, dan ID Pasien. Untuk menambahkan data antrian baru, staff         hanya perlu mengisi seluruh informasi yang diperlukan dan menekan tombol Add. Setelah data berhasil ditambahkan, sistem akan             menampilkan notifikasi yang mengonfirmasi keberhasilan input data.
   
   - Menampilkan data antrian (read)
     ![Screenshot 2024-11-21 174454](https://github.com/user-attachments/assets/148b3923-c6ad-4ecb-a354-a89293e31efa)

   - Add data antrian
     ![Screenshot 2024-11-21 174426](https://github.com/user-attachments/assets/2fff558e-a94a-4675-9c7d-15f5d6398cce)

   - Update data antrian
     ![Screenshot 2024-11-21 174529](https://github.com/user-attachments/assets/d8e33ffe-5a6e-4527-82e8-a176bc7d5fe6)

   - Hapus data antrian
     ![Screenshot 2024-11-21 174630](https://github.com/user-attachments/assets/05a054de-341b-4b98-9357-9086a821b847)

9. Pelayanan

   Pada menu "Pelayanan", staff dapat mengelola data pelayanan pasien seperti ID Pelayanan, Jenis Pelayanan, Waktu Pelayanan, Tanggal       Pelayanan, dan Status Pelayanan. Setelah data diisi, informasi pelayanan akan ditampilkan di sistem.
   Staff dapat menambah, memperbarui, atau menghapus data pelayanan, serta keluar dari menu "Pelayanan" ke halaman sebelumnya. Fitur ini    memastikan data pelayanan tetap akurat dan mendukung kelancaran operasional pelayanan kesehatan.
   
   - Menampilkan pelayanan (read)
     ![Screenshot 2024-11-21 173524](https://github.com/user-attachments/assets/7a1efabe-1bb2-4d17-81a4-83e5eef4dddc)

   - Add pelayanan
     ![Screenshot 2024-11-21 174022](https://github.com/user-attachments/assets/24ddcdc6-98bd-49bf-9ab7-47417de243f0)

   - Update pelayanan
     ![Screenshot 2024-11-21 173748](https://github.com/user-attachments/assets/89e25a0f-e71d-4239-802c-663fefe8fbcd)

   - Hapus pelayanan
     ![Screenshot 2024-11-21 173859](https://github.com/user-attachments/assets/b1a91130-dc6a-4d02-a9ee-39231fcd6a8f)

  ![Screenshot 2024-11-21 173927](https://github.com/user-attachments/assets/39a56c69-4c12-4b34-8558-9f7bdaabaa92)

7. Sorting Berdasarkan Tingkat Urgensi Penyakit
   
   - Berdasarkan penyakit tingkat urgensi "Umum"
     ![Screenshot 2024-11-21 134131](https://github.com/user-attachments/assets/57757a6a-8c66-4521-88cf-103917f49895)

   - Berdasarkan penyakit tingkat urgensi "Sedang"
     ![Screenshot 2024-11-21 134207](https://github.com/user-attachments/assets/e5aec2f8-f42a-4ea0-8bea-29bf75a276b3)

   - Berdasarkan penyakit tingkat urgensi "Gawat Darurat"
     ![Screenshot 2024-11-21 134231](https://github.com/user-attachments/assets/129869cd-3c8f-4410-abdc-67d6ce9f4781)

Dalam menu Sorting Penyakit, staff dapat melihat informasi pasien dan melakukan penyortiran berdasarkan tingkat urgensi yaitu Umum, Sedang, atau Gawat Darurat. Jika memilih Umum, sistem menampilkan data pasien dengan urgensi penyakit umum. Jika memilih Sedang, data disaring untuk urgensi sedang. Jika memilih Gawat Darurat, hanya data pasien dengan urgensi gawat darurat yang ditampilkan.

8. Log Out

Ketika pengguna memilih "Log Out", sistem akan menampilkan pesan konfirmasi "Anda yakin ingin keluar?" dengan opsi "Yes" atau "No". Jika memilih "Yes", sesi akan berakhir dan pengguna diarahkan ke halaman login.

   ![Screenshot 2024-11-21 134327](https://github.com/user-attachments/assets/112c9165-e9f1-484f-af46-b5bff8a17391)

### **b. Role Pasien**
1. Login Sebagai Pasien

Pada tampilan login, pasien memasukkan username dan password, lalu memilih Pasien dari dropdown *Role* sebelum menekan tombol LOGIN. Jika data benar, pasien bisa mengakses sistem sesuai hak akses. Jika belum punya akun, pasien dapat mendaftar dengan mengklik tombol Sign In.

   ![Screenshot 2024-11-21 132634](https://github.com/user-attachments/assets/9eb4209b-6082-40d8-b530-7da9267edb7e)

   - Login Berhasil
     ![Screenshot 2024-11-21 132716](https://github.com/user-attachments/assets/32c0fa69-08ef-48c6-bded-05b16921e4d3)

   - Login Gagal
     ![image](https://github.com/user-attachments/assets/2ed7b33e-12ec-45ba-a99f-50116010b6dc)

Pada proses login untuk Role Pasien, terdapat dua hasil yaitu Login Berhasil dan Login Gagal. Jika data benar, sistem menampilkan pop-up "Login berhasil sebagai Pasien." Setelah mengklik OK, pasien diarahkan ke halaman utama. Jika ada kesalahan, muncul pop-up "Username, password, atau role salah!" dan pasien harus mengklik OK untuk mencoba lagi.

2. Register akun baru

Pada tampilan Register, pengguna yang belum memiliki akun dapat membuat akun baru dengan memasukkan *username* dan *password*, lalu menekan tombol CREATE ACCOUNT. Jika pendaftaran       berhasil, pengguna dapat login dengan akun baru. Tombol Kembali mengarahkan pengguna ke tampilan login jika sudah memiliki akun.
   ![Screenshot 2024-11-21 133650](https://github.com/user-attachments/assets/4159b57c-d3f2-4696-a8b0-2820760ddd9a)

   - Jika akun baru yang dibuat berhasil

Setelah pengguna berhasil membuat akun, sistem akan menampilkan pop-up dengan pesan "Akun berhasil dibuat sebagai Pasien." Pesan ini memberi konfirmasi bahwa proses pendaftaran telah berhasil dan akun baru telah terdaftar sebagai pasien. Pengguna kemudian dapat mengklik tombol OK pada pop-up untuk melanjutkan dan bisa langsung login menggunakan akun yang baru dibuat.
     ![Screenshot 2024-11-21 133729](https://github.com/user-attachments/assets/153bf3f4-f1a5-4899-a15c-fb0b78fa88c8)

3. Tampilan Menu Pasien

Setelah berhasil login, Pasien akan di tujukan dengan halaman menu Pasien. Di Menu pasien, pengguna di berikan tampilan beberapa menu pasien. Menu tersebut mencakup tentang Buat       antrian, Lihat Antrian, dan Jadwal Pelayanan Pasien. 
   ![Screenshot 2024-11-21 132847](https://github.com/user-attachments/assets/4ca4eb71-e4e7-4e46-ab87-32151b6cc6ec)

4. Pendaftaran Pasien
   
   ![Screenshot 2024-11-21 170927](https://github.com/user-attachments/assets/a058e9a5-4cfe-4e54-8fe3-8756ec775a26)

   Pasien berhasil melakukan pendaftaran

   ![Screenshot 2024-11-21 170721](https://github.com/user-attachments/assets/e6744ca3-a630-4c5f-b1da-93322d210b2d)


5. Lihat Antrian
   
   - Berdasarkan ID Pasien
     ![Screenshot 2024-11-21 133135](https://github.com/user-attachments/assets/7f801c5f-bc14-438e-8cc3-1a748385b27f)

   - Berdasarkan Nama Pasien
     ![Screenshot 2024-11-21 133312](https://github.com/user-attachments/assets/6eec58fb-335b-4d89-ae02-8689be10d484)

Pada Menu “Lihat Antrian” Pasien akan di tampilkan dengan melihat data antrian pasien dan di sini pasien dapat melakukan searching data pasien, dengan mencari menggunakan ID pasien atau menggunakan Nama pasien. 

6. Lihat Jadwal Pelayanan

Pada Menu “Jadwal Pelayanan” Pasien akan di tampilakan dengan di perlihatkan menu jadwal pelayanan pada dokter yang tersedia di dalam data. Dan pasien akan di perlihatkan juga jadwal kapan saja kapan dokter melakukan pelayanan apakah penuh, tersedia atau sedang libur.
   ![Screenshot 2024-11-21 133359](https://github.com/user-attachments/assets/1d5d0f29-11d5-44f6-b979-573a87ec7b92)

7. Log Out

Saat pasien memilih opsi “Log Out,” sistem akan menampilkan konfirmasi “Anda yakin ingin keluar?” Pengguna dapat memilih Yes untuk keluar atau No untuk tetap di aplikasi. Jika memilih Yes, sistem akan mengakhiri sesi dengan aman dan mengarahkan pengguna kembali ke halaman login.

   ![Screenshot 2024-11-21 133454](https://github.com/user-attachments/assets/a21a294f-83f1-484d-83f3-65ae4e7a8713)


# PA_PBO_KELOMPOK7
