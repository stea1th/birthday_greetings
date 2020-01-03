$(function () {

    getAll();

});

function getPersonName(id) {
    var url = "/api/greetings/person?id=" + id;
    $.get(url).done(function (data) {
        $('#person-name').text(data.firstName);
    })
}

function getAll() {
    var url = "/api/greetings/";
    $.get(url).done(function (data) {
        for (var i = 0; i < data.length; i++) {
            var person = data[i];
            var row = "<tr>" +
                // "<th>" + person.id + "</th>" +
                "<th>" + person.firstName + "</th>" +
                "<th>" + person.lastName + "</th>" +
                "<th>" + person.dateOfBirth + "</th>" +
                "<th>" + person.email + "</th>" +
                "<th>" + person.autoEmailGreetings + "</th>" +
                "</tr>";
            $("tbody").append(row);
        }
    });

}
