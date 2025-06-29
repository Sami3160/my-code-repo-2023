<?php
header('Content-Type: text/html');
if($_SERVER['REQUEST_METHOD']=='POST'){
    if(isset($_FILES['myfile']) && $_FILES['myfile']['error']==0){
        $uploadDir='upload/';
        $filename=basename($_FILES['myfile']['name']);
        if(!file_exists($uploadDir)){
            mkdir($uploadDir);
            
        }
        $uploadPath=$uploadDir.$filename;
        if(move_uploaded_file($_FILES['myfile']['tmp_name'], $uploadPath)){
            echo "File uploaded";
        }else{
            echo "File upload failed";
        }

    }else{
        echo "file not attached";   
    }
}

?>