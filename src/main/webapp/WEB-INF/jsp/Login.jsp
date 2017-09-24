<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>Livraria OnLine</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/static/css/bootstrap.css"/>" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/static/css/sigin.css" />" rel="stylesheet" type="text/css">
  </head>

  <body>

    <div class="container">

        <form class="form-signin" action="">
        <h2 class="form-signin-heading">Autenticação de Usuário</h2>
        <label for="inputEmail" class="sr-only">Endereço de Email</label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Endereço de Email" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Senha" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Lembrar de mim
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>

