#Cara Membuild Aplikasi dari Source Code

Langkah-langkahnya:

1. Persiapkan tools yang dibutuhkan:
  + Eclipse IDE (sudah terinstal plugin Android Development Tools dan Android SDK)
  + Pandoc
  + Tortoise Git, atau aplikasi lainnya
2. Clone repositori menggunakan Tortoise Git dengan memasukkan link https://github.com/cliffordsugijanto/eJuklak.git
3. Gunakan Eclipse untuk meng-import project yang bernama eJuklakApp yang berada dalam folder hasil clone repositori tadi.
4. Setelah import selesai, klik kanan pada project eJuklakApp pada window sebelah kiri di Eclipse, lalu klik 'Properties'.
5. Pada menu navigasi di sebelah kiri pilih Android, lalu pastikan sudah terdapat 'appcompat_v7' dan bertanda centang hijau. Jika masih bertanda silang merah atau belum ada, remove dahulu yang error, lalu klik Add dan pilih 'appcompat_v7' yang sebelumnya telah di-import ke Eclipse.
6. Setelah tidak ada yang error, klik kanan pada nama project lalu pilih 'Run As' > 'Android Application', maka secara otomatis file eJuklakApp.apk akan ter-generate di dalam folder bin.
7. Cara lain untuk membuild aplikasi yaitu dengan lewat menu 'File' > 'Export', lalu pilih 'Android' > 'Export Android Application', pilih project eJuklakApp lalu klik Next.
8. Pada keystore silahkan membuat keystore baru atau pilih keystore yang sudah ada.
9. Klik Finish maka file eJuklakApp.apk berhasil dibuat.
