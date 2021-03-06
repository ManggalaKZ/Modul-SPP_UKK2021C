package com.example.modul_spp_ukk2021.UI.Network;

import com.example.modul_spp_ukk2021.UI.Data.Repository.KelasRepository;
import com.example.modul_spp_ukk2021.UI.Data.Repository.LoginSiswaRepository;
import com.example.modul_spp_ukk2021.UI.Data.Repository.LoginStafRepository;
import com.example.modul_spp_ukk2021.UI.Data.Repository.PembayaranRepository;
import com.example.modul_spp_ukk2021.UI.Data.Repository.PetugasRepository;
import com.example.modul_spp_ukk2021.UI.Data.Repository.SPPRepository;
import com.example.modul_spp_ukk2021.UI.Data.Repository.SiswaRepository;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoints {
    @GET("dbReadSiswa.php")
    Call<SiswaRepository> viewSiswa();
    @GET("dbReadPetugas.php")
    Call<PetugasRepository> viewPetugas();
    @FormUrlEncoded
    @POST("dbLoginSiswa.php")
    Call<LoginSiswaRepository> loginSiswa(
            @Field("nisn") String nisn,
            @Field("password") String password);
    @FormUrlEncoded
    @POST("dbLoginStaffLevel.php")
    Call<LoginStafRepository> loginStaf(
            @Field("username") String username,
            @Field("password") String password);
    @FormUrlEncoded
    @POST("dbReadTagihan.php")
    Call<PembayaranRepository> viewTagihan(
            @Field("nisn") String nisn);

    @FormUrlEncoded
    @POST("dbReadHistory.php")
    Call<PembayaranRepository> viewHistory(
            @Field("nisn") String nisn);

    @FormUrlEncoded
    @POST("dbUpdatePembayaran.php")
    Call<PembayaranRepository> updatePembayaran(
            @Field("id_pembayaran") String id_pembayaran,
            @Field("jumlah_bayar") String jumlah_bayar);

    @FormUrlEncoded
    @POST("dbReadPetugas.php")
    Call<PetugasRepository> viewDataPetugas(
            @Field("username") String username);

    @FormUrlEncoded
    @POST("dbReadSiswa.php")
    Call<SiswaRepository> viewProfile(
            @Field("nisn") String nisn);

    // [PP] Punya Petugas
    // Read
    @GET("dbReadAllSiswa.php")
    Call<SiswaRepository> viewDataSiswa();



    @FormUrlEncoded
    @POST("dbReadPembayaran.php")
    Call<PembayaranRepository> viewPembayaran(
            @Field("nisn") String nisn);

    @FormUrlEncoded
    @POST("dbSearchSiswa.php")
    Call<SiswaRepository> searchDataSiswa(
            @Field("search") String search);

    // Update
    @FormUrlEncoded
    @POST("dbUpdatePembayaran.php")
    Call<PembayaranRepository> updatePembayaran(
            @Field("id_pembayaran") String id_pembayaran,
            @Field("jumlah_bayar") String jumlah_bayar,
            @Field("id_petugas") String id_petugas);


    // [PA] Punya Admin
    // Create
    @FormUrlEncoded
    @POST("dbCreateSiswa.php")
    Call<SiswaRepository> createSiswa(
            @Field("nisn") String nisn,
            @Field("nis") String nis,
            @Field("nama") String nama,
            @Field("id_kelas") String id_kelas,
            @Field("id_spp") Integer id_spp,
            @Field("alamat") String alamat,
            @Field("no_telp") String no_telp,
            @Field("password") String password,
            @Field("id_petugas") String id_petugas);

    @FormUrlEncoded
    @POST("dbCreateKelas.php")
    Call<KelasRepository> createKelas(
            @Field("angkatan") String angkatan,
            @Field("nama_kelas") String nama_kelas,
            @Field("jurusan") String jurusan);

    @FormUrlEncoded
    @POST("dbCreateSPP.php")
    Call<SPPRepository> createSPP(
            @Field("angkatan") String angkatan,
            @Field("tahun") String tahun,
            @Field("nominal") String nominal);

    @FormUrlEncoded
    @POST("dbCreatePetugas.php")
    Call<PetugasRepository> createPetugas(
            @Field("level") String level,
            @Field("username") String username,
            @Field("password") String password,
            @Field("nama_petugas") String nama_petugas);

    @FormUrlEncoded
    @POST("dbReadSiswaKelas.php")
    Call<SiswaRepository> viewDataSiswaKelas(
            @Field("id_kelas") String id_kelas);

    @FormUrlEncoded
    @POST("dbReadSPPAngkatan.php")
    Call<SPPRepository> viewDataSPPAngkatan(
            @Field("angkatan") String angkatan);

    // Read
    @GET("dbReadKelas.php")
    Call<KelasRepository> viewDataKelas();

    @GET("dbReadSPP.php")
    Call<SPPRepository> viewDataSPP();

    @GET("dbReadAllPetugas.php")
    Call<PetugasRepository> viewDataAllPetugas();

    // Update
    @FormUrlEncoded
    @POST("dbUpdateSiswa.php")
    Call<SiswaRepository> updateSiswa(
            @Field("nisn") String nisn,
            @Field("nama") String nama,
            @Field("id_kelas") String id_kelas,
            @Field("id_spp") Integer id_spp,
            @Field("alamat") String alamat,
            @Field("no_telp") String no_telp,
            @Field("password") String password,
            @Field("id_petugas") String id_petugas);

    @FormUrlEncoded
    @POST("dbUpdateKelas.php")
    Call<KelasRepository> updateKelas(
            @Field("id_kelas") String id_kelas,
            @Field("nama_kelas") String nama_kelas,
            @Field("jurusan") String jurusan,
            @Field("angkatan") String angkatan);

    @FormUrlEncoded
    @POST("dbUpdateSPP.php")
    Call<SPPRepository> updateSPP(
            @Field("id_spp") Integer id_spp,
            @Field("nominal") String nominal);

    @FormUrlEncoded
    @POST("dbUpdatePetugas.php")
    Call<PetugasRepository> updatePetugas(
            @Field("id_petugas") String id_petugas,
            @Field("level") String level,
            @Field("username") String username,
            @Field("password") String password,
            @Field("nama_petugas") String nama_petugas);

    // Delete
    @FormUrlEncoded
    @POST("dbDeleteSiswa.php")
    Call<SiswaRepository> deleteSiswa(
            @Field("nisn") String nisn);

    @FormUrlEncoded
    @POST("dbDeleteKelas.php")
    Call<KelasRepository> deleteKelas(
            @Field("id_kelas") String id_kelas);

    @FormUrlEncoded
    @POST("dbDeleteSPP.php")
    Call<SPPRepository> deleteSPP(
            @Field("id_spp") Integer id_spp);

    @FormUrlEncoded
    @POST("dbDeletePetugas.php")
    Call<PetugasRepository> deletePetugas(
            @Field("id_petugas") String id_petugas);
}
