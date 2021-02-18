<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>SocialStats</title>
</head>
<body>
    <img id="logo" src="images/SocialStats.png" alt="SocialStats Logo">
    <form id="formIndex" action="/Search" method="GET">
        <div class="form__group field">
            <input type="input" class="form__field" placeholder="Nombre del juego..." name="name" id='name' required />
            <label for="name" class="form__label">Buscar Juego</label>
            <button type="submit" class="button">Enviar</button> 
        </div>
    </form>
</body>
</html>

