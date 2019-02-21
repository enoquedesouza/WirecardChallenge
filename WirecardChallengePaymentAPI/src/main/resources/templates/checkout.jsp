
<!DOCTYPE>

<html lang="pt-BR">

	<head>
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/open-iconic-bootstrap.css">
		<title>Wirecard Challenge Checkout Page</title>
	</head>

	<body>

		<header class="container">

			<div class="jumbotron jumbotron-fluid">
					<h1 class="display-4" align="center">Checkout Page</h1>
			</div>
			
		</header>

		<div class="container">
			<form action="confirmar" method="post">
				<div class="row">
					<input name="id" type="hidden" id="1" value="1" />
					<fieldset class="col-md-6">
						<legend>Dados Pessoais</legend>

							<div class="form-group">
									<label for="nome">Nome Completo</label>
									<input type="text" class="form-control" id="nome" name="nome" autofocus>
							</div>

							<div class="form-group">
									<label for="email">E-mail</label>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text">@</span>
										</div>
										<input type="email" class="form-control" id="email" name="email"placeholder="email@exemplo.com">
									</div>
							</div>

							<div class="form-group">
									<label for="cpf">CPF</label>
									<input type="text" class="form-control" id="cpf" name="cpf" placeholder="000.000.000-00" required>
							</div>

					</fieldset>

					<fieldset class="col-md-6">
						<legend>Dados do Cartão de Crédito</legend>
						
							<div class="form-group">
									<label for="nomecartao">Nome no Cartão</label>
									<input type="text" class="form-control" id="nomecartao" name="nomecartao"
										placeholder="Digite o nome que aparece no cartão de crédito">
							</div>

							<div class="form-group">
									<label for="numerocartao">Número</label>
									<input type="text" class="form-control" id="numerocartao" name="numerocartao">
							</div>

							<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text">CVV</span>
										</div>
										<input type="text" class="form-control" id="cvv" name="cvv"
										placeholder="Digite os três números que aparecem no verso do cartão">
							</div>

							<div class="form-group">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<label class="input-group-text" for="bandeiracartao">Bandeira</label>
										</div>
										<select class="custom-select"  id="bandeiracartao" name="bandeiracartao">
											<option disabled selected>Selecione uma opção...</option>
											<option value="master">MasterCard</option>
											<option value="visa">VISA</option>
										</select>
									</div>
							</div>

							<div class="form-group">
									<label for="validadecartao">Validade</label>
									<input type="month" class="form-control" id="validadecartao" name="validadecartao">
							</div>

					</fieldset>
				</div>

				<div class="row">
					<fieldset class="col-md-4">

						<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text">Valor</span>
										</div>
										<input type="text" id="valor" name="valor" placeholder="0.00">
							</div>

					</fieldset>
					<fieldset class="col-md-4">

						<div class="form-group">

									<label for="tipopagamento">Tipo de Pagamento</label><br>
									<div class="radio">
										 <label><input type="radio" class="input-group-text" name="tipopagamento" value="boleto"> Boleto</label>
									</div>

									<div class="radio">
										 <label><input type="radio" class="input-group-text" name="tipopagamento" value="cartao"> Cartão de Crédito</label>
									</div>
									
						</div>

					</fieldset>

					<fieldset class="col-md-4">

						<div class="botao">
								<button type="submit" class="btn btn-primary btn-lg" id = "bt" align="left">
									<span class="oi-thumb-up"></span>
									Confirmar</button>
						</div>

					</fieldset>

				</div>
			</form>

		</div>
		<footer>

			<div class="container jumbotron">

			</div>

		</footer>
		
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
		<script type="text/javascript" src="js/checkout.js"></script>
	
	</body>



</html>

