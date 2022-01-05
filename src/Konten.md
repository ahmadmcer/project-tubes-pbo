# TUGAS BESAR PRAKTIKUM PEMROGRAMAN 2 SEMESTER 3
<hr>

### DOSEN PENGAMPU    : `Arif Amrulloh, S.Kom., M.Kom`
### ASISTEN PRAKTIKUM : `Muslimin Dita H`

### TEAM
<!-- diisi repo masing2 -->
#### - [`AALIYAH KHALIF HANDOYO`]()
#### - [`ARIS CAHYADI`]()
#### - [`AHMAD NAWAWI`]()
#### - [`AJIB SYAH ABAD`]()
#### - [`ALIF RIZKI RAMDHANA`]()

## RPG GAME - DRAGON SLAYER 🔥🔥🔥🔥
<hr>

# Sinopsis Game 🎞
# 🗡 ⚔
Seorang player akan berpetualang. Dia memiliki stats Health, Attack, Defense, Experience, dan Level. Senjata utamanya pedang dan pertahanannya perisai.

Dia mulai berjalan. Jika tidak bertemu monster, maka dia bisa melanjutkan perjalanan atau beristirahat. Jika bertemu monster, dia bisa melawannya atau melarikan diri.

Jika dia memilih melarikan diri,  namun dia tetap bisa tertangkap atau berhasil kabur. Jika berhasil kabur, dia bisa melanjutkan perjalanan atau beristirahat.

Jika dia tertangkap, dia harus melawannya. **⚔**

Saat melawan monster, dia bisa menyerangnya atau bertahan. Menyerang  bisa memberikan damage ke monster, tetapi jika monster bertahan maka serangannya berkurang sesuai pertahanan monster.

Dikarenakan sudah menyerang, maka tidak bisa menyerang sampai giliran berikutnya.

Saat bertahan, maka serangan monster akan berkurang sesuai Defense player. Dikarenakan sudah bertahan, maka tidak bisa menyerang sampai giliran berikutanya.

Jika Health monster habis, maka menang. Tapi jika Health player habis, maka kalah.

Saat menang, player mendapat Experience tergantung monster yang dikalahkan. Saat Experience mencapai batas tertentu, player naik level.

Setiap naik level, player bisa menambahkan 1 point stats ke Attack atau Defense.

Setiap monster yang ditemui berdasarkan level player. Jika level player rendah, maka monster yang ditemui berlevel rendah, Jika level player tinggi, maka monster yang ditemui berlevel tinggi.

**🎊  🎉**

<hr>

## Materi Pemrograman OOP yang Relefan Dalam Membuat Game RPG

### Struktur Dasar Dalam Game RPG - DRAGON SLAYER 🔥🔥🔥🔥

**Class Utama**

- Main.class
- Player.class
- Enemy.class

**Mekanisme Game**

- **Gameplay**
    - Walk
    - Resting
    - Run

- **Fight**
    - Attack
    - Defense


- **Experience & Level**
    - Stats


- **Monster**
    - Stats

#### FLOWCHART

#### CLASS DIAGRAM

1. OOP atau Pemrograman Berorientasi Objek
   OOP atau Pemrograman Berorientasi Objek merupakan pemrograman yang berorientasikan kepada objek, yang mana semua data dan fungsi dibungkus dalam class atau object.
   Dalam penggunaan OOP sendiri meliputi `Deklarasi Class`, `Deklarasi Atribut`, `Deklarasi Method` serta `Mengakses Objek`.

    Penerapan Class dalam pemrograman kami yaitu pada bagian 
    ``` java
    Class Main {...}
    Class Player {...}
    Class Enemy {...}
    Class Goblin {...}
    Class Slime {...}
    Class Minotaur {...}
    ```

    Untuk penggunaan Enkapsulai, seluruh class menggunakan akses modifire `public` karena untuk dapat diakses oleh main dengan mudah, jadi menggunakan public.
    ``` java
    public class Player {...}
    ```

    Kemudian penggunakan modifire `private` digunakan dalam deklarasi variable pada Class Player, ini digunakan agar saat dalam pemanggilan dalam class lain tidak ada kesalahan pemanggilan.
    ``` java
    private int health;
    ```

    Kami juga menggunakan modifire `protected` dalam Class Enemy, penggunaan modifire protected dalam class enemy difungsikan agar hanya class turunan enemy yaang dapat menggunakannya, seperti class goblin, slime maupun minotaur.
    ``` java
        protected String name;
    ```

2. Dasar Pemrograman Berorientasi Objek
   
   Dasar pada pemrograman berorientasi objek yaitu diantaranya terdapat :
   
   - Keyword
   
   sebuah identifier yang telah dipesan untuk melakukan pendifinisian sebelumnya oleh java yang digunakan untuk tujuan tertentu.
   
   ```java
   this.health = health;
   this.maxHealth = maxHealth;
   ```
   
   diatas merupakan contoh penerapan keyword, dimana keyword this digunakan untuk melakukan rujukan data.
   
   - Tipe - tipe data dasar
   
   Dalam dasar pemrograman java terdapat 8 tipe dasar yaitu boolean, char, byte, short, int, long, float, dan double, contoh penerapan nya yaitu :
   
   ```java
   int gacha;
   ```
   
   diatas adalah contoh dari penerapan tipe data dasar yaitu integer dimana gunanya adalah untuk melakukan pendeklarasian data dengan bertipe data dasar integer yang hanya dapat menerima data angka.
   
   - Variabel
   
   variabel merupakan sebuah wadah yang digunakan untuk penyimpanan data pada java, contoh penerapan nya yaitu :
   
   ```java
   int code;
   ```
   
   diatas merupakan contoh penerapan variabel dalam java, dimana diatas terjadi pendeklarasian  variabel code dengan bertipe data integer.
   
3. Mengelola Class

   Pada java dalam pengelolaan class terdapat 2 bagian yaitu :
   
   - Package
   
   Package yaitu merupakan sebuah metode enkapsulasi yang digunakan untuk melakukan pengelompokan class, sub package dan interfaces, package ini digunakan selain untuk mealkukan pengelompokan juga digunakan untuk mencegah konflik penamaan terhadap file file, layaknya dalam folder didalam sebuah directory, contoh dari penerapan Package :
   
   ```java
   package com.kelompok.tubes;
   ```
   
   - Import
   
   import digunakan untuk melakukan pemanggilan sehingga, function - function dalam class tersebut dapat diakses biasanya digunakan untuk memanggil sebuah package beserta isinya dan juga dapat digunakan untuk memanggil interface, contoh penerapan dari import yaitu :
   
   ```java
   import java.util.Random;
   import java.util.Scanner;
   ```
   
   - This
   
   This merupakan sebuah kata kunci yang merujuk kepada sebuah object yang berada dalam constructor atau method yang sedang digunakan, this paling sering digunakan untuk umumnya membedakan antara atribut kelas dan parameter yang memiliki nama yang sama, contoh penerapan kata kunci this :
   
   ```java
   this.attack = attack;
   ```
   
4. Inheritance

   Inheritance atau Pewarisan merupakan sebuah konsep Object Oriented Programming, dimana sebuah class yang baru mewarisi atau memiliki metode - metode atau bagian - bagian dari class yang sebelumnya yang sudah ada, Konsep Pewarisan ini dalam penggunaannya menggunakan sistem hirarki atau sistem yang bertingkat dimana apabila submenu tersebut lebih spesifik maka akan semakin spesifik juga isi didalamnya itu juga berlaku dalam konsep pewarisan OOP apabila semakin spesifik subclassnya maka akan semakin sedikit pula bagian - bagian yang dapat diwarisi class tersebut kepada class berikutnya, contoh dari penerapan inheritance :
   
   ```java
   public class Enemy {...}
   ```
   
   ```java
   public class Minotaur extends Enemy{
       public Minotaur(int health, int maxHealth, int attack, int defense, int level) {
           super(health, maxHealth, attack, defense, level);
           this.name = "Minotaur";
       }
   }
   ```
   diatas merupakan contoh inheritance dimana class Enemy merupakan parent class dari Minotaur sedangkan Minotaur merupakan child class dari Enemy.
   
5. Overloading & Overriding

   Pada java terdapar 2 metode yang dapat dilakukan untuk meringkas bagian pemrograman, 2 metode tersebut yaitu overloading dan overriding.
   
   - Overloading
   
   Overloading merupakan sebuah metode yang digunakan untuk memungkinkan banyak metode - metode yang memiliki perbedaan dalam parameter dan hasil return yang berbeda untuk memiliki nama yang sama, dikarenakan oleh itu penggunaan metode Overloading bermanfaat yaitu tidak perlu lagi membuat fungsi - fungsi yang memiliki perbedaan nama namun bertugas sama, syarat yang harus terpenuhi apabila ingin melakukan metode Overloading yaitu :
        
        -  Nama metode harus sama
        -  Daftar Parameter harus berbeda
        -  Return type dapat sama namun juga boleh berbeda;
   
   - Overriding
   
   Overriding merupakan sebuah metode yang digunakan untuk mengimplementasikan sebuah fungsi spesifik di subclass dimana fungsi tersebut berada di superclass, syarat yang harus terpenuhi apabila ingin menggunakan metode Overriding yaitu :
   
        - Nama metode harus sama
        - Daftar Parameter harus sama
        - Return type harus sama 
        
6. Polymorphisme

    Polymorphisme merupakan sebuah konsep dalam Object Oriented Programing (OOP) dimana class-nya memiliki nama yang sama namun bentuk yang berbeda, maksud dari pernyataan diatas yaitu memmiliki nama yang sama namun memiliki perbedaan dari isi, tipe data lalu juga parameter dari method tersebut berbeda dari method yang memiliki nama yang sama dan juga berbeda dari yang lainnya, contoh penerapan polymorphisme yaitu :
    
    ```java
   Enemy enemy;
   gacha = random.nextInt(3);
   switch (gacha) {
       case 0:
       enemy = new Slime(5, 5, 1, 0, 1);
       break;
       case 1:
           enemy = new Goblin(15, 15, 3, 2, 1);
           break;
       case 2:
           enemy = new Minotaur(50, 50, 10, 15, 10);
           break;
       default:
           throw new IllegalStateException("Unexpected value: " + gacha);
   } 
   ```
   
7. Exception
   
   Exception merupakan sebuah kondisi dimana terdapat error dalam sebuah program pada saat dijalankan, kemudian error tersebut dapat di selesaikan menggunakan teknik exception handling. Yang kali ini kami gunakan dalam projeck kami yaitu :
   
   - Try and Catch
   
   Try digunakan untuk menentukan blok kode yang nantinya akan diuji untuk exception pada saat dijalankan atau melakukan pelemparan, sedangkan Catch digunakan untuk menentukan blok kode yang akan dieksekusi apabila terjadi kesalahan dalam blok kode try.
    
                  

   