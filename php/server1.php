<?php
header("Content-Type:application/json");
$method=$_SERVER['REQUEST_METHOD'];
switch($method){
    case 'GET':
        # code...
        echo json_encode(array("message"=>"Hello World"));
        break;
    case 'POST':
        $name=$_POST['name'];
        echo json_encode(array("message"=>"Hello ".$name));
        # code...
        break;
    default:
    http_response_code(405);
    echo json_encode(array("message"=>"Method not allowed"));
        break;
    
    
}
?>