function getShortUrl(longUrl) {
    console.log("Long Url: " + longUrl);
    $.get("/generate?longUrl=" + longUrl)
    .done(function(data) {
        var shortUrl = data["shortUrl"];
        $("#success-message").attr("href", shortUrl);
        $("#success-message").html(shortUrl);
        $("#success-row").removeClass("invisible");
        console.log("Get request completed successfully!");
    })
    .fail(function(data) {
        console.log("Unable to create a short url");
        console.log(data);
    });
}

$(document).ready(function() {
    console.log("Ready");
    $("#generate-button").on('click', function(x) {
        var longUrl = $("#longurl-input").val()
        if (!longUrl) {
            alert("Long Url cannot be empty!");
            return;
        }
        getShortUrl(longUrl)
    });
});




