
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Livraria OnLine</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/static/css/jumbotron.css" />" rel="stylesheet" type="text/css">
  </head>

    <body>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div class="navbar-brand">Livraria OnLine</div>
            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Usuario</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                                <a class="dropdown-item" href="#">Logout</a>
                                <a class="dropdown-item" href="#">Meus Pedidos</a>
                                <a class="dropdown-item" href="#">Meus Dados</a>
                                <a class="dropdown-item" href="#">Login</a>
                                <a class="dropdown-item" href="#">Criar Conta</a>
                        </div>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#"> Cart(0) </a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                </form>
            </div>
        </nav>

      <!-- Main jumbotron for a primary marketing message or call to action -->
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Seja bem vindo à Livraria OnLine</h1>
                <p>Texto qualquer</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
            </div>
        </div>

        <div class="container">
            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-4">
                    <div class="bookCover"><img src="imgs/covers/cleancode.jpg"/></div>
                    <p>Autor: Robert C. Martim<br> Editora: Campus<br>Preço: 100,00</p>
                    <p><a class="btn btn-secondary bouton-image monBouton" href="#" role="button"></a></p>
                </div>
                <div class="col-md-4">
                    <div class="bookCover"><img src="imgs/covers/designpatterns.jpg"/></div>
                    <p>Autor: Eric Freeman<br> Editora: Campus<br>Preço: 150,00</p>
                    <p><a class="btn btn-secondary bouton-image monBouton" href="#" role="button"></a></p>
                </div>
            </div>
            
            <hr>

            <footer>
                <p>&copy; Company 2017</p>
            </footer>
        </div> <!-- /container -->


      <!-- Bootstrap core JavaScript
      ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>
</html>
