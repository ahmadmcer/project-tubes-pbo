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
    
3. Mengelola Class

4. Inheritance

5. Overloading & Overriding

6. Polymorphisme
