<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Image</title>
</head>
<body>
<h1>Product ID: ${productId}</h1>
<form action="/uploadImage/{id}" method="post" enctype="multipart/form-data">
    <input type="file" name="file" accept="image/*">
    <button type="submit">Upload</button>
</form>
</body>
</html>
