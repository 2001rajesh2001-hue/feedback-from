function doPost(e) {

  try {

    var sheet = SpreadsheetApp.getActiveSpreadsheet()
      .getSheetByName("Sheet1");

    var data = JSON.parse(e.postData.contents);

    var locationLink =
      "https://www.google.com/maps?q=" +
      data.latitude + "," + data.longitude;

    sheet.appendRow([
      new Date(),
      data.name,
      data.countryCode,
      data.mobile,
      data.rating,
      data.comments,
      locationLink
    ]);

    return ContentService.createTextOutput("Success");

  } catch(err) {

    return ContentService.createTextOutput("Error: " + err);

  }
}