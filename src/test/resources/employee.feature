Feature: Uji metode CRUD dalam sampel pengujian REST API Karyawan
  Scenario: Menambahkan data Karyawan
    Given Mengatur api karyawan dengan metode POST
    When Mengirim permintaan HTTP POST
    Then Menerima Respon metode POST yang valid
    And Menerima kode respons HTTP POST yang valid yaitu 201

  Scenario: Mengubah data Karyawan
    Given Mengatur api karyawan dengan metode PUT
    When Mengirim permintaan HTTP PUT
    Then Menerima Respon metode PUT yang valid
    And Menerima kode respons HTTP PUT yang valid yaitu 200

  Scenario: Mendapatkan data Karyawan
    Given Mengatur api karyawan dengan metode GET
    When Mengirim permintaan HTTP GET
    Then Menerima kode respons HTTP GET yang valid yaitu 200

  Scenario: Menghapus data Karyawan
    Given Mengatur api karyawan dengan metode DELETE
    When Mengirim permintaan HTTP DELETE
    Then Menerima kode respons HTTP DELETE yang valid yaitu 200