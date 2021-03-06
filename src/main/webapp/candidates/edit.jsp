<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/scripts/validate.js"> </script>
    <script>
       function loadCity() {
               $.ajax({
                   type: 'GET',
                   url:  'http://localhost:8080/dreamjob/city',
                   dataType: 'json'
               }).done(function(data) {
                   $.each(data.cities, function(index, value) {
                       $('#city').append('<option value="'+ value.id +'">' + value.name + '</option>')
                   });
                   $('#city').val(new URLSearchParams(window.location.search).get("idCity"));
               }).fail(function(err){
                   alert(err);
               });
        }
    </script>
    <title>Кандидаты</title>
</head>
<body onload="loadCity()">
<%
    String id = request.getParameter("id");
    Candidate can = new Candidate(0, "");
    if (id != null) {
        can = PsqlStore.instOf().findCandidateById(Integer.valueOf(id));
    }

%>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новый кандидат
                <% } else { %>
                Редактирование кандидата
                <% } %>
            </div>
            <div class="card-body">
                <form onsubmit="return validate([$('nPost')])" action="<%=request.getContextPath()%>/candidates.do?id=<%=can.getId()%>" method="post">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="nPost">Имя</label>
                                <input type="text" class="form-control" id="nPost" name="name" value="<%=can.getName()%>">
                            </div>
                            <div class="col-md-6">
                                <label for="city">Город</label>
                                <select class="form-control" id="city" name="city">
                                    <option disabled>Выберите город</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
