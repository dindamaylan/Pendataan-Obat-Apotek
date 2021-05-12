package com.TugasBesar.Kelompok7;

import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main4 {
    //deklarasi global untuk menu sesuai level login
    static Scanner sString = new Scanner(System.in);
    public static String pilih;

    //deklarasi global
    static DecimalFormat kursIndo =(DecimalFormat)DecimalFormat.getCurrencyInstance();
    static DecimalFormatSymbols Rp = new DecimalFormatSymbols();

    //prosedur salam pembuka
    public static void openGreeting() throws IOException {
        System.out.println("=========================================" +
                "=================");
        System.out.println("\tApotek "+owner());
        System.out.println("\t\t\t\t"+ownerInfo());
        System.out.println("----------------------------------------------------------");
        login();
    }

    //fungsi yang berisi nama owner apotek
    public static String owner(){
        return "Institut Teknologi Telkom Purwokerto";
    }

    //fungsi yang berisi informasi owner
    public static String ownerInfo(){
        return "Kelompok 7-SE04A";
    }

    //prosedur salam penutup
    public static void closingGreeting() throws IOException{
        System.out.println("\n----------------------------------------------------------");
        System.out.println("\t\t\tTerima kasih semoga sehat selalu");
        System.out.println("==========================================================\n\n");
        openGreeting();
    }

    //prosedur login
    public static void login() throws IOException{
        //deklarasi filepath
        String filepath = "members.txt";

        //informasi login
        System.out.println();
        System.out.println("\nSilahkah Login !");

        //deklarasi scanner
        Scanner sStr = new Scanner(System.in);

        //inputan pengguna untuk mengisikan username
        System.out.print("\nUsername\t: ");
        String user = sStr.nextLine();

        //inputan pengguna untuk mengisikan password
        System.out.print("Password\t: ");
        String pass = sStr.nextLine();

        //pemanggilan prosedur verifyLogin dengan parameter keluaran variable user, pass, dan filepath
        verifyLogin(user, pass, filepath);
    }

    //prosedur verifikasi login
    private static void verifyLogin(String user, String pass, String filepath) throws IOException{
        //deklarasi scanner untuk koneksi file members
        Scanner x;

        //deklarasi variable dari file members
        String tempUser;
        String tempPass;

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]"); //batasan inputan scanner adalah , dan line baru

            //pengulangan untuk pengecekan, dengan syarat kondisi objek x memiliki element
            while (x.hasNext()){
                tempUser = x.next(); //keyword sebelum karakter koma(,) dimasukan ke dalam variable tersebut
                tempPass = x.next(); //keywird sebelum line baru (\n) dimasukan ke dalam variable tersebut

                //pemilihan bersyarat dengan syaratnya melakukan perbandingan
                if (tempUser.trim().equals(user.trim()) && tempPass.trim().equals(pass.trim())){

                    switch (tempUser){
                        case "admin":
                            System.out.println("\nSelamat Datang Super Admin");
                            PilihanAdmin();
                            break;
                        case "logistik":
                            System.out.println("\nSelamat Datang Admin Warehouse");
                            PilihanLogistik();
                            break;
                        case "user":
                            System.out.println("\nSelamat Datang User");
                            PilihanUser();
                            break;
                    }
                }
            }
            //menutup scanner
            x.close();
        }
        //jika terjadi error
        catch (Exception e){
            System.err.println("\nUsername dan Password Salah !\n");
            login();
        }
    }

    //prodsedur menu untuk admin
    private static void menuPilihanAdmin(){
        System.out.println("\n<===== Menu Super Admin=====>");
        System.out.println("1. Lihat Data obat");
        System.out.println("2. Tambah Obat");
        System.out.println("3. Hapus Obat");
        System.out.println("4. Update Data Obat");
        System.out.println("5. Cari Data Obat");
        System.out.println("---------------------------");
        System.out.println("6. Logout");
        System.out.println("---------------------------");
    }

    //prosedur untuk menanyakan apakah lanjut dengan kembali ke menu atau tidak
    private static void lanjutanMenuAdmin() throws IOException{
        //apakah akan dilanjutkan?
        boolean Lanjutan = getYesorNo("Ingin kembali ke menu ");
        if (Lanjutan)
            PilihanAdmin();
        else
            closingGreeting();
    }

    //prosedur menu yang dipilih admin
    private static void PilihanAdmin() throws IOException {

        menuPilihanAdmin();

        System.out.print("\nMasukan nomor menu yang Anda pilih\t: ");
        pilih = sString.next();
        switch (pilih){
            case "1":
                tampilkanDataObat();
                //apakah akan dilanjutkan?
                lanjutanMenuAdmin();
                break;
            case "2":
                tambahObat();
                //apakah akan dilanjutkan?
                lanjutanMenuAdmin();
                break;
            case "3":
                hapusObat();
                //apakah akan dilanjutkan?
                lanjutanMenuAdmin();
                break;
            case "4":
                updateObat();
                //apakah akan dilanjutkan?
                lanjutanMenuAdmin();
                break;
            case "5":
                cariObat();
                //apakah akan dilanjutkan?
                lanjutanMenuAdmin();
                break;
            case "6":
                System.out.println("\nLogout Berhasil\t!");
                closingGreeting();
                break;
            default:
                System.err.println("Maaf Inputan Anda Salah !\n");
                PilihanAdmin();
        }
    }

    //prosedur menu untuk logistik
    private static void menuPilihanLogistik(){
        System.out.println("\n<===== Menu Admin Logistik=====>");
        System.out.println("1. Tambah Obat");
        System.out.println("2. Update Stock Obat");
        System.out.println("3. Cari Data Obat");
        System.out.println("---------------------------");
        System.out.println("4. Logout");
        System.out.println("---------------------------");
    }

    //prosedur untuk menanyakan apakah lanjut dengan kembali ke menu atau tidak
    private static void lanjutanMenuLogistik() throws IOException{
        //apakah akan dilanjutkan?
        boolean Lanjutan = getYesorNo("Ingin kembali ke menu ");
        if (Lanjutan)
            PilihanLogistik();
        else
            closingGreeting();
    }

    //prosedur menu yang dipilih logistik
    private static void PilihanLogistik() throws IOException {
        menuPilihanLogistik();

        System.out.print("\nMasukan nomor menu yang Anda pilih\t: ");
        pilih = sString.next();
        switch (pilih){
            case "1":
                tambahObat();
                //apakah akan dilanjutkan?
                lanjutanMenuLogistik();
                break;
            case "2":
                updateObatLogistik();
                //apakah akan dilanjutkan?
                lanjutanMenuLogistik();
                break;
            case "3":
                cariObat();
                //apakah akan dilanjutkan?
                lanjutanMenuLogistik();
                break;
            case "4":
                System.out.println("\nLogout Berhasil\t!");
                closingGreeting();
            default:
                System.err.println("Maaf Inputan Anda Salah !\n");
                PilihanLogistik();
        }
    }

    //prosedur untuk menanyakan apakah lanjut dengan kembali ke menu atau tidak
    private static void lanjutanMenuUser() throws IOException{
        //apakah akan dilanjutkan?
        boolean Lanjutan = getYesorNo("Ingin kembali ke menu ");
        if (Lanjutan)
            PilihanUser();
        else
            closingGreeting();
    }

    //prosedur menu untuk user
    private static void menuPilihanUser(){
        System.out.println("\n<===== Menu User =====>");
        System.out.println("1. Cari Data Obat");
        System.out.println("---------------------------");
        System.out.println("2. Logout");
        System.out.println("---------------------------");
    }

    //prosedur menu yang dipilih user
    private static void PilihanUser() throws IOException {

        menuPilihanUser();

        System.out.print("\nMasukan nomor menu yang Anda pilih\t: ");
        pilih = sString.next();
        switch (pilih){
            case "1":
                cariObat();
                //apakah dilanjutkan?
                lanjutanMenuUser();
                break;
            case "2":
                System.out.println("\nLogout Berhasil\t!");
                closingGreeting();
                break;
            default:
                System.err.println("Maaf Inputan Anda Salah !\n");
                PilihanUser();
        }
    }

    //prosedur menampilkan data obat
    private static void tampilkanDataObat() throws IOException {
        //deklarasi
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput =  new BufferedReader(fileInput);

        //informasi tampilan untuk mempermudah membaca data obat
        System.out.println("\n================================= Master Data Obat =================================");
        System.out.println("| NO |\tKode Obat\t|\t   Nama Obat\t\t|\tHarga Obat\t\t\t|\tStok Obat\t|");
        System.out.println("------------------------------------------------------------------------------------");

        //inisiasi data
        String data = bufferInput.readLine();
        int nomorData = 0;

        //jika database kosong
        if (data == null){
            System.out.println("------ Master Data Obat Kosong! Silahkan isikan data terlebih dahulu! -------\n");
            boolean Lanjutan = getYesorNo("Ingin lanjut menambah data");
            if (Lanjutan)
                tambahObat();
            else
                closingGreeting();
        }

        //ketika database tidak kosong lakukan pengulangan
        while (data != null) {
            nomorData++;
            StringTokenizer stringToken = new StringTokenizer(data, ",");
            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%s  \t", stringToken.nextToken());
            System.out.printf("\t|\t%-14s  ", stringToken.nextToken());
            System.out.printf("\t|\t%-14s  ", stringToken.nextToken());
            System.out.printf("\t|\t%s  ", stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

        System.out.println("------------------------------------------------------------------------------------");

        //menutup file reader
        fileInput.close();

        //menutup buffered reader
        bufferInput.close();
    }

    //prosedur menambahkan data obat
    private static void tambahObat() throws IOException {
        System.out.println("\n============================ Tambah Data Obat ===========================");

        FileWriter fileOutput = new FileWriter("database.txt", true);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        Scanner InputObat = new Scanner(System.in);
        String kodeObat, namaObat;
        double hrgObat;
        int jmlObat;

        //deklarasi untuk penampilan format mata uang
        Rp.setCurrencySymbol("Rp. ");
        Rp.setGroupingSeparator('.');
        kursIndo.setDecimalFormatSymbols(Rp);


        System.out.print("Masukkan Kode Obat\t\t: ");
        kodeObat = InputObat.nextLine().toUpperCase();
        System.out.print("Masukkan Nama Obat\t\t: ");
        namaObat = InputObat.nextLine();
        System.out.print("Masukkan Harga Obat\t\t: ");
        hrgObat = InputObat.nextDouble();
        System.out.print("Masukkan Jumlah Obat\t: ");
        jmlObat = InputObat.nextInt();

        //cek data obat di database
        String[] keywords = {namaObat};

        boolean isExist = cekObat_DB(keywords,false);

        //menulis data obat di database
        if(!isExist) {

            System.out.println("\nData yang  akan anda tambahkan adalah");
            System.out.println("-------------------------------");
            System.out.println("Kode Obat     : "+ kodeObat);
            System.out.println("Nama Obat     : "+ namaObat);
            System.out.println("Harga Obat    : "+ kursIndo.format(hrgObat));
            System.out.println("Jumlah Obat   : "+ jmlObat);

            boolean isTambah = getYesorNo("Apakah anda ingin menambah data tersebut");
            if (isTambah){
                bufferedOutput.write(kodeObat+","+namaObat+","+kursIndo.format(hrgObat)+","+jmlObat);
                bufferedOutput.newLine();
                bufferedOutput.flush();

                System.out.println("\nData Obat berhasil ditambahkan !");
            }
            else {
                System.out.println("\nProses Tambah Data Obat dibatalkan!");
            }
        } else {
            System.out.println("\ndata sudah ada di database silahkan hapus/update data terlebih dahulu");
            cekObat_DB(keywords, true);
        }

        bufferedOutput.close();
        fileOutput.close();
    }

    //prosedur menghapus data obat
    private static void hapusObat() throws IOException {
        // mengambil database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // membuat database sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        System.out.println("\n================================= Hapus Data Obat ==================================");

        // menampilkan data
        tampilkanDataObat();

        // user input untuk mendelete data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nMasukan Nomor Urut Obat yang akan dihapus: ");
        int hapusNo = terminalInput.nextInt();

        // looping untuk membaca tiap data baris dan skip data yang akan didelete
        boolean isFound = false;
        int entryCounts = 0;

        String data = bufferedInput.readLine();

        while (data != null) {
            entryCounts++;
            boolean isDelete = false;

            StringTokenizer st = new StringTokenizer(data, ",");

            //tampilkan data yang ingin di hapus
            if (hapusNo == entryCounts) {
                System.out.println("\nData yang ingin anda hapus adalah:");
                System.out.println("-----------------------------------");
                System.out.println("Kode Obat\t: " + st.nextToken());
                System.out.println("Nama Obat\t: " + st.nextToken());
                System.out.println("Harga Obat\t: " + st.nextToken());
                System.out.println("Stock Obat\t: " + st.nextToken());

                isDelete = getYesorNo("Apakah Anda Yakin akan menghapus");
                isFound = true;
            }

            if (isDelete){
                //lewati pemindahan data dari original ke sementara
                System.out.println("\nData berhasil di hapus !");
            }else {
                //pindahkan data dari original ke sementara
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }

        if (!isFound){
            System.err.println("Data Obat tidak ditemukan");
        }

        // menulis data ke file
        bufferedOutput.flush();
        bufferedOutput.close();
        bufferedInput.close();
        fileInput.close();
        fileOutput.close();

        System.gc();
        // delete original file
        database.delete();
        // rename file sementara ke database
        tempDB.renameTo(database);
    }

    //prosedur mengupdate data obat -- admin
    private  static void updateObat() throws IOException {
        System.out.println("\n================================= Update Data Obat =================================");

        // kita ambil database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // kita buat database sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        //deklarasi untuk penampilan format mata uang
        Rp.setCurrencySymbol("Rp. ");
        Rp.setGroupingSeparator('.');
        kursIndo.setDecimalFormatSymbols(Rp);

        // tampilkan data
        String data = bufferedInput.readLine();

        tampilkanDataObat();

        // ambil user Input / pilihan data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukkan nomor data yang akan di update : ");
        int updateNum = terminalInput.nextInt();

        // Tampilkan data yang akan di update
        int entryCount = 0;

        while(data != null) {
            entryCount++;

            StringTokenizer st = new StringTokenizer(data, ",");

            // tampilkan entrycounts == updateNum
            if (updateNum == entryCount){
                System.out.println("\nData yang ingin anda update adalah");
                System.out.println("------------------------------------");
                System.out.println("Kode Obat     : " + st.nextToken());
                System.out.println("Nama Obat     : " + st.nextToken());
                System.out.println("Harga Obat    : " + st.nextToken());
                System.out.println("Jumlah Obat   : " + st.nextToken());

                // mengambil input dari user
                String[] fieldData = {"kode obat","nama obat","harga obat", "jumlah obat"};
                String[] tempData  = new String[4];

                //refresh token
                st = new StringTokenizer(data, ",");

                String originalData;
                for (int i = 0; i < fieldData.length; i++) {
                    boolean isUpdate = getYesorNo("apakah anda ingin mengupdate "+fieldData[i]);
                    originalData = st.nextToken();
                    if (isUpdate) {
                        terminalInput = new Scanner(System.in);
                        System.out.print("Masukkan "+ fieldData[i]+" baru : ");
                        tempData[i] = terminalInput.nextLine();
                    } else {
                        tempData[i] = originalData;
                    }
                }

                // tampilkan data ke layar
                st = new StringTokenizer(data, ",");
                System.out.println("\nData yang baru anda update adalah");
                System.out.println("------------------------------------");
                System.out.println("Kode Obat     : " + st.nextToken() + " --> " + tempData[0]);
                System.out.println("Nama Obat     : " + st.nextToken() + " --> " + tempData[1]);
                System.out.println("Harga Obat    : " + st.nextToken() + " --> " + tempData[2]);
                System.out.println("Jumlah Obat   : " + st.nextToken() + " --> " + tempData[3]);

                boolean isUpdate = getYesorNo("Apakah anda ingin mengupdate data tersebut ");
                if(isUpdate){
                    // cek data obat di database
                    boolean isExist = cekObat_DB(tempData, false);
                    if (isExist) {
                        System.err.println("Data Obat sudah ada di database!!");
                        System.err.println("-----Update data dibatalkan-----");
                        bufferedOutput.write(data);
                    }
                    else {
                        //format data baru kedalam database
                        String kodeObat = tempData[0];
                        String namaObat = tempData[1];
                        String hargaObat = tempData[2];
                        String jumlahObat = tempData[3];
                        double hrg = Double.parseDouble(hargaObat);

                        // tulis ke database
                        bufferedOutput.write(kodeObat+","+namaObat+","+kursIndo.format(hrg)+","+jumlahObat);
                    }
                } else {
                    // copy data
                    bufferedOutput.write(data);
                }
            }
            else {
                // copy data
                bufferedOutput.write(data);
            }

            bufferedOutput.newLine();
            data = bufferedInput.readLine();
        }

        // menulis data ke file
        bufferedOutput.flush();
        // clean up semua stream
        bufferedInput.close();
        bufferedOutput.close();
        fileInput.close();
        fileOutput.close();

        System.gc();
        // delete original file
        database.delete();
        // rename file sementara ke database
        tempDB.renameTo(database);
    }

    //prosedur mengupdate data obat -- logistik
    private  static void updateObatLogistik() throws IOException {
        System.out.println("\n================================= Update Stok Obat =================================");
        // kita ambil database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // kita buat database sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
        tampilkanDataObat();

        // ambil user Input / pilihan data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukkan nomor data yang akan di update : ");
        int updateNum = terminalInput.nextInt();

        // Tampilkan data yang akan di update
        String data = bufferedInput.readLine();
        int entryCount = 0;

        while(data != null) {
            entryCount++;

            StringTokenizer st = new StringTokenizer(data, ",");

            // tampilkan entrycounts == updateNum
            if (updateNum == entryCount){
                System.out.println("\nData yang ingin anda update adalah");
                System.out.println("------------------------------------");
                System.out.println("Kode Obat     : " + st.nextToken());
                System.out.println("Nama Obat     : " + st.nextToken());
                System.out.println("Harga Obat    : " + st.nextToken());
                System.out.println("Jumlah Obat   : " + st.nextToken());


                // mengambil input dari user
                String[] tempData  = new String[1];

                //refresh token
                st = new StringTokenizer(data, ",");
                String originalData; //menampung data sementara

                boolean isUpdatefield = getYesorNo("apakah anda ingin mengupdate jumlah obat ");
                String kodeObat = st.nextToken();
                String namaObat = st.nextToken();
                String hargaObat = st.nextToken();
                originalData = st.nextToken();
                if (isUpdatefield) {
                    terminalInput = new Scanner(System.in);
                    System.out.print("\nMasukkan jumlah obat baru : ");
                    tempData[0] = terminalInput.nextLine();
                } else {
                    tempData[0] = originalData;
                }


                // tampilkan data ke layar
                st = new StringTokenizer(data, ",");
                System.out.println("\nData yang baru anda update adalah");
                System.out.println("------------------------------------");
                System.out.println("Kode Obat     : " + st.nextToken());
                System.out.println("Nama Obat     : " + st.nextToken());
                System.out.println("Harga Obat    : " + st.nextToken());
                System.out.println("Jumlah Obat   : " + st.nextToken() + " --> " + tempData[0]);

                boolean isUpdate = getYesorNo("Apakah anda ingin mengupdate data tersebut ");
                if(isUpdate) {
                    String jumlahObat = tempData[0];

                    // tulis ke database
                    bufferedOutput.write(kodeObat +","+namaObat+","+hargaObat+","+jumlahObat);
                } else {
                    // copy data
                    break;
                }
            }
            else {
                // copy data
                bufferedOutput.write(data);
            }
            bufferedOutput.newLine();
            data = bufferedInput.readLine();
        }
        // menulis data ke file
        bufferedOutput.flush();
        // clean up semua stream
        bufferedInput.close();
        bufferedOutput.close();
        fileInput.close();
        fileOutput.close();

        System.gc();
        // delete original file
        database.delete();
        // rename file sementara ke database
        tempDB.renameTo(database);
    }

    //prosedur cari obat
    private static void cariObat() throws IOException{
        System.out.println("\n===================== Pencarian Data Obat =====================");
        //System.out.println("----------------------------------------------------------------");

        //Membaca database ada atau tidak
        try {
            File file = new File("database.txt");
        } catch (Exception e){
            System.err.println("Database Tidak ditemukan !!");
            return;
        }

        //mengambil data yang ingin dicari
        Scanner terminalinput = new Scanner(System.in);
        System.out.print("\nMasukan kata kunci untuk mencari Obat\t: ");
        String cariString = terminalinput.nextLine();
        String[] keywords = cariString.split("\\s+");

        //cek keyword di database
        cekObat_DB(keywords, true);

        boolean cariLagi = getYesorNo("Ingin cari obat lagi  ");
        if(cariLagi) {
            cariObat();
        }
        else {
            closingGreeting();
        }
    }

    //fungsi mengecek proses pencarian data obat
    private static boolean cekObat_DB(String[] keywords, boolean isDisplay) throws IOException{
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false;
        int nomorData = 0;

        if (isDisplay){
            System.out.println("\n------------------------------------------------------------------------------------");
            System.out.println("\n| NO |\tKode Obat\t|\t   Nama Obat\t\t|\tHarga Obat\t\t\t|\tStok Obat\t|");
            System.out.println("-------------------------------------------------------------------------------------");
        }

        if (data == null){
            //cek jika database kosong
            System.out.println("Data Kosong !");
        }

        while (data != null) {
            // cek keywords didalam baris
            isExist = true;

            for (String keyword : keywords) {
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            //jika keyword cocok maka tampilkan
            if (isExist) {
                if (isDisplay) {
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data, ",");
                    System.out.printf("| %2d ", nomorData);
                    System.out.printf("|\t%s  \t", stringToken.nextToken());        //kode obat
                    System.out.printf("\t|\t%-14s  ", stringToken.nextToken());     //nama obat
                    System.out.printf("\t|\t%-14s  ", stringToken.nextToken());     //harga obat
                    System.out.printf("\t|\t%s  ", stringToken.nextToken());        //satuan
                    System.out.print("\n");
                } else {
                    break;
                }
            }
            data = bufferInput.readLine();
        }

        if (isDisplay){
            System.out.println("-------------------------------------------------------------------------------------");
        }
        bufferInput.close();
        fileInput.close();
        return isExist;
    }

    //fungsi melanjutkan program atau logout
    private static boolean getYesorNo(String message){
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n" + message +" (y/n)? ");
        String pilihanUser = terminalInput.next();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("\nPilihan Anda bukan y atau n");
            System.out.print("\n" + message +" (y/n)? ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");
    }

    public static void main(String[] args) throws IOException{
        openGreeting();
    }
}
