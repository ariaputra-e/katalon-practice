$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/login.feature");
formatter.feature({
  "name": "",
  "description": "  Login Functionality",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Mengecek apakah semua elemen untuk login telah termuat dengan lengkap ketika aplikasi dibuka",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@LoginInterface"
    }
  ]
});
formatter.step({
  "name": "User membuka aplikasi SFT dari perangkat",
  "keyword": "Given "
});
formatter.match({
  "location": "login.openApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Splashscreen berhasil tertutup",
  "keyword": "When "
});
formatter.match({
  "location": "login.statusAfterStart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User dapat melihat elemen-elemen login seperti text box email dan password serta tombol secara lengkap",
  "keyword": "Then "
});
formatter.match({
  "location": "login.checkElements()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mengecek apakah ketika field email diisi user dapat melanjutkan ke kolom password dengan menekan enter",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@LoginInterface"
    }
  ]
});
formatter.step({
  "name": "User membuka aplikasi SFT dari perangkat",
  "keyword": "Given "
});
formatter.match({
  "location": "login.openApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User mengisi kolom Email kemudian menekan Enter",
  "keyword": "When "
});
formatter.match({
  "location": "login.inputEmail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Kursor akan lanjut ke kolom password",
  "keyword": "Then "
});
formatter.match({
  "location": "login.verifyActivePasswordBox()"
});
formatter.result({
  "status": "passed"
});
});