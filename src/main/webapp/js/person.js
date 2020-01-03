var url = "/api/greetings/";

$(function () {

    getAll();

});

function getAll() {
    $.get(url).done(function (data) {
        for (var i = 0; i < data.length; i++) {
            var person = data[i];
            var row = "<tr>" +
                "<th hidden >" + person.id + "</th>" +
                "<th>" + person.firstName + "</th>" +
                "<th>" + person.lastName + "</th>" +
                "<th>" + person.dateOfBirth + "</th>" +
                "<th>" + person.email + "</th>" +
                "<th class='checkbox-class' ><input type='checkbox'" +
                " " + (person.autoEmailGreetings ? "checked" : "") + " onclick='toggleAutoEmailGreetings(" + person.id + ")' ></th>" +
                "</tr>";
            $("tbody").append(row);
        }
    });
}

function toggleAutoEmailGreetings(id) {
    $.ajax({
        url: url + "toggle?id=" + id,
        type: 'PUT'
    });
}
